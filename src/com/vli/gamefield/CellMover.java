package com.vli.gamefield;

import java.util.List;

import com.vli.main.GameSpriteBenavior;
import com.vli.utils.LOG;

import android.graphics.Path.Direction;
import android.graphics.Rect;

public class CellMover implements CellMoverBehavior{
	
	public CellMover(){
		
	}

	@Override
	public void moveCells(List<Cell> cells, MoveDirection side, Axes axe) {
		int offset = 3;
		for(Cell cell: cells){
			switch (side) {
			case UP:
				cell.setBounds(cell.getBounds().left, cell.getBounds().top-offset, cell.getBounds().right, cell.getBounds().bottom-offset);
				break;
			case DOWN:
				cell.setBounds(cell.getBounds().left, cell.getBounds().top+offset, cell.getBounds().right, cell.getBounds().bottom+offset);
				break;
			case LEFT:
				cell.setBounds(cell.getBounds().left-offset, cell.getBounds().top, cell.getBounds().right-offset, cell.getBounds().bottom);
				break;
			case RIGHT:
				cell.setBounds(cell.getBounds().left+offset, cell.getBounds().top, cell.getBounds().right+offset, cell.getBounds().bottom);
				break;

			default:
				break;
			}
		}
		this.ajastPosition(cells);
	}

	private void ajastPosition(List<Cell> cells) {
		
	}

	private int getOffset(Axes axe, MoveDirection side) {
		if(axe == Axes.HORISONT){
			if(side == MoveDirection.LEFT){
				return -1;
			}else {
				return 1;
			}
		}else {
			if(side == MoveDirection.UP){
				return -1;
			}else {
				return 1;
			}
		}
	}
}
