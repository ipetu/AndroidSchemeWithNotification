package com.liangzili.notificationlaunch;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;

/**
 *Created by liuwf on 05/07/16.
 */
public class SplashActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                if(getIntent().getBundleExtra(Constants.EXTRA_BUNDLE) != null){
                    intent.putExtra(Constants.EXTRA_BUNDLE,
                            getIntent().getBundleExtra(Constants.EXTRA_BUNDLE));
                }
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}
