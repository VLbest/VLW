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

	public TileListenner(HaveGameManager gameManager) {
		this.game = gameManager;
		this.isListen = false;

	}

	public void setNewTouch(MotionEvent event) {
		int action = event.getAction();
		switch (action) {
		case MotionEvent.ACTION_DOWN:
			this.findPoint(event);
			this.setListen(true);
			break;
		case MotionEvent.ACTION_UP:
			this.setListen(false);
			this.currentAxe = Axes.NONE;
			break;


		default:
			break;
		}
		if(this.isListen){
			this.updatePoint(event);
			this.findSide();
			if(this.currentAxe.toString() != Axes.NONE.toString()){
				LOG.showInfoLog("ACTION");
				this.game.setCellsInAction(this.currentAxe, this.side, this.curr_x_point, this.curr_y_point);
			}
		}
	
	}

	private void findSide() {
		if(last_x_point > curr_x_point){
			this.side = MoveDirection.LEFT;
			this.currentAxe = Axes.HORISONT;
		}else if(last_x_point < curr_x_point){
			this.side = MoveDirection.RIGHT;
			this.currentAxe = Axes.HORISONT;
		}else if(last_y_point > curr_y_point){
			this.side = MoveDirection.UP;
			this.currentAxe = Axes.VERTICAL;
		}else if(last_y_point < curr_y_point){
			this.side = MoveDirection.DOWN;
			this.currentAxe = Axes.VERTICAL;
		}else {
			this.side = MoveDirection.NONE;
			this.currentAxe = Axes.NONE;
		}
	}

	private void updatePoint(MotionEvent event) {
		this.last_x_point = this.curr_x_point;
		this.last_y_point = this.curr_y_point;
		this.findPoint(event);
	}

	private void setListen(boolean state) {
		this.isListen = state;
	}
	
	private void findPoint(MotionEvent event) {
		this.curr_x_point = (int) event.getX();
		this.curr_y_point = (int) event.getY();
	}

}
