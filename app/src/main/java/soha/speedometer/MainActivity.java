package soha.speedometer;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    public static final String  EXTRA_MESSAGE = "soha.speedometerApp.MESSAGE";

    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i("info","in first activity");

    }

    /** Called when the user taps the Set Threshold button */
    public void sendMessage(View view){
        //Do something in response to button
        Intent intent=new Intent(this, DisplaySpeedActivity.class);
        EditText editText=(EditText)findViewById(R.id.speedThreshold);
        String message=editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        Log.i("info","in first activity , with threshold equals"+message);
        startActivity(intent);
    }


}
