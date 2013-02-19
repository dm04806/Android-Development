package com.example.cameraintent;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {
	
	//constant variable (fixed) - just a state
	//if I wanted video I'd set VIDEO_RESULT = 1
	public static final int CAMERA_RESULT = 0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	}

	//when button is clicked
	public void buttonClicked(View clickedView){
		//use built-in android camera (not a custom camera)
		Intent i = new Intent (android.provider.MediaStore.ACTION_IMAGE_CAPTURE); 
		startActivityForResult(i, CAMERA_RESULT);
	}

	//when camera comes back it calls onActivityResult
	protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
		
		if(requestCode == CAMERA_RESULT ){
			Bundle extras = intent.getExtras(); 
			Bitmap bmp = (Bitmap) extras.get("data");
			ImageView imageView = (ImageView) this.findViewById(R.id.imageView1);
			imageView.setImageBitmap(bmp);
		}
		
	}
	
}
