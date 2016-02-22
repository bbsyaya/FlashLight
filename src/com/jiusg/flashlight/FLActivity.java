package com.jiusg.flashlight;

import java.util.Timer;
import java.util.TimerTask;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.DialogInterface.OnClickListener;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.util.DisplayMetrics;

public class FLActivity extends Activity {

	private static Handler handler;
	private static Timer timer_close; // 关闭手电筒的计时器
	private static Camera camera;
	private static boolean isopen = false;
	public static int screenwidth;
	public static int screenheight; // 除去状态栏的高度
	private Intent it;
	private SharedPreferences setting;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// 获取当前设备的屏幕大小
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		screenwidth = dm.widthPixels;
		screenheight = dm.heightPixels - getStatusBarHeight(); 
		
		setting = PreferenceManager
				.getDefaultSharedPreferences(getApplication());

		it = new Intent();
		it.setClass(FLActivity.this, FLService.class);
		handler = new TimerHandler(it);

		TimerTask task_close = new TimerTask() {
			public void run() {

				Message msg1 = handler.obtainMessage();
				msg1.obj = ("close");
				handler.sendMessage(msg1);
			}
		};

		if (!isopen) {

			camera = Camera.open();

			Parameters params = camera.getParameters();
			params.setFlashMode(Parameters.FLASH_MODE_TORCH);
			camera.setParameters(params);
			camera.startPreview();
			startService(it);
			isopen = true;
			timer_close = new Timer(true);
			if(setting.getBoolean("Time", false))
				timer_close.schedule(task_close, 300000, 1000);

		} else {

			/*
			 * camera.stopPreview(); camera.release(); timer_close.cancel();
			 * isopen = false; stopService(it); finish(); System.exit(0);
			 */
			stopFlashLight();
		}
		
		finish();

	}

	@SuppressLint("HandlerLeak")
	class TimerHandler extends Handler {

		private Intent it;

		public TimerHandler(Intent it) {
			this.it = it;
		}

		@Override
		public void handleMessage(Message msg) {

			camera.stopPreview();
			camera.release();
			isopen = false;
			timer_close.cancel();
			stopService(it);
		}

	}

	/**
	 * 获取顶栏的高度
	 * 
	 * @return
	 */
	public int getStatusBarHeight() {
		Class<?> c = null;
		Object obj = null;
		java.lang.reflect.Field field = null;
		int x = 0;
		int statusBarHeight = 0;
		try {
			c = Class.forName("com.android.internal.R$dimen");
			obj = c.newInstance();
			field = c.getField("status_bar_height");
			x = Integer.parseInt(field.get(obj).toString());
			statusBarHeight = getResources().getDimensionPixelSize(x);
			return statusBarHeight;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return statusBarHeight;
	}

	public void stopFlashLight() {

		camera.stopPreview();
		camera.release();
		timer_close.cancel();
		isopen = false;
		stopService(it);
		finish();
		//System.exit(0);
	}



}
