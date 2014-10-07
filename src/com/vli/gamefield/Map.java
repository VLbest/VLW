package com.vli.gamefield;

import java.util.ArrayList;
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
		
		ArrayList<Integer> coordinates = findID(y_point, x_point); 
		
		if(axe.equals(Axes.HORISONT)){
			findedCells = getLineByID(coordinates);
		}else {
			findedCells = getRowByID(coordinates);
		}
		
		return findedCells;
	}
	
	
	private ArrayList<Integer> findID(int y_point, int x_point) {
		// int [] coord = new int[2]{lineID, rowID}
		LOG.showInfoLog("Looking for coordinates");
		for(int y = 0; y < nbOfLines; y++){
			for(int x = 0; x < nbOfRows; x++){
				Cell c = (Cell) cells[y][x];
				if(y_point > c.getBounds().top && y_point < c.getBounds().bottom){
					if(x_point > c.getBounds().left && x_point < c.getBounds().right){
						LOG.showInfoLog("Coordinates are finding");
						ArrayList<Integer> coords = new ArrayList<Integer>();
						coords.add(c.getLineNb());
						coords.add(c.getRowNb());
						return coords;	// иногда возвращает ноль -- возможно из за маржинов
					}
				}
			}
		}
		return null;
	}

	private List<Cell> getLineByID(ArrayList<Integer> coords){
		LOG.showInfoLog("Looking for Line ID");
		List<Cell> tmpfindedCells = new LinkedList<Cell>();
		for(int i=0;i<nbOfRows;i++){
			try {
				tmpfindedCells.add((Cell) cells[coords.get(0)][i]);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		return tmpfindedCells;
	}
	
	private List<Cell> getRowByID(ArrayList<Integer> coords){
		LOG.showInfoLog("Looking for Row ID");
		List<Cell> tmpfindedCells = new LinkedList<Cell>();
		for(int i=0;i<nbOfLines;i++){
			tmpfindedCells.add((Cell) cells[i][coords.get(1)]);
		}
		return tmpfindedCells;
	}
	
}
