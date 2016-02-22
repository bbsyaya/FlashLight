package com.jiusg.flashlight;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

/**
 * 图片的动画加载类
 * 
 * @author Administrator
 * 
 */
public class ShowImage {

	/**
	 * Image的放大和缩小动画
	 * 
	 * @param image
	 * @param positionX
	 * @param positionY
	 * @param Duration
	 *            动画持续时间
	 * @param StartOffset
	 *            停留时间
	 */
	public static void Showimage_1(ImageView image, int positionX,
			int positionY, int Duration, int StartOffset, float fromX,
			float toX, float fromY, float toY) {

		AnimationSet animationSet = new AnimationSet(true);
		ScaleAnimation scaleanimation = new ScaleAnimation(fromX, toX, fromY,
				toY, Animation.RELATIVE_TO_SELF, 0.5f,
				Animation.RELATIVE_TO_SELF, 0.5f);
		scaleanimation.setDuration(Duration);
		scaleanimation.setStartOffset(StartOffset);
		scaleanimation.setRepeatCount(Animation.INFINITE);
		scaleanimation.setRepeatMode(Animation.REVERSE);
		animationSet.addAnimation(scaleanimation);
		image.startAnimation(animationSet);
		WidgetController.setLayout(image, positionX, positionY);
	}

	/**
	 * Image的静态位置
	 * 
	 * @param image
	 * @param positionX
	 * @param positionY
	 */
	public static void Showimage_2(ImageView image, int positionX, int positionY) {

		WidgetController.setLayout(image, positionX, positionY);

	}

	/**
	 * 获取Image的位置X
	 * 
	 * @param num
	 *            序号
	 * @return
	 */
	public static int GetImagePositionX(int num) {

		switch (num) {
		case 0:
			return FLActivity.screenwidth / 4 * 3;
		case 1:
			return FLActivity.screenwidth / 100 * 72;
		case 2:
			return FLActivity.screenwidth / 3;
		case 3:
			return FLActivity.screenwidth / 40 * 33;
		case 4:
			return FLActivity.screenwidth / 20 * 11;
		case 5:
			return FLActivity.screenwidth / 17;
		case 6:
			return FLActivity.screenwidth / 10;
		case 7:
			return FLActivity.screenwidth / 20 * 8;
		case 8:
			return FLActivity.screenwidth / 50 * 33;
		case 9:
			return FLActivity.screenwidth / 5 * 3;
		case 10:
			return FLActivity.screenwidth / 15 * 7;
		case 11:
			return FLActivity.screenwidth / 30 * 13;
		case 12:
			return FLActivity.screenwidth / 20 * 19;
		case 13:
			return FLActivity.screenwidth / 20 * 17;
		case 14:
			return FLActivity.screenwidth / 80 * 67;
		case 15:
			return FLActivity.screenwidth / 20 * 5;
		case 16:
			return FLActivity.screenwidth / 5;
		case 17:
			return FLActivity.screenwidth / 25 * 4;
		case 18:
			return FLActivity.screenwidth / 25 * 2;
		case 19:
			return FLActivity.screenwidth / 25;
		case 20:
			return FLActivity.screenwidth / 50 * 7;
		case 21:
			return FLActivity.screenwidth / 50 * 11;
		case 22:
			return FLActivity.screenwidth / 50 * 14;
		case 23:
			return FLActivity.screenwidth / 10 * 6;
		case 24: 
			return FLActivity.screenwidth / 15 * 14;
		case 25:
			return FLActivity.screenwidth / 15 * 11;
		default:
			break;
		}
		return num;
	}

	/**
	 * 获取Image的位置Y
	 * 
	 * @param num
	 *            序号
	 * @return
	 */
	public static int GetImagePositionY(int num) {

		switch (num) {
		case 0:
			return FLActivity.screenheight / 5;
		case 1:
			return FLActivity.screenheight / 6;
		case 2:
			return FLActivity.screenheight / 10;
		case 3:
			return FLActivity.screenheight / 10 * 3;
		case 4:
			return FLActivity.screenheight / 5;
		case 5:
			return FLActivity.screenheight / 20;
		case 6:
			return FLActivity.screenheight / 4;
		case 7:
			return FLActivity.screenheight / 40 * 11;
		case 8:
			return FLActivity.screenheight / 50 * 11;
		case 9:
			return FLActivity.screenheight / 40;
		case 10:
			return FLActivity.screenheight / 40 * 3;
		case 11:
			return FLActivity.screenheight / 20 * 3;
		case 12:
			return FLActivity.screenheight / 30;
		case 13:
			return FLActivity.screenheight / 15;
		case 14:
			return FLActivity.screenheight / 40 * 5;
		case 15:
			return FLActivity.screenheight / 18;
		case 16:
			return FLActivity.screenheight / 50 * 17;
		case 17:
			return FLActivity.screenheight / 100 * 14;
		case 18:
			return FLActivity.screenheight / 100 * 9;
		case 19:
			return FLActivity.screenheight / 100 * 17;
		case 20:
			return FLActivity.screenheight / 100 * 21;
		case 21:
			return FLActivity.screenheight / 100 * 29; 
		case 22:
			return FLActivity.screenheight / 100 * 18;
		case 23:
			return FLActivity.screenheight / 100 * 13;
		case 24:
			return FLActivity.screenheight / 100 * 19;
		case 25:
			return FLActivity.screenheight / 100 * 7;
		default:
			break;
		}
		return num;
	}

	/**
	 * 获取Image的对象
	 * 
	 * @param num
	 *            序号
	 * @param view
	 * @return
	 */
	public static ImageView GetImage(int num, View view) {

		switch (num) {
		case 0:
			return (ImageView) view.findViewById(R.id.image_0);
		case 1:
			return (ImageView) view.findViewById(R.id.image_1);
		case 2:
			return (ImageView) view.findViewById(R.id.image_2);
		case 3:
			return (ImageView) view.findViewById(R.id.image_3);
		case 4:
			return (ImageView) view.findViewById(R.id.image_4);
		case 5:
			return (ImageView) view.findViewById(R.id.image_5);
		case 6:
			return (ImageView) view.findViewById(R.id.image_6);
		case 7:
			return (ImageView) view.findViewById(R.id.image_7);
		case 8:
			return (ImageView) view.findViewById(R.id.image_8);
		case 9:
			return (ImageView) view.findViewById(R.id.image_9);
		case 10:
			return (ImageView) view.findViewById(R.id.image_10);
		case 11:
			return (ImageView) view.findViewById(R.id.image_11);
		case 12:
			return (ImageView) view.findViewById(R.id.image_12);
		case 13:
			return (ImageView) view.findViewById(R.id.image_13);
		case 14:
			return (ImageView) view.findViewById(R.id.image_14);
		case 15:
			return (ImageView) view.findViewById(R.id.image_15);
		case 16:
			return (ImageView) view.findViewById(R.id.image_16);
		case 17:
			return (ImageView) view.findViewById(R.id.image_17);
		case 18:
			return (ImageView) view.findViewById(R.id.image_18);
		case 19:
			return (ImageView) view.findViewById(R.id.image_19);
		case 20:
			return (ImageView) view.findViewById(R.id.image_20);
		case 21:
			return (ImageView) view.findViewById(R.id.image_21);
		case 22:
			return (ImageView) view.findViewById(R.id.image_22);
		case 23:
			return (ImageView) view.findViewById(R.id.image_23);
		case 24:
			return (ImageView) view.findViewById(R.id.image_24);
		case 25:
			return (ImageView) view.findViewById(R.id.image_25);

		default:
			break;

		}
		return null;

	}
}
