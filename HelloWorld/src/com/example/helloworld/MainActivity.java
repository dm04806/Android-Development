package com.example.helloworld;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {

	TextView myTextView;
	Button myButton;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        Log.v("MainActivity", "On create started");
        
        setContentView(R.layout.activity_main);
        
        myTextView = (TextView) findViewById(R.id.myTextView);
        myButton = (Button) findViewById(R.id.myButton);
        myButton.setOnClickListener(this);
        
    	Log.v("MainActivity", "On create finished");
    }
    
	@Override
	public void onClick(View clickedView) {
		myTextView.setText("you just clicked the button!");
		Log.v("Clicker", "Button Clicked: " + myTextView.getText());
		
		Toast t = Toast.makeText(this,"Button Clicked!",Toast.LENGTH_LONG);
		t.show();
	}
	
	public void onPause() {
	     super.onPause();
	     finish();
	}
	

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

    
}
