package com.iulbpns.lbpnsandroid;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.location.LocationManager;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

/**
 * Created by Asad 15R on 11/9/2015.
 */
public class GeofenceReceiver extends BroadcastReceiver {

    private static final double LATITUDE = 25.020588;
    private static final double LONGITUDE = 67.132638;

    @Override
    public void onReceive(Context context, Intent intent) {

        String key = LocationManager.KEY_PROXIMITY_ENTERING;
        boolean state = intent.getBooleanExtra(key,false);

        if(state){

            // Uri mapIntent  = Uri.parse("geo:"+LATITUDE+","+LONGITUDE);
            Uri mapIntent = Uri.parse("google.navigation:q=" +LATITUDE + "," +LONGITUDE );
            Intent mIntent = new Intent(Intent.ACTION_VIEW,mapIntent);
            intent.setPackage("com.google.android.apps.maps");


            PendingIntent pendingIntent = PendingIntent.getActivity(context,1,mIntent,0);

        //    Toast.makeText(context, "You have Entered Geofence", Toast.LENGTH_LONG).show();
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
            Bitmap icon = BitmapFactory.decodeResource(context.getResources(),
                    R.drawable.kfc_icon);
            builder.setTicker("Mighty Zinger Combo!");
            builder.setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION));
            builder.setLargeIcon(icon);
            builder.setSmallIcon(R.drawable.kfc_icon);
            builder.setContentTitle("Mighty Zinger Combo");
            builder.setContentText("Mighty zinger, regular fries &");
            builder.setSubText("300 ml drink at Rs.580");
            builder.setContentIntent(pendingIntent);
            builder.setWhen(System.currentTimeMillis());
            builder.setAutoCancel(true);
            //builder.build();

            NotificationManager nManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            nManager.notify(12, builder.build());
        }

    }
}
