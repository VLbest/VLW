package com.vli.main;

import java.util.LinkedList;
import java.util.List;

import com.vli.game.GameManager;
import com.vli.utils.LOG;

import android.graphics.Canvas;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

public class GameCore implements HaveGameBahavior{
	
	private HaveGameView gameView;
	private GameLoop gameLoop;
	private HaveGameManager gameManager;
	private HaveActionListennerBehavior action;
	private List<GameSpriteBenavior> gameObjects;
	
	public GameCore(){
		this.gameObjects = new LinkedList<GameSpriteBenavior>();
		this.action = new ActionListenner();
		this.gameManager = new GameManager(action);
	}
	
	public void setUpView(HaveGameView gameView){
		this.gameView = gameView;
		this.gameView.setGame(this);
	}

	public SurfaceHolder getSurfaceHolder() {
		return this.gameView.getHolder();
	}

	@Override
	public void updateGameDate() {
		LOG.showInfoLog("updating");
		
	}

	@Override
	public void renderGame(Canvas c) {
		LOG.showInfoLog("rendering");
		c.save();
		for(GameSpriteBenavior sprite : this.gameObjects){
			sprite.draw();
		}
		c.restore();
	}

	@Override
	public void startGame() {
		LOG.showInfoLog("game started.");
		if(this.gameLoop == null){
			this.gameLoop = new GameLoop(this);
		}
		this.gameLoop.setGameLoopStarted(true);
		this.gameLoop.start();
		this.gameManager.startGame();
	}

	@Override
	public void stopGame() {
		boolean retry = true;
		this.gameLoop.setGameLoopStarted(false);
		while(retry){
			try {
				this.gameLoop.join();
				retry = false;
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}

	@Override
	public void undateEvent(MotionEvent event) {
		this.action.setNewEvent(event);
	}

}
