package com.example.freddyssimanca.sensores;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

public class ActTem extends AppCompatActivity implements SensorEventListener {
    SensorManager sm;
    TextView temp;
    List<Sensor> sensores;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_tem);
        temp = (TextView) findViewById(R.id.textView2);
        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        sensores = sm.getSensorList(Sensor.TYPE_AMBIENT_TEMPERATURE);
       // Toast.makeText(getApplicationContext(), "Tamaño: " + sensores.size(),
        //        Toast.LENGTH_LONG).show();
        if (sensores.size()>0){
            sm.registerListener(this, sensores.get(0),SensorManager.SENSOR_DELAY_NORMAL);
        }
    }
    @Override
    public void onSensorChanged(SensorEvent val) {
        temp.setText("Temperatura: " + val.values[0] );
    }
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
