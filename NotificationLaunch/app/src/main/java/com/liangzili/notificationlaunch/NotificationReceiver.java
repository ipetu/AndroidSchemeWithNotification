package com.liangzili.notificationlaunch;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

/**
 *Created by liuwf on 05/07/16.
 */
public class NotificationReceiver extends BroadcastReceiver{

    @Override
    public void onReceive(Context context, Intent intent) {
        //判断app进程是否存活
        if(SystemUtils.isAppAlive(context, "com.liangzili.notificationlaunch")){
            Log.i("NotificationReceiver", "the app process is alive");
            Intent mainIntent = new Intent(context, MainActivity.class);
            mainIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            Intent detailIntent = new Intent(context, DetailActivity.class);
            detailIntent.putExtra("name", "电饭锅");
            detailIntent.putExtra("price", "58元");
            detailIntent.putExtra("detail", "这是一个好锅, 这是app进程存在，直接启动Activity的");

            Intent[] intents = {mainIntent, detailIntent};

            context.startActivities(intents);
        }else {
            Log.i("NotificationReceiver", "the app process is dead");
            Intent launchIntent = context.getPackageManager().
                    getLaunchIntentForPackage("com.liangzili.notificationlaunch");
            launchIntent.setFlags(
                    Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
            Bundle args = new Bundle();
            args.putString("name", "电饭锅");
            args.putString("price", "58元");
            args.putString("detail", "这是一个好锅, 这是app进程不存在，先启动应用再启动Activity的");
            launchIntent.putExtra(Constants.EXTRA_BUNDLE, args);
            context.startActivity(launchIntent);
        }
    }



}
