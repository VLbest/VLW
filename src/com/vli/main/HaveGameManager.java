package com.vli.main;

import com.vli.conf.Configurable;
import com.vli.gamefield.Axes;
import com.vli.gamefield.MoveDirection;
import com.vli.gamefield.TileListenner;

public interface HaveGameManager {

	TileListenner getTileListenner();

	void startGame();

	void setConfiguration(Configurable conf);

	void setCellsInAction(Axes currentAxe, MoveDirection side, int curr_x_point, int curr_y_point);

}
