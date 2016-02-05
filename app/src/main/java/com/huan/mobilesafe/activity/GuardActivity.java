package com.huan.mobilesafe.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.huan.mobilesafe.R;

/**
 * 手机防盗页面
 */
public class GuardActivity extends AppCompatActivity {

    private static final String TAG = "GuardActivityInfo";

    private SharedPreferences mSharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //获取配置文件信息 (是否需要进入向导页面，true-->进入向导)
        mSharedPreferences = getSharedPreferences("configuration", MODE_PRIVATE);
        boolean wizard = mSharedPreferences.getBoolean("wizard", true);

        //判断是否进入设置向导
        if (wizard) {
            //跳转到设置向导页面
            //首先销毁当前Activity
            finish();

            startActivity(new Intent(GuardActivity.this, Wizard1Activity.class));
        } else {
            //不进入向导页面
            setContentView(R.layout.activity_guard);
        }
    }
}