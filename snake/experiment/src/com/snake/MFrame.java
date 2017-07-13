package com.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class MFrame extends JFrame implements KeyListener{
	int x=50;
	int y=50;
	public MFrame() throws HeadlessException {
		super();
		setSize(440, 400);
//		setTitle("̰����");
//		add(new SnakeJPanel());
		addKeyListener(this);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.setColor(Color.red);
		g.fillOval(x, y, 30, 30);
	}



	public static void main(String[] args) {
		MFrame sw=new MFrame();
		sw.setVisible(true);

	}



	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()){
			case KeyEvent.VK_UP:y-=5;break;
			case KeyEvent.VK_DOWN:y+=5;break;
			case KeyEvent.VK_LEFT:x-=5;break;
			case KeyEvent.VK_RIGHT:x+=5;break;
		}
		repaint();
		
	}



	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
