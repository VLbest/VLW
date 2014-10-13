package com.vli.gamefield;

import com.vli.main.HaveGameManager;
import com.vli.utils.LOG;

import android.drm.DrmStore.Action;
import android.graphics.Path.Direction;
import android.view.MotionEvent;

public class TileListenner {
	
	protected HaveGameManager game;
	
	protected int last_x_point;
	protected int last_y_point;
	protected int curr_x_point;
	protected int curr_y_point;
	
	protected boolean isListened;
	
	protected MoveDirection side;
	protected Axes currentAxe;
	
	protected Axes lockedAxe;
	
	protected int tikTak = 0;

	public TileListenner(HaveGameManager gameManager) {
		this.game = gameManager;
		this.resetPoints();
	}
	
	protected void resetPoints(){
		this.curr_x_point = -1;
		this.curr_y_point = -1;
		this.last_x_point = -1;
		this.last_y_point = -1;
		this.lockedAxe = Axes.NONE;
		this.currentAxe = Axes.NONE;
		this.side = MoveDirection.NONE;
	}

	public void setNewTouch(MotionEvent event) {
		int action = event.getAction();
		switch (action) {
		case MotionEvent.ACTION_DOWN:
			LOG.showInfoLog("___ACTION DOWN.");
			this.setListened(true);
			break;
		case MotionEvent.ACTION_UP:
			this.setListened(false);
			this.tikTak = 0;
			this.resetPoints();
			break;
		default:
			break;
		}
		this.tikTak++;
		updateCurrentPoint(event.getX(), event.getY());
		setCurrentPoint(event.getX(), event.getY());
		
		if(this.isListened && (this.tikTak%2)==0){
			LOG.showInfoLog("_________START LISTENNING.");
			this.startTouchAnalysator();
		}
		
		
		
	}

	private void startTouchAnalysator() {
		if(this.isSliding() && this.lockedAxe == Axes.NONE){
			LOG.showInfoLog("___________LOOKING FOR AXE.");
			this.currentAxe = findeAxe();
			this.setListened(lockAxe(currentAxe));
		}
		
		if(this.lockedAxe == Axes.HORISONT){
			this.side = findHorisontalSide();
		}else if(this.lockedAxe == Axes.VERTICAL){
			this.side = findVerticalSide();
		}else {
			this.setListened(false);
		}
		if(this.side != MoveDirection.NONE){
			this.transferDataToGame();
		}
		
	}
	
	private void transferDataToGame() {
		this.game.setCellsInAction(lockedAxe, side, curr_x_point, curr_y_point);
	}

	private boolean lockAxe(Axes axe) {
		if(this.currentAxe != Axes.NONE){
			this.lockedAxe = axe;
			return true;
		}
		return false;
	}

	protected MoveDirection findHorisontalSide(){
		if(last_x_point > curr_x_point){
			return MoveDirection.LEFT;
		}else if (last_x_point < curr_x_point) {
			return MoveDirection.RIGHT;
		}else {
			return returnUndefinedSide();
		}
	}
	
	private MoveDirection returnUndefinedSide() {
		return MoveDirection.NONE;
	}

	protected MoveDirection findVerticalSide(){
		if(last_y_point > curr_y_point){
			return MoveDirection.UP;
		}else if (last_y_point < curr_y_point) {
			return MoveDirection.DOWN;
		}else {
			return returnUndefinedSide();
		}
	}
		
	protected Axes findeAxe(){
		
		int x_diff = Math.abs(this.curr_x_point - this.last_x_point);
		int y_diff = Math.abs(this.curr_y_point - this.last_y_point);
		
		if(x_diff > y_diff){
			return Axes.HORISONT;
		}else if (x_diff == y_diff) {
			return Axes.NONE;
		}else {
			return Axes.VERTICAL;
		}
	}
	
	protected boolean isSliding(){
		if(this.last_x_point != this.curr_x_point || this.last_y_point != this.curr_y_point){
			return this.isNotReseted();
		}
		return false;
	}

	private boolean isNotReseted() {
		if(last_x_point >=0 && last_y_point >=0 && curr_x_point >=0 && curr_y_point >=0){
			return true;
		}
		return false;
	}

	protected void setListened(boolean state){
		this.isListened = state;
	}
	
	protected void updateCurrentPoint(float x, float y){
		LOG.showInfoLog("______Updating point.");
		this.last_x_point = this.curr_x_point;
		this.last_y_point = this.curr_y_point;
		this.setCurrentPoint(x, y);
	}
	
	protected void setCurrentPoint(float x, float y) {
		LOG.showInfoLog("______Set new point.");
		this.curr_x_point = (int)x;
		this.curr_y_point = (int)y;
	}
}
