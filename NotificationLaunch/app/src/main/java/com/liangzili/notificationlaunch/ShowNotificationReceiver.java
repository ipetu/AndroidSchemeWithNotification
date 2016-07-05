package com.liangzili.notificationlaunch;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

/**
 *Created by liuwf on 05/07/16.
 */
public class ShowNotificationReceiver extends BroadcastReceiver{
    private static final String TAG = "RepeatReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
//        defalut(context);
        NotificationManager notifyManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder builder;
        builder = new NotificationCompat.Builder(context);
        builder.setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.mipmap.ic_launcher))
                .setContentTitle("harvic")
                .setContentText("test schemeURL")
                .setTicker("有新消息")
                .setOngoing(false)
                .setWhen(System.currentTimeMillis())
                .setPriority(Notification.PRIORITY_DEFAULT)
                .setAutoCancel(false);

        Uri uri = Uri.parse("dnx://test.uri.activity?action=1");
        Intent intents = new Intent("android.dnx.schemeurl.activity");
        intents.setData(uri);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intents, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(pendingIntent);
        Notification notification = builder.build();
        notifyManager.notify(1111, notification);
    }

    private void defalut(Context context) {
        Log.d(TAG, "ShowNotificationReceiver onReceive");
        Intent broadcastIntent = new Intent(context, NotificationReceiver.class);
        PendingIntent pendingIntent = PendingIntent.
                getBroadcast(context, 0, broadcastIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        builder.setContentTitle("这就是通知的头")
                .setTicker("这是通知的ticker")
                .setContentIntent(pendingIntent)
                .setSmallIcon(android.R.drawable.ic_lock_idle_charging);

        Log.i("repeat", "showNotification");
        NotificationManager manager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(2, builder.build());
    }
}
