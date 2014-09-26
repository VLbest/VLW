package com.vli.gamefield;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

import com.vli.main.GameSpriteBenavior;
import com.vli.utils.LOG;

public abstract class Sprite implements GameSpriteBenavior{
	
	protected Rect bounds;
	protected Paint paint;
	
	public Sprite(){
		this.bounds = new Rect();
		this.paint = new Paint(Paint.ANTI_ALIAS_FLAG);
	}
	
	public void setBounds(int left, int top, int right, int bottom){
		this.bounds.set(left, top, right, bottom);
	}
	
	@Override
	public void draw(Canvas c) {
		c.drawRect(bounds, paint);
	}
	
	public Rect getBounds(){
		return this.bounds;
	}

}
