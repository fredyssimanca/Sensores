package com.example.freddyssimanca.sensores;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import static android.hardware.Sensor.TYPE_LIGHT;
import static android.hardware.Sensor.TYPE_ORIENTATION;

public class ActPrueba extends AppCompatActivity implements SensorEventListener {
    SensorManager sm;
    Sensor luz;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_prueba);
        textView = (TextView) findViewById(R.id.textView6);
        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        luz = sm.getDefaultSensor(TYPE_LIGHT);
        sm.registerListener((SensorEventListener) this, luz,SensorManager.SENSOR_DELAY_NORMAL);
    }
    @Override
    public void onSensorChanged(SensorEvent event) {
        textView.setText("Nivel de luz: " + event.values[0]);
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
