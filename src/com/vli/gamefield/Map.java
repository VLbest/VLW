package com.vli.gamefield;

import java.util.LinkedList;
import java.util.List;

import com.vli.utils.LOG;

public class Map {
	
	private CellBehavior[][] cells;
	private int nbOfLines;
	private int nbOfRows;
	
	public Map(){
		
	}
	
	public void intitMap(int nbRows, int nbLines){
		this.cells = new CellBehavior[nbLines][nbRows];	
		this.nbOfLines = nbLines;
		this.nbOfRows = nbRows;
	}
	
	public void addCell(int xPos, int yPos, CellBehavior cell){
		this.cells[yPos][xPos] = cell;
	}
	
	public List<Cell> getCellsAround(int x_point, int y_point, Axes axe){
		List findedCells = new LinkedList<Cell>();
		
		int[] coordinates = findID(y_point, x_point); 
		
		if(axe.equals(Axes.HORISONT)){
			getLineByID(coordinates);
		}else {
			getRowByID(coordinates);
		}
		
		return findedCells;
	}
	
	
	private int[] findID(int y_point, int x_point) {
		// int [] coord = new int[2]{lineID, rowID}
		LOG.showInfoLog("Looking for coordinates");
		for(int y = 0; y < nbOfLines; y++){
			for(int x = 0; x < nbOfRows; x++){
				Cell c = (Cell) cells[y][x];
				if(y_point > c.getBounds().top && y_point < c.getBounds().bottom){
					if(x_point > c.getBounds().left && x_point < c.getBounds().right){
						LOG.showInfoLog("Coordinates are finding");
						return new int[]{c.getLineNb(), c.getRowNb()};	// иногда возвращает ноль -- возможно из за маржинов
					}
				}
			}
		}
		return null;
	}

	private List<Cell> getLineByID(int[] coordinates){
		LOG.showInfoLog("Looking for Line ID");
		List<Cell> tmpfindedCells = new LinkedList<Cell>();
		for(int i=0;i<nbOfRows;i++){
			try {
				tmpfindedCells.add((Cell) cells[coordinates[0]][i]);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return tmpfindedCells;
	}
	
	private List<Cell> getRowByID(int[] coordinates){
		LOG.showInfoLog("Looking for Row ID");
		List findedCells = new LinkedList<Cell>();
		for(int i=0;i<nbOfLines;i++){
			findedCells.add(cells[i][coordinates[1]]);
		}
		return findedCells;
	}
	
}
