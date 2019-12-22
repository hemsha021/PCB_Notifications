package com.example.notifications;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button notification1;
    Button notification2;
    Button notification3;
    Button notification4;
    Button notification5;
    Button notification6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notification1 = findViewById(R.id.simple_notification);
        notification2 = findViewById(R.id.action_notification);
        notification3 = findViewById(R.id.expandable_notification);
        notification4 = findViewById(R.id.group_notification);
        notification5 = findViewById(R.id.service_notification);
        notification6 = findViewById(R.id.activity_notification);


        //Creating Channels for notifications
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            //Channel for Simple Notification
            NotificationChannel simpleChannel = new NotificationChannel("SIMPLE",getString(R.string.simple_channel_name), NotificationManager.IMPORTANCE_HIGH);
            simpleChannel.setDescription(getString(R.string.simple_channel_description));

            NotificationManager simpleNotificationManager = getSystemService(NotificationManager.class);
            simpleNotificationManager.createNotificationChannel(simpleChannel);

            //Channel for Action Notification
            NotificationChannel actionChannel = new NotificationChannel("ACTION",getString(R.string.action_channel_name), NotificationManager.IMPORTANCE_HIGH);
            actionChannel.setDescription(getString(R.string.action_channel_description));

            NotificationManager actionNotificationManager = getSystemService(NotificationManager.class);
            actionNotificationManager.createNotificationChannel(actionChannel);

            //Channel for Expandable Notification
            NotificationChannel expandableChannel = new NotificationChannel("EXPANDABLE",getString(R.string.expandable_channel_name), NotificationManager.IMPORTANCE_HIGH);
            expandableChannel.setDescription(getString(R.string.expandable_channel_description));

            NotificationManager expandableNotificationManager = getSystemService(NotificationManager.class);
            expandableNotificationManager.createNotificationChannel(expandableChannel);

            //Channel for Group Notification
            NotificationChannel groupChannel = new NotificationChannel("GROUP",getString(R.string.group_channel_name), NotificationManager.IMPORTANCE_HIGH);
            groupChannel.setDescription(getString(R.string.group_channel_description));

            NotificationManager groupNotificationManager = getSystemService(NotificationManager.class);
            groupNotificationManager.createNotificationChannel(groupChannel);

            //Channel for Foreground Service Notification
            NotificationChannel foregroundChannel = new NotificationChannel("FOREGROUND",getString(R.string.foreground_channel_name), NotificationManager.IMPORTANCE_HIGH);
            foregroundChannel.setDescription(getString(R.string.foreground_channel_description));

            NotificationManager foregroundNotificationManager = getSystemService(NotificationManager.class);
            foregroundNotificationManager.createNotificationChannel(foregroundChannel);

            //Channel for Activity Notification
            NotificationChannel activityChannel = new NotificationChannel("ACTIVITY",getString(R.string.activity_channel_name), NotificationManager.IMPORTANCE_HIGH);
            activityChannel.setDescription(getString(R.string.activity_channel_description));

            NotificationManager activityNotificationManager = getSystemService(NotificationManager.class);
            activityNotificationManager.createNotificationChannel(activityChannel);
        }


        //Simple Notification
        notification1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getBaseContext(),"Simple Notification",Toast.LENGTH_LONG).show();
                NotificationCompat.Builder mBuillder = new NotificationCompat.Builder(MainActivity.this,"SIMPLE")
                            .setSmallIcon(R.drawable.call)
                            .setContentTitle("Simple Notification")
                            .setContentText("This ia a simple Notification with HIGH Priority and Channel ID")
                            .setPriority(NotificationCompat.PRIORITY_HIGH);

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MainActivity.this);
                managerCompat.notify(1,mBuillder.build());
            }
        });


        //Action Notification
        notification2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getBaseContext(),"Action Notification",Toast.LENGTH_LONG).show();
                //Many more things you can do here like snooze or reply
                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);

                NotificationCompat.Builder mBuillder = new NotificationCompat.Builder(MainActivity.this,"ACTION")
                        .setSmallIcon(R.drawable.call)
                        .setContentTitle("Action Notification")
                        .setContentText("This ia a Action Notification with HIGH Priority and Channel ID = ACTION")
                        .setContentIntent(pendingIntent)
                        .addAction(R.drawable.open_activity,"Open Activity",pendingIntent)
                        .setPriority(NotificationCompat.PRIORITY_HIGH);

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MainActivity.this);
                managerCompat.notify(1,mBuillder.build());


            }
        });

        //Expandable Notification
        notification3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getBaseContext(),"Expandable Notification",Toast.LENGTH_LONG).show();
                NotificationCompat.Builder mBuillder = new NotificationCompat.Builder(MainActivity.this,"EXPANDABLE")
                        .setSmallIcon(R.drawable.call)
                        .setContentTitle("Expandable Notification")
                        .setContentText("This ia an Expandable Notification with HIGH Priority and Channel ID with lots and lots of text like in mail or messaging app")
                        .setStyle(new NotificationCompat.BigTextStyle().bigText("This ia an Expandable Notification with HIGH Priority and Channel ID with lots and lots of text like in mail or messaging app"))
                        .setPriority(NotificationCompat.PRIORITY_HIGH);

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MainActivity.this);
                managerCompat.notify(2,mBuillder.build());
            }
        });

        //Group Notification
        notification4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"Group Notification",Toast.LENGTH_LONG).show();


            }
        });

        //Foreground Service Notification
        notification5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"Foreground Service Notification",Toast.LENGTH_LONG).show();
            }
        });

        //Open Activity Notification
        notification6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"Open Activity Notification",Toast.LENGTH_LONG).show();

                //Create Intent
                Intent intent = new Intent(MainActivity.this,MainActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);

                NotificationCompat.Builder mBuillder = new NotificationCompat.Builder(MainActivity.this,"ACTIVITY")
                        .setSmallIcon(R.drawable.call)
                        .setContentTitle("Activity Notification")
                        .setContentText("This ia an Activity Notification with HIGH Priority and Channel ID equals to ACTIVITY  with lots and lots of text like in mail or messaging app")
                        .setStyle(new NotificationCompat.BigTextStyle().bigText("This ia an Activity Notification with HIGH Priority and Channel ID equals to ACTIVITY with lots and lots of text like in mail or messaging app"))
                        .setContentIntent(pendingIntent)
                        .setPriority(NotificationCompat.PRIORITY_HIGH);

                NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MainActivity.this);
                managerCompat.notify(3,mBuillder.build());
            }
        });

    }
}
