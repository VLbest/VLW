package com.vli.main;

import android.view.SurfaceHolder;

public interface HaveGameView {

	SurfaceHolder getHolder();

	void setGame(HaveGameBahavior gameCore);

}
