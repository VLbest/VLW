package com.vli.activities;

import com.example.vlwords.R;
import com.vli.main.GameCore;
import com.vli.main.HaveGameView;
import com.vli.utils.LOG;

import android.app.Activity;
import android.os.Bundle;

public class GameActivity extends Activity {
	
	private GameCore gameCore;
	private HaveGameView gameView;

	 @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.game);
		LOG.showInfoLog("Activity created.");
		this.gameCore = new GameCore();
		this.gameView = (HaveGameView) findViewById(R.id.game_view);
		this.gameCore.setUpView(gameView);
	}
	
}
