package com.vli.utils;

public class Logger {
	
	private static final String TAG = "MLog";
	private LogTypes currentLog;
	private String currentMessage;
	
	private enum LogTypes{
		DEBUG, INFO, STEPS, ALL, NONE;
	};
	
	
	public Logger(){
		this.currentLog = LogTypes.ALL;
		
	}
	
	
	public static void debugLog(){
		
	}
	
	public static void infoLog(){
		
	}

	public static void stepLog(){
	
	}
	
	private void showLog(String str){
		
	}
	
	private void concat(String str){
		this.currentMessage.concat(" " + str + "");
	}
	
	
	public void add(String str){
		this.concat(str);
	}
	
	public void add(int i){
		this.concat(String.valueOf(i));
	}
	
	public void add(float f){
		this.concat(String.valueOf(f));
	}
	
	public void add(boolean b){
		this.concat(String.valueOf(b));
	}
	
	public void add(Object o){
		if(o == null){
			this.concat("object is not exists");
		}else{
			this.concat(o.getClass().getSimpleName() + "exists");
		}
	}
	
}
