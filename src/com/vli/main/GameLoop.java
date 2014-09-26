package com.vli.main;

import com.vli.utils.LOG;

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
		this.setFPS(5);
		this.running = false;
		this.paused = false;
		this.mRunLock = new Object();
	}
	
	public void run(){
		while(running){
			Canvas c = null;
			try{
				c = holder.lockCanvas(null);
				synchronized (holder) {
					if(!paused){
						
					}
					synchronized (mRunLock) {
						if(!paused){
							this.game.renderGame(c);
						}
					}
				}
			}finally{
				if(c != null){
					holder.unlockCanvasAndPost(c);
				}
			}
		}
	}
	
	private void renderProcesse(){
		Canvas c = null;
		try {
			c = holder.lockCanvas(null);
			synchronized (holder) {
				
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
