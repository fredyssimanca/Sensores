package com.example.freddyssimanca.sensores;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static android.hardware.Sensor.TYPE_MAGNETIC_FIELD;
import static android.hardware.Sensor.TYPE_ORIENTATION;

public class ActFieldMagnetic extends AppCompatActivity implements SensorEventListener {
    SensorManager sm;
    Sensor magnetico;
    TextView posX, posY, posZ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_field_magnetic);

        posX = (TextView) findViewById(R.id.textView17);
        posY = (TextView) findViewById(R.id.textView18);
        posZ = (TextView) findViewById(R.id.textView19);
        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        magnetico = sm.getDefaultSensor(TYPE_MAGNETIC_FIELD);
        sm.registerListener((SensorEventListener) this,
                magnetico,SensorManager.SENSOR_DELAY_FASTEST);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        posX.setText("Valor en X: " + event.values[0]);
        posY.setText("Valor en Y: " + event.values[1]);
        posZ.setText("Valor en Z: " + event.values[2]);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
