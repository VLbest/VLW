package com.vli.utils;

import android.util.Log;

public class LOG {
	
	private static final String TAG = "MLog";
	
	public static void showErrorLog(String str, Exception ex){
		Log.e(TAG, str);
		LOG.showInfoLog(" --- ***** ---");
		ex.printStackTrace();
		LOG.showInfoLog(" --- ***** ---");
	}
	
	public static void showInfoLog(String str){
		Log.i(TAG, str);
	}

	public static void showInfoLog(int nb) {
		String str = String.valueOf(nb);
		Log.i(TAG, str);
	}
}
