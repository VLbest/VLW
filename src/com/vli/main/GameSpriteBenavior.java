package com.vli.main;

import android.graphics.Canvas;
import android.graphics.Rect;

public interface GameSpriteBenavior {

	public void draw(Canvas c);
	public Rect getBounds();

}
