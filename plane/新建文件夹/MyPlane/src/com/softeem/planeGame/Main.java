package com.softeem.planeGame;

import javax.swing.JFrame;
/*
 * 程序入口
 * */
public class Main extends JFrame{
	//声明并创建游戏主面板
	GamePanel panel=new GamePanel();
	
	
	
   /*
    * 构造器：创建对象时完成一些动作
    * */
	public Main(){
    	setTitle(Setting.TITLE);
    	setSize(Setting.WIDTH, Setting.HEIGHT);
    	add(panel);//将面板加入窗体
    	setLocationRelativeTo(this);
    	setResizable(false);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setVisible(true);
    } 
	
	public static void main(String[] args) {
		new Main();
	}
}
