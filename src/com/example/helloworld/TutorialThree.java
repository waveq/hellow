package com.example.helloworld;

import java.io.IOException;
import java.io.InputStream;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

public class TutorialThree extends Activity implements OnClickListener {

	ImageView display;
	int toPhone;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		setContentView(R.layout.wallpaper);

		toPhone = R.drawable.main;

		display = (ImageView) findViewById(R.id.IVdisplay);
		ImageView image1 = (ImageView) findViewById(R.id.IVimage1);
		ImageView image2 = (ImageView) findViewById(R.id.IVimage2);
		ImageView image3 = (ImageView) findViewById(R.id.IVimage3);
		ImageView image4 = (ImageView) findViewById(R.id.IVimage4);
		ImageView image5 = (ImageView) findViewById(R.id.IVimage5);
		Button setWall = (Button) findViewById(R.id.BsetWallpaper);

		
		image1.setOnClickListener(this);
		image2.setOnClickListener(this);
		image3.setOnClickListener(this);
		image4.setOnClickListener(this);
		image5.setOnClickListener(this);
		setWall.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()) {
		case R.id.IVimage1:
			display.setImageResource(R.drawable.main);
			toPhone = R.drawable.main;
			break;
		case R.id.IVimage2:
			display.setImageResource(R.drawable.drinkt);
			toPhone = R.drawable.drinkt;
			break;
		case R.id.IVimage3:
			display.setImageResource(R.drawable.lightg);
			toPhone = R.drawable.lightg;
			break;
		case R.id.IVimage4:
			display.setImageResource(R.drawable.result);
			toPhone = R.drawable.result;
			break;
		case R.id.IVimage5:
			display.setImageResource(R.drawable.result1);
			toPhone = R.drawable.result1;
			break;
		case R.id.BsetWallpaper:
			InputStream yea = getResources().openRawResource(toPhone);
			Bitmap whatever = BitmapFactory.decodeStream(yea);
			try {
				getApplicationContext().setWallpaper(whatever);
			}catch(IOException e) {
				e.printStackTrace();
			}
			
			break;
		
		}
	}

}
