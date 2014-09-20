package com.vli.main;

import com.vli.utils.LOG;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameSurface extends SurfaceView implements HaveGameView, SurfaceHolder.Callback{
	
	private SurfaceHolder holder;
	private HaveGameBahavior game;
	
	public GameSurface(Context context) {
		super(context);
		this.initSurfaceView();
	}
	
	public GameSurface(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.initSurfaceView();
	}
	
	private void initSurfaceView(){
		this.holder = this.getHolder();
		this.holder.addCallback(this);
	}
	
	public SurfaceHolder getSurfaceHolder(){
		return this.holder;
	}

	@Override
	public void setGame(HaveGameBahavior gameCore) {
		this.game = gameCore;
	}
	
	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		LOG.showInfoLog("surfaceCreated.");
		this.game.startGame();
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,
			int height) {
		
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		LOG.showInfoLog("surfaceDestroyed.");
		this.game.stopGame();
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		this.game.undateEvent(event);
		return super.onTouchEvent(event);
	}

}
