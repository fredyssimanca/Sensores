package com.example.freddyssimanca.sensores;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActLuz extends AppCompatActivity implements SensorEventListener {
    SensorManager sm;
    Sensor luz;
    TextView luminosidad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_luz);
        luminosidad = (TextView) findViewById(R.id.textView7);
        sm =(SensorManager) getSystemService(SENSOR_SERVICE);
        luz = sm.getDefaultSensor(Sensor.TYPE_LIGHT);
        sm.registerListener(this, luz, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
       luminosidad.setText("Nivel de luz: " + event.values[0]);
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
