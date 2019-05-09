package com.example.freddyssimanca.sensores;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static android.hardware.Sensor.TYPE_ORIENTATION;

public class ActOri extends AppCompatActivity implements SensorEventListener {
    SensorManager sm;
    Sensor orientacion;
    TextView posX, posY, posZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_ori);
        posX = (TextView) findViewById(R.id.textView3);
        posY = (TextView) findViewById(R.id.textView4);
        posZ = (TextView) findViewById(R.id.textView5);
        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        orientacion = sm.getDefaultSensor(TYPE_ORIENTATION);
        sm.registerListener((SensorEventListener) this,
                orientacion,SensorManager.SENSOR_DELAY_FASTEST);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        posX.setText("Altitud: " + event.values[0]);
        posY.setText("Altitud: " + event.values[1]);
        posZ.setText("Altitud: " + event.values[2]);
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
