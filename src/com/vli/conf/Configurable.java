package com.vli.conf;

public interface Configurable {

	int getCellsInRow();

	int getCellsInLine();

	int getMapLeftMargin();

	int getMapRightMargin();

	int getMapTopMargin();

	int getMapBottomMargin();

	int getCellsSize();

	int getCellMargin();

	void setScreenWidth(int widthPixels);

	void setScreenHeight(int heightPixels);

	void setGamefieldWHeightInPercent(int i);

	void setCellMargin(int i);

	void setMapBottomMargin(int i);

	void setMapRightMargin(int i);

	void setMapLeftMargin(int i);

	int getGamefieldWHeightInPercent();

	int getScreenHeight();

	void setMapTopMargin(int i);

	int getScreenWidth();

	void setCellsSize(int i);

	void setCellsInRow(int i);

	void setCellsInLine(int i);

}
