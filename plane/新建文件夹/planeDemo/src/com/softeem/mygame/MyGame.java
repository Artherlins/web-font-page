package com.softeem.mygame;

import java.io.IOException;

import com.softeem.plane.PlaneGame;

public class MyGame {
  
	
	public static void main(String[] args) throws IOException {
	  PlaneGame pg=new PlaneGame();
	  pg.setTitle("hit a plane");
	  pg.showGameBg();
	  pg.showMyPlane();
	  pg.showEnemys();
	  pg.startGame();
    }
}
