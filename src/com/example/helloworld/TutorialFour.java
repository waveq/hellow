package com.example.helloworld;

import android.app.Activity;
import android.os.Bundle;

public class TutorialFour extends Activity {

	DrawingTheBall v;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		v = new DrawingTheBall(this);
		setContentView(v);
	}

	
}
