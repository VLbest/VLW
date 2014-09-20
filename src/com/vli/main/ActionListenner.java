package com.vli.main;

import android.view.MotionEvent;

public class ActionListenner implements HaveActionListennerBehavior{

	private MotionEvent event;
	
	public ActionListenner(){
		
	}
	
	@Override
	public void setNewEvent(MotionEvent event) {
		this.event = event;
	}
	
}
