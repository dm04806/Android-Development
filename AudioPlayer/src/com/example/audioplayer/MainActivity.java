package com.example.audioplayer;

import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity implements OnCompletionListener {

	MediaPlayer mediaPlayer;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	public void onStart(View v) {
		super.onStart();
		mediaPlayer = MediaPlayer.create(this, R.raw.room);
		mediaPlayer.setOnCompletionListener(this);
		mediaPlayer.start();
	}
	
	public void onStop(View v){
		super.onStop();
		mediaPlayer.stop();
		mediaPlayer.release();
	}
	
	public void onCompletion(MediaPlayer arg0) {
		mediaPlayer.start();
	}

}
