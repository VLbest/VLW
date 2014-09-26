package com.vli.gamefield;

import java.util.List;

import com.vli.utils.LOG;

public class Map {
	
	private CellBehavior[][] cells;
	
	public Map(){
		
	}
	
	public void intitMap(int nbRows, int nbLines){
		this.cells = new CellBehavior[nbLines][nbRows];		
	}
	
	public void addCell(int xPos, int yPos, CellBehavior cell){
		this.cells[yPos][xPos] = cell;
	}
	
	public List<Cell> getCellsAround(int curr_x_point, int curr_y_point, Axes currentAxe){
		int nb;
		if(currentAxe.equals(Axes.HORISONT)){
			nb = this.getLineNb(curr_y_point);
			// Вернуть ячейки в линии с номером nb-1
		}else {
			nb = this.getRowNb(curr_x_point);
		}
		return null;
	}

	private int getRowNb(int point) {
		for(int i = 0; i < cells.length; i++){
			try {
				Cell c = (Cell) cells[0][i];
				int top = c.getBounds().top;
				int bot = c.getBounds().bottom;
				if(point < bot && point > top){
					return c.getRowNb();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	private int getLineNb(int point) {
		for(int i = 0; i < cells.length; i++){
			try {
				Cell c = (Cell) cells[i][0];
				int top = c.getBounds().top;
				int bot = c.getBounds().bottom;
				if(point < bot && point > top){
					return c.getLineNb();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}
	
}
