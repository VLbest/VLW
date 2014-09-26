package com.vli.mapfactory;

import com.vli.conf.Configurable;
import com.vli.gamefield.Cell;
import com.vli.gamefield.Map;
import com.vli.main.GameCore;

public class ClassicMapCreator extends MapFactory{

	@Override
	public Map createMap(Configurable conf) {
		
		int nbOfLines = conf.getCellsInRow();
		int nbOfRows = conf.getCellsInLine();
		
		int left = conf.getMapLeftMargin();
		int right = conf.getMapRightMargin();
		int top = conf.getMapTopMargin();
		int bottom = conf.getMapBottomMargin();
		
		int size = conf.getCellsSize();
		int margin = conf.getCellMargin();
		
		Map map = new Map();
		map.intitMap(nbOfRows, nbOfLines);
		for(int y = 0; y < nbOfLines; y++){
			for(int x = 0; x < nbOfRows; x++){
				Cell c = new Cell();
				c.setLineNb(y+1);
				c.setRowNb(x+1);
				c.setBounds(left, top, left + size, top + size);
				
				map.addCell(x, y, c);
				
				GameCore.addObjectsToRender(c);
				
				left = left + size + margin;
			}
			left = conf.getMapLeftMargin();
			top = top + size + margin;
		}
		return map;
	}
	
}
