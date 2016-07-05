package com.liangzili.notificationlaunch;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

/**
 *Created by liuwf on 05/07/16.
 */
public class BActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.b_main);
        Uri uri = getIntent().getData();
        if (uri != null) {
            List<String> pathSegments = uri.getPathSegments();
            String uriQuery = uri.getQuery();
            if (pathSegments != null && pathSegments.size() > 0) {
                // 解析SCHEME
                Log.e("doSome", "----");
            }
        } else {
            finish();
        }
    }
}
