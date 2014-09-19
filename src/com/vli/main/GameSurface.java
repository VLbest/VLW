package com.vli.main;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class GameSurface extends SurfaceView implements GameView{
	
	private SurfaceHolder holder;
	private HolderCallback callback;

	public GameSurface(Context context){
		super(context);
	}
	
	public GameSurface(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	
	public void initSurface(){
		this.holder = this.getHolder();
		this.holder.addCallback(callback);
		
	}

	@Override
	public SurfaceHolder getSurfaceHolder() {
		return this.holder;
	}

}
