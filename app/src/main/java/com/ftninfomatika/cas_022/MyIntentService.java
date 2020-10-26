package com.ftninfomatika.cas_022;

import android.app.IntentService;
import android.app.Notification;
import android.content.Intent;
import android.os.Build;
import android.os.SystemClock;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class MyIntentService extends IntentService {
    public static final String TAG = "MyIntentService";
    public static final String MSG_TAG = "msg_tag";
    public static final int NOTIF_ID = 5;

    public MyIntentService(){
        super(TAG);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        showNotificationIfNedeed();
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String msg = intent.getStringExtra(MSG_TAG);

        for (int i = 0; i < 10; i++) {
            SystemClock.sleep(1000);
            Log.e(TAG, msg + " : " + i);
            updateCountDownNotification(i,msg);

        }
    }

    private void showNotificationIfNedeed(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            Notification notification = new NotificationCompat.Builder(this, MyApp.CHANNEL_ID)
                    .setContentTitle("Our IntentService")
                    .setContentText("...Working hard...")
                    .setSmallIcon(R.drawable.ic_launcher_background)
                    .build();
            startForeground(NOTIF_ID, notification);

        }
    }

    private void updateCountDownNotification(int seconds, String string){
        if(Build.VERSION.SDK_INT >=  Build.VERSION_CODES.O){
            Notification notification = new Notification.Builder(this, MyApp.CHANNEL_ID)
                    .setContentTitle("Oir IntentService")
                    .setContentText("...Working hard...")
                    .setSmallIcon(R.drawable.ic_baseline_local_pizza_24)
                    .build();
        }
    }
}
