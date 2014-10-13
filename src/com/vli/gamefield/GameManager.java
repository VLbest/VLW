package com.vli.gamefield;

import java.util.List;

import com.vli.conf.Configurable;
import com.vli.main.GameCore;
import com.vli.main.HaveGameManager;
import com.vli.mapfactory.ClassicMapCreator;
import com.vli.mapfactory.MapFactory;
import com.vli.utils.LOG;

public class GameManager implements HaveGameManager{
	
	private Configurable conf;
	private CellMoverBehavior cellMover;
	private TileListenner tileListenner;
	private GameCore core;
	private Map gameMap;
	
	private MapFactory mapFactory;
	

	public GameManager(GameCore gameCore){
		this.mapFactory = new ClassicMapCreator();
		this.core = gameCore;
		this.cellMover = new CellMover();
		this.tileListenner = new TileListenner(this);
	}

	@Override
	public void startGame() {
		this.gameMap = mapFactory.getMap(conf);
	}
	
	@Override
	public void setConfiguration(Configurable conf) {
		this.conf = conf;
	}

	@Override
	public TileListenner getTileListenner() {
		return this.tileListenner;
	}

	@Override
	public void setCellsInAction(Axes currentAxe, MoveDirection side, int curr_x_point, int curr_y_point) {
		List<Cell> cells;
		cells = this.gameMap.getCellsAround(curr_x_point,curr_y_point, currentAxe);
		this.cellMover.moveCells(cells, side, currentAxe);
	}

}
