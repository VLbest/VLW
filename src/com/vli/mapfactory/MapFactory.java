package com.vli.mapfactory;

import com.vli.conf.Configurable;
import com.vli.gamefield.Map;

public abstract class MapFactory {

	public Map getMap(Configurable conf){
		Map map;
		
		map = this.createMap(conf);
		
		return map;
		
	}

	public abstract Map createMap(Configurable conf);
	
}
