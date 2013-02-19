package com.example.cameraintent;

import java.io.File;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends Activity {
	
	//constant variable (fixed) - just a state
	//if I wanted video I'd set VIDEO_RESULT = 1
	public static final int CAMERA_RESULT = 0;
	String imageFilePath;
	
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
		
		//this is for fullsize images
		//saves it to the SD card
		File imageFile = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/myName.jpg");
		imageFilePath = imageFile.getAbsolutePath();
		Uri imageFileUri = Uri.fromFile(imageFile);
		
		i.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, imageFileUri);
	}

	//when camera comes back it calls onActivityResult
	protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
		
		if(requestCode == CAMERA_RESULT ){
			/*
			//displays image without saving it to SD card
			Bundle extras = intent.getExtras(); 
			Bitmap bmp = (Bitmap) extras.get("data");
			ImageView imageView = (ImageView) this.findViewById(R.id.imageView1);
			imageView.setImageBitmap(bmp);
			*/
			
			//load image from SD disk to get correct image size
			BitmapFactory.Options bmpFactoryOptions = new BitmapFactory.Options(); 
			bmpFactoryOptions.inSampleSize = 8; //only load up 1/8 of fullsize image
			Bitmap bmp = BitmapFactory.decodeFile(imageFilePath, bmpFactoryOptions);
		}
		
	}
	
}
