package com.vli.gamefield;

import android.graphics.Rect;
import android.graphics.Paint.Style;

public class Cell extends Sprite implements CellBehavior{

	private Letter letter;
	private String hexColor;
	private int lineNb;
	private int rowNb;
	
	public Cell(){
		super();
		this.paint.setColor(0xFFFF0000);
		this.paint.setStyle(Style.FILL);
	}

	public Letter getLetter() {
		return letter;
	}

	public void setLetter(Letter letter) {
		this.letter = letter;
	}

	public String getHexColor() {
		return hexColor;
	}

	public void setHexColor(String hexColor) {
		this.hexColor = hexColor;
	}

	public int getLineNb() {
		return lineNb;
	}

	public void setLineNb(int lineNb) {
		this.lineNb = lineNb;
	}

	public int getRowNb() {
		return rowNb;
	}

	public void setRowNb(int rowNb) {
		this.rowNb = rowNb;
	}
	
}
