package com.softeem.planeGame;

import javax.swing.JFrame;
/*
 * �������
 * */
public class Main extends JFrame{
	//������������Ϸ�����
	GamePanel panel=new GamePanel();
	
	
	
   /*
    * ����������������ʱ���һЩ����
    * */
	public Main(){
    	setTitle(Setting.TITLE);
    	setSize(Setting.WIDTH, Setting.HEIGHT);
    	add(panel);//�������봰��
    	setLocationRelativeTo(this);
    	setResizable(false);
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	setVisible(true);
    } 
	
	public static void main(String[] args) {
		new Main();
	}
}
