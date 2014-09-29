package com.vli.main;

import java.util.LinkedList;
import java.util.List;

import com.vli.gamefield.GameManager;
import com.vli.utils.LOG;

import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.SurfaceHolder;

public class GameCore implements HaveGameBahavior{
	
	private HaveGameView gameView;
	private GameLoop gameLoop;
	private HaveGameManager game;
	private static List<GameSpriteBenavior> gameObjects;
	
	public GameCore(){
		this.gameObjects = new LinkedList<GameSpriteBenavior>();
	}
	
	public void setUpView(HaveGameView gameView){
		this.gameView = gameView;
		this.gameView.setGame(this);
	}

	public SurfaceHolder getSurfaceHolder() {
		return this.gameView.getHolder();
	}

	@Override
	public void updateGameDate(MotionEvent event) {
		this.game.getTileListenner().setNewTouch(event);
	}
	
	public static void addObjectsToRender(GameSpriteBenavior sprite){
		gameObjects.add(sprite);
	}

	@Override
	public void renderGame(Canvas c) {
		c.save();
		c.drawColor(Color.DKGRAY);
		for(GameSpriteBenavior sprite : this.gameObjects){
			sprite.draw(c);
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

	public void setGameManager(HaveGameManager gameManager) {
		this.game = gameManager;
		
	}

}
