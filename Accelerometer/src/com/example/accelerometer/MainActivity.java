package com.example.accelerometer;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.util.Log;
import android.view.Menu;

public class MainActivity extends Activity implements SensorEventListener {

	//sensor classes
	private SensorManager sensorManager;
	private Sensor accelerometerSensor;
	
	//drawing view created in DrawingView class
	DrawingView myDrawingView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//lock orientation
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		
		myDrawingView =new DrawingView(this);
		setContentView(myDrawingView);
		
		//setContentView(R.layout.activity_main);
		
		sensorManager = (SensorManager)getSystemService(Context.SEARCH_SERVICE);
		sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	@Override
	protected void onResume(){
		super.onResume();
		sensorManager.registerListener(this, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL);
	}
	
	@Override
	protected void onPause(){
		super.onPause();
		sensorManager.unregisterListener(this);
	}

	@Override
	public void onAccuracyChanged(Sensor arg0, int arg1) {
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		Log.v("Accel","X: " + event.values[0]);
		Log.v("Accel","Y: " + event.values[1]);
		Log.v("Accel","Z: " + event.values[2]);
		
		myDrawingView.addToXandY(event.values[0], event.values[1]);
	}
	
	//don't restart app on orientation change
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
	    super.onConfigurationChanged(newConfig);
	}
	
}
