package com.example.accelerometer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class DrawingView extends View {

	public DrawingView(Context context) {
		super(context);
	}
	
	public DrawingView(Context context, AttributeSet attr){
		super(context, attr);
		
	}
	
	public DrawingView(Context context, AttributeSet attr, int defStyle){
		super(context, attr, defStyle);
	}
	
	@Override
	protected void onDraw(Canvas canvas){
		Paint paint = new Paint();
		paint.setColor(Color.RED);
		
		canvas.drawCircle(x, y, 20, paint);
		//has getWidth() and getHeight()
	}

	float x = 0, y = 0;
	

	
	public void addToXandY(float xval, float yval){
		x += xval;
		y += yval;
		
		if(x < 0)
			x = 0;
		if(x > getWidth())
			x= getWidth();
		if(y < 0)
			y = 0;
		if(y > getHeight())
			y= getHeight();
		
		invalidate(); //call draw method
	}

}
