package com.jiusg.flashlight;

import android.view.View;

public class AnimationLoadingThread implements Runnable {

	private View view;

	public AnimationLoadingThread(View view) {

		this.view = view;
	}

	@Override
	public void run() {

		ShowImage.Showimage_1(ShowImage.GetImage(0, view),
				ShowImage.GetImagePositionX(0), ShowImage.GetImagePositionY(0),
				1300, 300, 0, 1, 0, 1);
		ShowImage.Showimage_1(ShowImage.GetImage(1, view),
				ShowImage.GetImagePositionX(1), ShowImage.GetImagePositionY(1),
				1000, 0, 0.7f, 1, 0.7f, 1);
		ShowImage.Showimage_1(ShowImage.GetImage(2, view),
				ShowImage.GetImagePositionX(2), ShowImage.GetImagePositionY(2),
				1000, 200, 0.1f, 1, 0.1f, 1);
		ShowImage.Showimage_2(ShowImage.GetImage(3, view),
				ShowImage.GetImagePositionX(3), ShowImage.GetImagePositionY(3));
		ShowImage.Showimage_1(ShowImage.GetImage(4, view),
				ShowImage.GetImagePositionX(4), ShowImage.GetImagePositionY(4),
				1500, 0, 0.8f, 1, 0.8f, 1);
		ShowImage.Showimage_2(ShowImage.GetImage(5, view),
				ShowImage.GetImagePositionX(5), ShowImage.GetImagePositionY(5));
		ShowImage.Showimage_1(ShowImage.GetImage(6, view),
				ShowImage.GetImagePositionX(6), ShowImage.GetImagePositionY(6),
				1200, 200, 0, 1, 0, 1);
		ShowImage.Showimage_1(ShowImage.GetImage(7, view),
				ShowImage.GetImagePositionX(7), ShowImage.GetImagePositionY(7),
				1000, 0, 0.8f, 1, 0.8f, 1);
		ShowImage.Showimage_1(ShowImage.GetImage(8, view),
				ShowImage.GetImagePositionX(8), ShowImage.GetImagePositionY(8),
				900, 0, 0.8f, 1, 0.8f, 1);
		ShowImage.Showimage_1(ShowImage.GetImage(9, view),
				ShowImage.GetImagePositionX(9), ShowImage.GetImagePositionY(9),
				1250, 250, 0, 1, 0, 1);
		ShowImage.Showimage_2(ShowImage.GetImage(10, view),
				ShowImage.GetImagePositionX(10), ShowImage.GetImagePositionY(10));
		ShowImage.Showimage_2(ShowImage.GetImage(11, view),
				ShowImage.GetImagePositionX(11), ShowImage.GetImagePositionY(11));
		ShowImage.Showimage_2(ShowImage.GetImage(12, view),
				ShowImage.GetImagePositionX(12), ShowImage.GetImagePositionY(12));
		ShowImage.Showimage_1(ShowImage.GetImage(13, view),
				ShowImage.GetImagePositionX(13), ShowImage.GetImagePositionY(13),
				1000, 300, 0.7f, 1, 0.5f, 1);
		ShowImage.Showimage_1(ShowImage.GetImage(14, view),
				ShowImage.GetImagePositionX(14), ShowImage.GetImagePositionY(14),
				1100, 0, 0.8f, 1, 0.8f, 1);
		ShowImage.Showimage_1(ShowImage.GetImage(15, view),
				ShowImage.GetImagePositionX(15), ShowImage.GetImagePositionY(15),
				1150, 100, 0.5f, 1, 0.5f, 1);
		ShowImage.Showimage_1(ShowImage.GetImage(16, view),
				ShowImage.GetImagePositionX(16), ShowImage.GetImagePositionY(16),
				1350, 100, 0.2f, 1, 0.2f, 1);
		ShowImage.Showimage_1(ShowImage.GetImage(17, view),
				ShowImage.GetImagePositionX(17), ShowImage.GetImagePositionY(17),
				600, 100, 0.5f, 1, 0.5f, 1);
		ShowImage.Showimage_2(ShowImage.GetImage(18, view),
				ShowImage.GetImagePositionX(18), ShowImage.GetImagePositionY(18));
		ShowImage.Showimage_2(ShowImage.GetImage(19, view),
				ShowImage.GetImagePositionX(19), ShowImage.GetImagePositionY(19));
		ShowImage.Showimage_2(ShowImage.GetImage(20, view),
				ShowImage.GetImagePositionX(20), ShowImage.GetImagePositionY(20));
		ShowImage.Showimage_2(ShowImage.GetImage(21, view),
				ShowImage.GetImagePositionX(21), ShowImage.GetImagePositionY(21));
		ShowImage.Showimage_1(ShowImage.GetImage(22, view),
				ShowImage.GetImagePositionX(22), ShowImage.GetImagePositionY(22),
				1300, 300, 0.1f, 1, 0.1f, 1);
		ShowImage.Showimage_2(ShowImage.GetImage(23, view),
				ShowImage.GetImagePositionX(23), ShowImage.GetImagePositionY(23));
		ShowImage.Showimage_1(ShowImage.GetImage(24, view),
				ShowImage.GetImagePositionX(24), ShowImage.GetImagePositionY(24),
				900, 100, 0.7f, 1, 0.7f, 1);
		ShowImage.Showimage_2(ShowImage.GetImage(25, view),
				ShowImage.GetImagePositionX(25), ShowImage.GetImagePositionY(25));
	}
}
