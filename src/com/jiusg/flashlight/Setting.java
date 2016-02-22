package com.jiusg.flashlight;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceScreen;
import android.preference.Preference.OnPreferenceClickListener;

public class Setting extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getFragmentManager().beginTransaction()
				.replace(android.R.id.content, new SettingFragment()).commit();

		final SharedPreferences preferences = getSharedPreferences("tip", 0);

		if (!preferences.getBoolean("mss", false)) {
			new AlertDialog.Builder(Setting.this).setTitle("提示")
					.setMessage("\r\n桌面秀已经免费,过往诚邀您下载体验!\r\n\r\n桌面秀是一款强大的动画应用,可以在特定的情况下去触发这些动画,从而达到美化手机的目的!")
					.setNegativeButton("不再提醒", new OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {

							preferences.edit().putBoolean("mss", true).commit();
						}
					}).setPositiveButton("去看看", new OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							String appIdentify = "1d56f2d8ea07440abbec2511b5f59ac1";
							Uri appUri = Uri
									.parse("mstore:http://app.meizu.com/phone/apps/"
											+ appIdentify);
							Intent intent = new Intent(Intent.ACTION_VIEW,
									appUri);
							startActivity(intent);
						}
					}).show();
		}

	}

	class SettingFragment extends PreferenceFragment {

		private PreferenceScreen lockhelper;
		private PreferenceScreen mainscreenshow;

		@Override
		public void onCreate(Bundle savedInstanceState) {

			super.onCreate(savedInstanceState);
			addPreferencesFromResource(R.xml.setting);

			lockhelper = (PreferenceScreen) findPreference("LockHelper");
			mainscreenshow = (PreferenceScreen) findPreference("MainScreenShow");

			lockhelper
					.setOnPreferenceClickListener(new OnPreferenceClickListener() {

						@Override
						public boolean onPreferenceClick(Preference preference) {
							String appIdentify = "360f07008a874b078626604f4ba99a7f";
							Uri appUri = Uri
									.parse("mstore:http://app.meizu.com/phone/apps/"
											+ appIdentify);
							Intent intent = new Intent(Intent.ACTION_VIEW,
									appUri);
							startActivity(intent);
							return true;
						}
					});
			mainscreenshow
					.setOnPreferenceClickListener(new OnPreferenceClickListener() {

						@Override
						public boolean onPreferenceClick(Preference preference) {
							String appIdentify = "1d56f2d8ea07440abbec2511b5f59ac1";
							Uri appUri = Uri
									.parse("mstore:http://app.meizu.com/phone/apps/"
											+ appIdentify);
							Intent intent = new Intent(Intent.ACTION_VIEW,
									appUri);
							startActivity(intent);
							return true;
						}
					});
		}

	}

}
