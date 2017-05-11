package com.six.myresume;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.copyactivity_main);
        getActionBar().setBackgroundDrawable(getResources().getDrawable(R.drawable.bule_me));
    }

    public void click(View view) {

        switch (view.getId()) {
            case R.id.AboutME://我的资料
            case R.id.AboutMeText:
                startActivity(new Intent(this, ContentActivity.class).putExtra("id", 1));
                //Toast.makeText(getApplicationContext(),"我的资料",Toast.LENGTH_LONG).show();
                break;
            case R.id.MyObject://参与项目
            case R.id.MyObjectText:
                startActivity(new Intent(this, ContentActivity.class).putExtra("id", 2));
                // Toast.makeText(getApplicationContext(),"参与项目",Toast.LENGTH_LONG).show();
                break;
            case R.id.Awards://在校情况
            case R.id.AwardsText:
                startActivity(new Intent(this, ContentActivity.class).putExtra("id", 3));
                //Toast.makeText(getApplicationContext(),"在校情况",Toast.LENGTH_LONG).show();
                break;
            case R.id.Certificate://资格证书
            case R.id.CertificateText:
                startActivity(new Intent(this, ContentActivity.class).putExtra("id", 4));
                //Toast.makeText(getApplicationContext(),"资格证书",Toast.LENGTH_LONG).show();
                break;
            case R.id.AbouteDucation://联系我
            case R.id.AbouteDucationText:
                startActivity(new Intent(this, OtherActivity.class).putExtra("id", 1));
                //Toast.makeText(getApplicationContext(),"联系我",Toast.LENGTH_LONG).show();
                break;


            case R.id.CallMe://关于
            case R.id.CallMeText:
                startActivity(new Intent(this, OtherActivity.class).putExtra("id", 2));
                //Toast.makeText(getApplicationContext(),"关于",Toast.LENGTH_LONG).show();
                break;


        }
    }

    public void doCall(View v) {
        Uri uri = Uri.parse("tel:18819352783");
        Intent i = new Intent(Intent.ACTION_DIAL, uri);
        startActivity(i);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_call:
                Uri uri = Uri.parse("tel:18819352783");
                Intent i = new Intent(Intent.ACTION_DIAL, uri);
                startActivity(i);
                break;
            case R.id.menu_sms:
                Uri uri2 = Uri.parse("smsto:18819352783");
                Intent i2 = new Intent(Intent.ACTION_SENDTO,uri2);
                i2.putExtra("sms_body", "我通过你的应用《我的简历》联系到你，我们公司有个合适你的岗位，希望你明天可以到我们公司面试，时间：_____，地点：_____");
                startActivity(i2);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
