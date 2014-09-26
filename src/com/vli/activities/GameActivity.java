package com.vli.activities;

import com.example.vlwords.R;
import com.vli.conf.Configurable;
import com.vli.conf.Configuration;
import com.vli.gamefield.GameManager;
import com.vli.main.GameCore;
import com.vli.main.HaveGameManager;
import com.vli.main.HaveGameView;
import com.vli.utils.LOG;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;

public class GameActivity extends Activity {
	
	private GameCore gameCore;
	private HaveGameView gameView;
	private HaveGameManager gameManager;
	private Configurable conf;

	 @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.game);
		LOG.showInfoLog("Activity created.");
		this.gameCore = new GameCore();
		this.gameManager = new GameManager(gameCore);		
		this.gameView = (HaveGameView) findViewById(R.id.game_view);
		this.gameCore.setUpView(gameView);
		this.gameCore.setGameManager(gameManager);
		this.conf = this.createConfig();
		this.gameManager.setConfiguration(conf);
		this.gameManager.startGame();
	}
	 
	 private Configurable createConfig(){
		 Configurable conf = new Configuration();
		 
		 DisplayMetrics metrics = new DisplayMetrics();
	     getWindowManager().getDefaultDisplay().getMetrics(metrics);
	     
	     conf.setScreenWidth(metrics.widthPixels);
	     conf.setScreenHeight(metrics.heightPixels);
	     
	     conf.setGamefieldWHeightInPercent(80);
	     conf.setCellMargin(2);
	     
	     conf.setMapBottomMargin(5);
	     conf.setMapRightMargin(5);
	     conf.setMapLeftMargin(5);
	     conf.setMapTopMargin(conf.getScreenHeight() - ((conf.getScreenHeight() * conf.getGamefieldWHeightInPercent())/100));
	     
	     conf.setCellsInRow(10);
	     conf.setCellsInLine(8);
	     conf.setCellsSize(
	    		 (conf.getScreenWidth() - ((conf.getCellsInLine()*conf.getCellMargin())+conf.getCellMargin()))/conf.getCellsInLine()
	    		 );
	     
		 return conf;
		 
	 }
}
