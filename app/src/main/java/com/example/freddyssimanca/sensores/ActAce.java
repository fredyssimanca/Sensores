package com.example.freddyssimanca.sensores;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActAce extends AppCompatActivity implements SensorEventListener {
    SensorManager sm;
    Sensor acelerometro;
    TextView valX, valY, valZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_ace);
        valX = (TextView) findViewById(R.id.textView9);
        valY = (TextView) findViewById(R.id.textView10);
        valZ = (TextView) findViewById(R.id.textView11);


        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        acelerometro = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sm.registerListener(this, acelerometro, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        valX.setText("X: " + event.values[0]);
        valY.setText("Y: " + event.values[1]);
        valZ.setText("Z: " + event.values[2]);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
