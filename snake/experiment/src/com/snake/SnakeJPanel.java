package com.snake;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SnakeJPanel extends JPanel implements ActionListener,KeyListener,Runnable{
	JButton startButton=new JButton("开始");
	JButton exitButton=new JButton("退出");
	int fenshu=0;
	int speed=1;
	Point food;
	Random ran=new Random();
	boolean start=false;
	LinkedList<Point> snake=new LinkedList<Point>();
	Thread th;
	int direction=1;
	int foodcount=0;
	
	public SnakeJPanel() {
		super();
		setLayout(new FlowLayout(FlowLayout.LEFT));
		startButton.addActionListener(this);
		exitButton.addActionListener(this);
		addKeyListener(this);
		add(startButton);
		add(exitButton);
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.drawRect(15, 40, 400, 300);
		g.drawString("分数："+fenshu, 150, 25);
		g.drawString("速度："+speed, 250, 25);
		
		if(start){
		g.setColor(Color.red);
		g.fillRect(food.x*10+15, food.y*10+40, 10, 10);
		
		g.setColor(Color.green);
		for(Point p:snake){
			g.fill3DRect(p.x*10+15, p.y*10+40, 10, 10,true);
		}
		
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(exitButton)){
			System.exit(0);
		}
		
		if(e.getSource().equals(startButton)){
			start=true;
			startButton.setEnabled(false);
			food=new Point(ran.nextInt(40),ran.nextInt(30));
			Point p=new Point(20,20);
			snake.add(p);
			requestFocus(true);
			th=new Thread(this);
			th.start();
			repaint();
		}
		
		
	}
	//蛇运动的范围
	public boolean fanwei(int x,int y){
		if(x<0||x>=40||y<0||y>=30){
			return false;
		}
		return true;
	}
	//进行预判 在边界时撞墙
	public boolean nextFanwei(int x,int y){
		if(!fanwei(snake.get(0).x+x,snake.get(0).y+y)){
			return false;
		}
		for(int i=1;i<snake.size();i++){
			if(snake.size()>2&&snake.get(0).equals(snake.get(i))){
				return false;
			}
		}
		return true;
	}
//蛇吃食物后身体连起来
	public void otherMove(){
		Point t = new Point();
		for (int i = 1; i < snake.size(); i++) {
			if (i == 1) {
				snake.get(i).x=snake.get(0).x;
				snake.get(i).y=snake.get(0).y;
			} else {
				t = snake.get(i);
				snake.set(i, snake.get(i - 1));
				snake.set(i - 1, t);
			}}		
	}
//通过改变横纵坐标来使蛇移动
	public void move(int x,int y){
		if(nextFanwei(x, y)){
		otherMove();
		snake.get(0).x+=x;
		snake.get(0).y+=y;
		eat();
		fenshu+=speed*5;
		repaint();
		}else{
			start=false;
			SnakeJDia sjd=new SnakeJDia(this);
			sjd.setVisible(true);
		}
	}
	
	public void eat(){
		if(snake.get(0).equals(food)){
//			snake.add(food);
//			food=new Point(ran.nextInt(40),ran.nextInt(30));
			food=new Point(ran.nextInt(40), ran.nextInt(30));
			Point p=new Point(snake.get(snake.size()-1).x,snake.get(snake.size()-1).y);
			snake.add(p);
			
			foodcount++;
			fenshu+=speed*100;//增加分数
			if(foodcount%5==0){
				speed++;//改变速度
			}

		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()){
		case KeyEvent.VK_UP:move(0,-1);direction=1;break;
		case KeyEvent.VK_DOWN:move(0,1);direction=2;break;
		case KeyEvent.VK_LEFT:move(-1,0);direction=3;break;
		case KeyEvent.VK_RIGHT:move(1,0);direction=4;break;
	}
//	repaint();
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void myclear(){
		start=false;
		foodcount=0;
		fenshu=0;
		speed=1;
		direction=1;
		startButton.setEnabled(true);
		snake.clear();
		
	}

	@Override
	public void run() {
		while(start){
			switch(direction){
			case 1:move(0,-1);break;
			case 2:move(0,1);break;
			case 3:move(-1,0);break;
			case 4:move(1,0);break;
			}
			repaint();
			try {
				Thread.sleep(300-30*speed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}
