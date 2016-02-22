package com.jiusg.flashlight;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.PixelFormat;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
/**
 * FlashLight Service
 * @author Administrator
 *
 */
public class FLService extends Service {

	private WindowManager Wm;
	private WindowManager Wm_stop;  // 关闭手电筒的按钮
	private static Timer timer;
	private View win;
	private View win_stop;
	private WindowManager.LayoutParams wmParams;
	private WindowManager.LayoutParams wmParams_stop;
	private List<String> homeList; // 桌面应用程序包名
	private ActivityManager mActivityManager;
	private static int ADDED_IS = 100; // 已增加悬浮窗
	private static int ADDED_NO = 101; // 悬浮窗已消失
	private static int ADDED_STOP = 103; // 停止悬浮窗
	private static int isAdded;
	private static boolean isAddno = false; // 悬浮窗是否已经消失
	private Handler mHandler;
	private NotificationManager nm;
	private SharedPreferences setting;
	

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressLint("InflateParams")
	@SuppressWarnings("deprecation")
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		
		setting = PreferenceManager
				.getDefaultSharedPreferences(getApplication());
		
		homeList = getHomes();
		mHandler = new Mhandler();
		Wm = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
		win = LayoutInflater.from(this).inflate(R.layout.ctrl_window, null);
		wmParams = new WindowManager.LayoutParams();
		wmParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY;
		wmParams.format = PixelFormat.RGBA_8888;
		wmParams.alpha = 0.8f;
		wmParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
		wmParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
		
		Wm_stop = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
		wmParams_stop = new WindowManager.LayoutParams();
		wmParams_stop.type = WindowManager.LayoutParams.TYPE_SYSTEM_ERROR;
		wmParams_stop.format = PixelFormat.RGBA_8888;
		wmParams_stop.alpha = 0.5f;
		wmParams_stop.width = ViewGroup.LayoutParams.WRAP_CONTENT;
		wmParams_stop.height = ViewGroup.LayoutParams.WRAP_CONTENT;
		wmParams_stop.gravity = Gravity.BOTTOM | Gravity.RIGHT;
		wmParams_stop.x = wmParams_stop.y = 0;
		wmParams_stop.flags = WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
				| WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
				| WindowManager.LayoutParams.FLAG_WATCH_OUTSIDE_TOUCH;
		ImageView img= new ImageView(this);
		img.setImageResource(R.drawable.ic_launcher);
		win_stop = img;
		if(setting.getBoolean("Switch", true)){
			Wm_stop.addView(win_stop, wmParams_stop);
			
			win_stop.setOnLongClickListener(new OnLongClickListener() {
				
				@Override
				public boolean onLongClick(View v) {

					return true;
				}
			});
			
//			win_stop.setOnTouchListener(new OnTouchListener() {
//				
//				@Override
//				public boolean onTouch(View v, MotionEvent event) {
//					int lastX, lastY;
//					switch (event.getAction()) {
//					case MotionEvent.ACTION_DOWN:
//						lastX = (int) event.getRawX();// 获取触摸事件触摸位置的原始X坐标
//						lastY = (int) event.getRawY();
//						break;
//					case MotionEvent.ACTION_MOVE:
//						System.out.println(event.getX());
//						break;
//					case MotionEvent.ACTION_UP:
//						break;
//					default:
//						break;
//					}
//					return true;
//				}
//			});
		}
		
		final SharedPreferences preferences = getSharedPreferences("tip", 0);
		String tip = "手电筒已开启";
		if(!preferences.getBoolean("mss", false)){
			tip="提示:桌面秀已免费,过往诚邀您下载体验!";
		}
		
		// 通知栏显示
		nm = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);  
		Notification n = new Notification(R.drawable.ic_launcher, tip, System.currentTimeMillis());            
		n.flags = Notification.FLAG_AUTO_CANCEL;               
		Intent i = new Intent(this, Setting.class);
		i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_NEW_TASK); 
		//PendingIntent
		PendingIntent contentIntent = PendingIntent.getActivity(
		        this,
		        R.string.app_name,
		        i,
		        PendingIntent.FLAG_UPDATE_CURRENT);
		                 
		n.setLatestEventInfo(
		        this,
		        "手电筒",
		        "点此设定手电筒",
		        contentIntent);
		nm.notify(R.string.app_name, n);
		//nm.cancelAll();
	}

	@Override
	public void onDestroy() {

		
		isAdded = ADDED_STOP;
		nm.cancelAll();
		super.onDestroy();
		System.exit(0);
		
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {

		TimerTask task = new TimerTask() {
			public void run() {

				Message msg1 = mHandler.obtainMessage();
				msg1.obj = ("start");
				mHandler.sendMessage(msg1);
			}
		};
		isAdded = ADDED_NO;
		timer = new Timer(true);
		if(setting.getBoolean("StarShine", true))
			timer.schedule(task, 0, 1000);
		win_stop.setOnClickListener(new android.view.View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				

				startActivity(new Intent(FLService.this, FLActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
			}
		});
		return START_NOT_STICKY;
	}

	/**
	 * 获得属于桌面的应用的应用包名称
	 * 
	 * @return 返回包含所有包名的字符串列表
	 */
	private List<String> getHomes() {
		List<String> names = new ArrayList<String>();
		PackageManager packageManager = this.getPackageManager();
		// 属性
		Intent intent = new Intent(Intent.ACTION_MAIN);
		intent.addCategory(Intent.CATEGORY_HOME);
		List<ResolveInfo> resolveInfo = packageManager.queryIntentActivities(
				intent, PackageManager.MATCH_DEFAULT_ONLY);
		for (ResolveInfo ri : resolveInfo) {
			names.add(ri.activityInfo.packageName);
		}
		names.add("com.jiusg.flashlight"); // 添加自己软件的包名
		return names;
	}

	/**
	 * 判断当前界面是否是桌面
	 */
	public boolean isHome() {

		if (mActivityManager == null) {
			mActivityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
		}
		List<RunningTaskInfo> rti = mActivityManager.getRunningTasks(1);
		return homeList.contains(rti.get(0).topActivity.getPackageName());
	}

	@SuppressLint("HandlerLeak")
	class Mhandler extends Handler {

		@Override
		public void handleMessage(Message msg) {

			if (isAdded == ADDED_STOP) {

				timer.cancel();
				if (!isAddno)
					Wm.removeView(win);

			}

			if (isHome()) {
				if (isAdded == ADDED_NO) {
					Wm.addView(win, wmParams);
					isAdded = ADDED_IS;
					isAddno = false;
					AnimationLoadingThread alt = new AnimationLoadingThread(win);
					Thread T = new Thread(alt);
					T.start();
				}
			} else {
				if (isAdded == ADDED_IS) {
					Wm.removeView(win);
					isAdded = ADDED_NO;
					isAddno = true;
				}
			}

		}

	}
}
