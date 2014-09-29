package com.vli.gamefield;

import java.util.LinkedList;
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
		List<Cell> cellsToReturn = new LinkedList<Cell>();
		if(currentAxe.equals(Axes.HORISONT)){
			nb = this.getLineNb(curr_y_point);
			for(int i = 0; i < 8; i++){
				try {
					cellsToReturn.add((Cell) cells[nb-1][i]);
				} catch (Exception e) {
					e.printStackTrace();
					LOG.showInfoLog("horisont");
					LOG.showInfoLog(nb-1);
					LOG.showInfoLog(i);
				}				
			}
		}else {
			nb = this.getRowNb(curr_x_point);
			for(int i = 0; i < 10; i++){
				try {
					cellsToReturn.add((Cell) cells[i][nb-1]);
				} catch (Exception e) {
					e.printStackTrace();
					LOG.showInfoLog("vertic");
					LOG.showInfoLog(i);
					LOG.showInfoLog(nb-1);
				}
			}
		}
		return cellsToReturn;
	}

	private int getRowNb(int point) {
		for(int i = 0; i < 10; i++){
			try {
				Cell c = (Cell) cells[1][i];
				int left = c.getBounds().left;
				int right = c.getBounds().right;
				if(point > left && point < right){
					return c.getRowNb();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	private int getLineNb(int point) {
		for(int i = 0; i < 8; i++){
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
