package com.example.imageviewer;

import java.io.IOException;
import java.io.InputStream;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.widget.ImageView;

public class MainActivity extends Activity {

	ImageView imageView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//find image view in .xml
		imageView = (ImageView) this.findViewById(R.id.imageview1);
		
		//load image
		try {
			InputStream is = this.getAssets().open("test.png");
			Bitmap bm = BitmapFactory.decodeStream(is);
			//if in res do decodeResource instead of decodeStream
			//Bitmap b = BitmapFactory.decodeResource(Resources res, int id)
			imageView.setImageBitmap(bm);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
