package com.example.chatapp.Notifications;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.ContextWrapper;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

import androidx.core.app.NotificationCompat;

public class OreoNotification extends ContextWrapper {

    private static final String CHANNEL_ID = "com.example.chatapp";
    private static final String CHANNEL_NAME = "ChatApp";

    private NotificationManager notificationManager;

    public OreoNotification(Context base) {
        super(base);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createChannel();
        }
    }

    @SuppressLint("NewApi")
    private void createChannel() {
        @SuppressLint({"NewApi", "LocalSuppress"}) NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT);
        channel.enableLights(false);
        channel.enableVibration(true);
        channel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);

        getManager().createNotificationChannel(channel);
    }

    public NotificationManager getManager() {
        if (notificationManager == null) {
            notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        }

        return notificationManager;
    }

    public NotificationCompat.Builder getOreoNotification(String title, String body, PendingIntent pendingIntent,
                                                    Uri soundUri, String icon) {
        Log.d("0000000","insidegetOreoNotification" + title + "    " + body);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                    .setContentIntent(pendingIntent)
                    .setContentTitle(title)
                    .setContentText(body)
                    .setSmallIcon(Integer.parseInt(icon))
                    .setSound(soundUri)
                    .setAutoCancel(true)
                    .setChannelId(CHANNEL_ID);
        }

        return null;
    }

}
