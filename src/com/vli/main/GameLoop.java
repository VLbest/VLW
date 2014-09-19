package com.vli.main;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class GameLoop extends Thread {
	
	private boolean running;
	private boolean paused;
	
	private SurfaceHolder holder;
	private GameCore game;
	
	private final Object mRunLock;
	
	public GameLoop(GameCore game){
		this.running = false;
		this.paused = true;
		this.mRunLock = new Object();
		this.game = game;
	}
	
	public void setViewAndHolder(GameView v){
		this.holder = v.getSurfaceHolder();
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
							
							this.game.render();
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
	
	public void setRunning(boolean b){
		this.running = b;
	}
	
	public void setPaused(boolean b){
		this.paused = b;
	}
	
}
