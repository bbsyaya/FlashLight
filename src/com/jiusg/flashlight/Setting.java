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
			new AlertDialog.Builder(Setting.this).setTitle("��ʾ")
					.setMessage("\r\n�������Ѿ����,������������������!\r\n\r\n��������һ��ǿ��Ķ���Ӧ��,�������ض��������ȥ������Щ����,�Ӷ��ﵽ�����ֻ���Ŀ��!")
					.setNegativeButton("��������", new OnClickListener() {

						@Override
						public void onClick(DialogInterface dialog, int which) {

							preferences.edit().putBoolean("mss", true).commit();
						}
					}).setPositiveButton("ȥ����", new OnClickListener() {

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
