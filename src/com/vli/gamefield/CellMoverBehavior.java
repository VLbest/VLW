package com.vli.gamefield;

import java.util.List;

import android.graphics.Path.Direction;

public interface CellMoverBehavior {
	
	public boolean moveCells(List<Cell> cells, MoveDirection side, Axes currentAxe);
}
