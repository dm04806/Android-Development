package com.example.bluebin;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ActivityProject extends Activity implements OnClickListener {

	Button step1Btn;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activity_project);
		
		step1Btn = (Button) findViewById(R.id.step1);
		step1Btn.setOnClickListener(this);
		Log.v("startup", "started");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_activity_project, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		setContentView(R.layout.activity_post);	
		Log.v("pressed", "pressed");
	}

}
