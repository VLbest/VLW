package com.vli.main;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class GameLoop extends Thread implements HaveFPS{
	
	private HaveGameBahavior game;
	private SurfaceHolder holder;
	private final Object mRunLock;
	
	private int targetFPS;
	private boolean running;
	private boolean paused;
	private double currentTime;
	private double lastUpdate;
	private double diff;
	
	public GameLoop(GameCore gameCore){
		this.game = gameCore;
		this.holder = gameCore.getSurfaceHolder();
		this.setFPS(30);
		this.running = false;
		this.paused = false;
		this.mRunLock = new Object();
	}
	
	public void run(){
		while(running){
			this.currentTime = System.nanoTime();
			if(!paused){
				while(currentTime - lastUpdate > diff){
					this.renderProcesse();
					this.lastUpdate = this.currentTime;
				}
			}
		}
	}
	
	private void renderProcesse(){
		Canvas c = null;
		try {
			c = holder.lockCanvas(null);
			synchronized (holder) {
				this.game.updateGameDate();
			}
			synchronized (mRunLock) {
				this.game.renderGame(c);
			}
		}finally{
			if(c != null){
				holder.unlockCanvasAndPost(c);
			}
		}
	}
	
	@Override
	public void setFPS(int fps) {
		this.targetFPS = fps;
		this.diff = 1000000000/this.targetFPS;
	}

	@Override
	public void setGameLoopStarted(boolean state) {
		this.running = state;
	}

	@Override
	public void setGameLoopPaused(boolean state) {
		this.paused = state;
	}

}
