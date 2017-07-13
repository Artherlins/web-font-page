package com.snake;

import java.awt.HeadlessException;

import javax.swing.JFrame;

public class SnakeWin extends JFrame {
	
	public SnakeWin() throws HeadlessException {
		super();
		setSize(440, 400);
		setTitle("̰����");
		add(new SnakeJPanel());
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		SnakeWin sw=new SnakeWin();
		sw.setVisible(true);

	}

}
