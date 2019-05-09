package com.example.freddyssimanca.sensores;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ActPro extends AppCompatActivity implements SensorEventListener {
    LinearLayout fondo;
    TextView intensidad;
    SensorManager sm;
    Sensor proximidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_pro);

        fondo = (LinearLayout) findViewById(R.id.fondo);
        intensidad = (TextView) findViewById(R.id.textView8);

        sm = (SensorManager)getSystemService(SENSOR_SERVICE);
        proximidad = sm.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        sm.registerListener(this, proximidad, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Float valor = event.values[0];
        intensidad.setText("Proximidad: " + valor);
        if (valor <= 5){
            fondo.setBackgroundColor(Color.BLACK);
        }else {
            fondo.setBackgroundColor(Color.BLUE);
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
