package com.vli.main;

import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

public interface HaveGameBahavior {

	public SurfaceHolder getSurfaceHolder();

	public void updateGameDate(MotionEvent event);

	public void renderGame(Canvas c);

	public void stopGame();

	void startGame();
	
}
