package com.six.myresume;

import android.app.ActionBar;
import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

public class OtherActivity extends Activity {

	private ActionBar actionBar;
	private TextView actionTitle;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		actionBar = getActionBar();
		actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		actionBar.setCustomView(R.layout.actionbar_main);// 自定义ActionBar布局
		actionTitle = (TextView) actionBar.getCustomView().findViewById(
				R.id.ActionBarTitle);
		// 设置返回监听
		actionBar.getCustomView().findViewById(R.id.action_back)
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						onBackPressed();// 返回

					}
				});


		TextView tv = new TextView(getApplicationContext());
		tv.setTextColor(Color.BLACK);
		int id = getIntent().getIntExtra("id", 0);
		switch (id) {
			case 1:
				//tv.setText(getCallME());
				setContentView(R.layout.activity_aboutme);
				actionTitle.setText("联系我");
				break;
			case 2:
				tv.setText(getAbout());
				actionTitle.setText("关于");
				setContentView(tv);
				break;
			default:
				actionTitle.setText("异常页面");
				break;
		}

		//setContentView(tv);
	}


	public void cilck(View v){
		switch (v.getId()) {
			case R.id.phone:
				Uri uri = Uri.parse("tel:18819352783");
				Intent i = new Intent(Intent.ACTION_DIAL, uri);
				startActivity(i);
				break;
			case R.id.sms:
				Uri uri2 = Uri.parse("smsto:18819352783");
				Intent i2 = new Intent(Intent.ACTION_SENDTO,uri2);
				i2.putExtra("sms_body", "我通过你的应用《我的简历》联系到你，我们公司有个合适你的岗位，希望你明天可以到我们公司面试，时间：_____，地点：_____");
				startActivity(i2);
				break;
			case R.id.mail:
				Uri uri3 = Uri.parse("mailto:18218601735@139.com");
				Intent i3 = new Intent(Intent.ACTION_SENDTO, uri3);
				i3.putExtra(Intent.EXTRA_EMAIL, "18218601735@139.com");
				i3.putExtra(Intent.EXTRA_TEXT, "我通过你的应用《我的简历》联系到你，我们公司有个合适你的岗位，希望你明天可以到我们公司面试，时间：_____，地点：_____");
				i3.putExtra(Intent.EXTRA_SUBJECT, "面试邀请");
				startActivity(i3);
				break;
			case R.id.qq:
				try {
					getPackageManager().getPackageInfo("com.tencent.mobileqq", PackageManager.GET_ACTIVITIES);
					Uri uri4 = Uri.parse("mqqwpa://im/chat?chat_type=wpa&uin=979537574");
					Intent i4 = new Intent(Intent.ACTION_VIEW, uri4);
					startActivity(i4);
				} catch (NameNotFoundException e) {
					Toast.makeText(getApplicationContext(), "请先安装最新版手机QQ", Toast.LENGTH_SHORT).show();

				}

				break;
			case R.id.copy:
				ClipboardManager clipboardManager = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
				clipboardManager.setText("姓名：李华斌\n求职意向：安卓工程师\n电话：18819352783\n邮箱：18218601735@139.com\nqq:979537574\n--来自李华斌作品《我的简历》APP");
				Toast.makeText(getApplicationContext(), "复制到剪贴板成功 ^o^", Toast.LENGTH_SHORT).show();
				break;
			default:
				break;
		}
	}





	String getAbout(){
		return "\t\t\t\t本App专为面试而做。App从个人信息、参与项目、在校情况、资格证书等方面介绍自我，希望成为一份满意工作的敲门砖。\n\n\t\t\t\tApp使用AnimatedExpandableListView开源库\n\t\t\t\t自定义ActionBar\n\t\t\t\t并重新美化AnimatedExpandableListView\n\t\t\t\t跳转Activity动态传递参数改变布局\n\t\t\t\t适应多种分辨率设备\n\t\t\t\t采用intent调用系统电话、信息等功能\n\t\t\t\t并利用剪贴板临时保存数据。";
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
//		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
}
