package com.vli.game;

import com.vli.main.HaveActionListennerBehavior;
import com.vli.main.HaveGameManager;

public class GameManager implements HaveGameManager{
	
	private HaveActionListennerBehavior action;

	public GameManager(HaveActionListennerBehavior action){
		this.action = action;
	}
	
	@Override
	public void startGame() {
		
	}

}
