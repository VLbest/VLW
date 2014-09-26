package com.vli.conf;

public class Configuration implements Configurable{

	private int cellsInLine;
	private int cellsInRow;
	private int cellsSize;
	private int mapLeftMargin;
	private int mapRightMargin;
	private int mapTopMargin;
	private int mapBottomMargin;
	private int cellMargin;
	private int screenWidth;
	private int screenHeight;
	private int gamefieldWHeightInPercent;
	
	
	public int getCellsInLine() {
		return cellsInLine;
	}
	public void setCellsInLine(int cellsInLine) {
		this.cellsInLine = cellsInLine;
	}
	public int getCellsInRow() {
		return cellsInRow;
	}
	public void setCellsInRow(int cellsInRow) {
		this.cellsInRow = cellsInRow;
	}
	public int getCellsSize() {
		return cellsSize;
	}
	public void setCellsSize(int cellsSize) {
		this.cellsSize = cellsSize;
	}
	public int getMapLeftMargin() {
		return mapLeftMargin;
	}
	public void setMapLeftMargin(int mapLeftMargin) {
		this.mapLeftMargin = mapLeftMargin;
	}
	public int getMapRightMargin() {
		return mapRightMargin;
	}
	public void setMapRightMargin(int mapRightMargin) {
		this.mapRightMargin = mapRightMargin;
	}
	public int getMapTopMargin() {
		return mapTopMargin;
	}
	public void setMapTopMargin(int mapTopMargin) {
		this.mapTopMargin = mapTopMargin;
	}
	public int getMapBottomMargin() {
		return mapBottomMargin;
	}
	public void setMapBottomMargin(int mapBottomMargin) {
		this.mapBottomMargin = mapBottomMargin;
	}
	public int getCellMargin() {
		return cellMargin;
	}
	public void setCellMargin(int cellMargin) {
		this.cellMargin = cellMargin;
	}
	public int getScreenWidth() {
		return screenWidth;
	}
	public void setScreenWidth(int screenWidth) {
		this.screenWidth = screenWidth;
	}
	public int getScreenHeight() {
		return screenHeight;
	}
	public void setScreenHeight(int screenHeight) {
		this.screenHeight = screenHeight;
	}
	public int getGamefieldWHeightInPercent() {
		return gamefieldWHeightInPercent;
	}
	public void setGamefieldWHeightInPercent(int gamefieldWHeightInPercent) {
		this.gamefieldWHeightInPercent = gamefieldWHeightInPercent;
	}
	
	
}
