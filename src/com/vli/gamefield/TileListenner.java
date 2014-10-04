package com.vli.gamefield;

import com.vli.main.HaveGameManager;
import com.vli.utils.LOG;

import android.drm.DrmStore.Action;
import android.view.MotionEvent;

public class TileListenner {
	
	private HaveGameManager game;
	
	private int last_x_point;
	private int last_y_point;
	private int curr_x_point;
	private int curr_y_point;
	
	private boolean isListen;
	
	private MoveDirection side;
	private Axes currentAxe;

	private boolean isAxeLocked;

	public TileListenner(HaveGameManager gameManager) {
		this.game = gameManager;
		this.resetPoints();
		this.setListen(false);
		this.lockAxe(false);
		this.currentAxe = Axes.NONE;
		this.side = MoveDirection.NONE;
	}

	private void resetPoints() {
		this.curr_x_point = -1;
		this.curr_y_point = -1;
		this.last_x_point = -1;
		this.last_y_point = -1;
	}

	public void setNewTouch(MotionEvent event) {
		int action = event.getAction();
		switch (action) {
		case MotionEvent.ACTION_DOWN:
			LOG.showInfoLog("Toching is detected : .ACTION_DOWN");
			this.setListen(true);
			break;
		case MotionEvent.ACTION_UP:
			LOG.showInfoLog("Toching is ended : .ACTION_UP");
			setListen(false);
			this.resetPoints();
			break;
		default:
			break;
		}
		if(this.curr_x_point > 0 && this.curr_y_point > 0){
			this.updatePoint(event);
		}
		this.findPoint(event);
		this.alalyseTouch();
	}

	private void alalyseTouch() {
		LOG.showInfoLog("Analysing Touch");
		LOG.showInfoLog(this.currentAxe.toString());
		if(isSlide() && !isAxeLocked){
			LOG.showInfoLog("Looking for Axe");
			this.currentAxe = this.findAxe();
			this.lockAxe(true);
		}
		
		if(findSide()){
			this.game.setCellsInAction(currentAxe, side, curr_x_point, curr_y_point);
		}
		
	}
	
	private boolean findSide() {
		LOG.showInfoLog("Looking for side");
		if(this.currentAxe.equals(Axes.HORISONT)){
			if(last_x_point > curr_x_point){
				this.side = MoveDirection.LEFT;
				LOG.showInfoLog("Side is : LEFT");
				return true;
			}else if(last_x_point < curr_x_point){
				this.side = MoveDirection.RIGHT;
				LOG.showInfoLog("Side is : RIGHT");
				return true;
			}else{
				LOG.showInfoLog("Horisontal side can't be detected");
				return false;
			}
		}else {
			if(last_y_point > curr_y_point){
				this.side = MoveDirection.UP;
				LOG.showInfoLog("Side is : UP");
				return true;
			}else if(last_y_point < curr_y_point){
				this.side = MoveDirection.DOWN;
				LOG.showInfoLog("Side is : DOWN");
				return true;
			}else{
				LOG.showInfoLog("Vertical side can't be detected");
				return false;
			}
		}
	}

	private void lockAxe(boolean b){
		this.isAxeLocked = b;
	}
	

	private Axes findAxe() {
		if(this.last_x_point != this.curr_x_point){
			return Axes.HORISONT;
		}else {
			return Axes.VERTICAL;	
		}
	}

	private boolean isSlide() {
		if(this.last_x_point != this.curr_x_point || this.last_y_point != this.curr_y_point){
			return true;
		}
		return false;
	}

	private void updatePoint(MotionEvent event) {
		this.last_x_point = this.curr_x_point;
		this.last_y_point = this.curr_y_point;
	}

	private void setListen(boolean state) {
		this.isListen = state;
	}
	
	private void findPoint(MotionEvent event) {
		this.curr_x_point = (int) event.getX();
		this.curr_y_point = (int) event.getY();
	}

}
