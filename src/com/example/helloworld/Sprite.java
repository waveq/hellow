package com.example.helloworld;

import com.example.helloworld.SurfaceViewExample.OurView;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;

public class Sprite {
	
	int x, y;
	int xSpeed, ySpeed;
	int height, width;
	Bitmap b;
	OurView ov;
	int currentFrame = 0;
	int direction = 2;

	public Sprite(OurView ourView, Bitmap blob) {
		b = blob;
		ov = ourView;
		
		// 4 rows
		height = b.getHeight() /4;
		width = b.getWidth() / 4;
		x = y = 0;
		xSpeed = 25;
		ySpeed = 0;
	}

	public void onDraw(Canvas canvas) {
		
		update();
		int srcY = direction * height;
		int srcX = currentFrame * width;
		Rect src = new Rect(srcX, srcY, srcX + width, srcY+height);
		Rect dst = new Rect(x, y, x+width, y+height);
		canvas.drawBitmap(b, src, dst, null);
	}

	private void update() {
		
		// 0 = up
		// 1 = down
		// 2 = right
		// 3 = left
		//facing down
		if(x > ov.getWidth() - width - xSpeed) {
			xSpeed = 0;
			ySpeed = 25;
			direction = 1;
		}
		// facing left
		if(y > ov.getHeight() - height - ySpeed) {
			xSpeed = -25;
			ySpeed = 0;
			direction = 3;
		}
		// facing up
		if(x+ xSpeed < 0) {
			x = 0;
			xSpeed = 0;
			ySpeed = -25;
			direction = 0;
		}
		
		// facing right
		if( y + ySpeed < 0) {
			y = 0;
			xSpeed = 25;
			ySpeed = 0;
			direction = 2;
		}
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		currentFrame = ++currentFrame % 4;
		x += xSpeed;
		y += ySpeed;
	}

}
