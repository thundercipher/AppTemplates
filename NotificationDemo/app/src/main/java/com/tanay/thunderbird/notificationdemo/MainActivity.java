package com.tanay.thunderbird.notificationdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //to tell the app what to do when the notification is tapped on
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), 1, intent, 0);            //here, it just opens the MainActivity

        Notification notification = new Notification.Builder(getApplicationContext())
                .setContentTitle("Lunch is ready")
                .setContentText("Come fast or it'll get cold")
                .setContentIntent(pendingIntent)
                .addAction(android.R.drawable.sym_action_chat, "Chat", pendingIntent)                                           //we can give a different pendingIntent here
                .setSmallIcon(android.R.drawable.sym_def_app_icon)
                .build();

        //to display the notification
        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(1, notification);                    //doesn't need to be 1 here, any number would do
    }
}
