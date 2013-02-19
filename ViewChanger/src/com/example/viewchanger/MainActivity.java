package com.example.viewchanger;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	
	Button myButton;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		myButton = (Button) findViewById(R.id.MainButton);
		myButton.setOnClickListener(this);
		Log.v("ready", "view is loaded");
	}
	
	
	@Override
	public void onClick(View clickedView) {
		Log.v("Clicker", "Button Clicked");
		setContentView(R.layout.activity_other);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}


}
