package soha.speedometer;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class DisplaySpeedActivity extends AppCompatActivity implements LocationListener {

    NotificationCompat.Builder mBuilder ;
    NotificationManagerCompat notificationManager;

    private Location lastLocation = null;

    String threshold;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_speed);

         mBuilder = new NotificationCompat.Builder(this);
         notificationManager = NotificationManagerCompat.from(this);

        //get the intent that started this activity and extract the string
        Intent intent = getIntent();
        threshold = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        //we need to register this class as a listener for the main location manager.
        // get a reference to the location manager.
        LocationManager lm = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);

        //register this class with the referenced manager we just got.

        //#1 provider --> location provider we want to get updates from ,
        //#2 mintime --> how ofter you want to get updates (setting it to zero means getting it as soon as it is available )
        //#3 maxtime , #4 --> is the listener we going to add.

        try { //exception if the user denied the access for gps location
            lm.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,0,this);
        } catch (SecurityException e) {
            Toast.makeText(getApplicationContext(),"Cannot access gps , no speed measurement",Toast.LENGTH_SHORT).show();; // lets the user know there is a problem with the gps

        }

        //gets called automatically when the location variables change.
       this.onLocationChanged(null);

        mBuilder.setSmallIcon(R.drawable.notification_icon);
        mBuilder.setContentTitle("Speed Notification");
        mBuilder.setContentText("You exceeded the speed threshold you set for yourself!");

    }

    @Override
    public void onLocationChanged(Location currentLocation) {
        TextView speedtxt = (TextView) this.findViewById(R.id.speedTextView1);
        float speed = 0;

        if(currentLocation == null)
            speed = 0 ;

        else{
            speed = currentLocation.getSpeed();
            speedtxt.setText(speed + " m/sec");

            //for the notification
            if(Float.parseFloat(threshold)>= speed)
                notificationManager.notify(0, mBuilder.build());
        }


    }

    /*

     haversine algorithm to get the distance from degree of logitude and latitiude

     long getDistanceBetweenPoints(double lat1, double lng1, double lat2, double lng2 ){
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lng2 - lng1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1))
                * Math.cos(Math.toRadians(lat2)) * Math.sin(dLon / 2)
                * Math.sin(dLon / 2);
        double c = 2 * Math.asin(Math.sqrt(a));
        long distanceInMeters = Math.round(6371000 * c);
        return distanceInMeters;
    }
     */

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
