package com.softeem.planeGame;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

/**
 * 游戏的面板
 * 游戏中所有元素的绘制，消亡，修改都在当前面板完成
 * @author Administrator
 *
 */
public class GamePanel extends JPanel implements MouseMotionListener{

	BufferedImage bg;//游戏界面背景图片
	int bgX;//绘制背景的起始位置X
	int bgY;//绘制背景的起始位置Y
	int bgWidth;//绘制游戏背景图片的宽度
	int bgHeight;//绘制游戏背景图片的高度
	int initSpeed=10;//初始游戏速度
	Timer timer;//声明定时器
	
	
	Hero hero=new Hero();//创建有英雄机
	
	static List<Enemy> enemies=new ArrayList<Enemy>();//声明敌机集合
	static List<Bullet> bullets=new ArrayList<Bullet>();//声明子弹集合
	static int totalScore;//统计总分
	//Enemy enemy=new Enemy();
	
	
	public GamePanel() {
		super();
		// TODO Auto-generated constructor stub
		addMouseMotionListener(this);
		//setBackground(Color.blue);
		//加载背景图片
		bg=ImageLoader.load("background.png");
		bgWidth=bg.getWidth();//获取图片宽度
		bgHeight=bg.getHeight();//获取图片高度
		bgY=Setting.HEIGHT-bgHeight;//初始背景图片显示的位置
		timer=new Timer();//创建定时器
		timer.schedule(new RefreshTask(), 0,50);//启动定时任务，刷新页面
		//启动定时创建敌机  立即开始创建  每一秒创建一架
		timer.schedule(new EnemyFactory(), 0, 1000);
	}
	//创建一个产生敌机的任务
	class EnemyFactory extends TimerTask{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			Enemy e=new Enemy();//产生敌机
			e.start();
			enemies.add(e);//将敌机加入容器
			//System.out.println("创建一架敌机"+e.type);
		}
		
	}
	
	
	
	
	
	//创建一个刷新任务（定时改变背景的显示位置  营造飞行效果）内部类
	class RefreshTask extends TimerTask{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			bgY+=initSpeed;//增加y轴值，让图片的绘制位置递增
			
			//图片循环滚动
			if(bgY>0){
				bgY=Setting.HEIGHT-bgHeight;
			}
			repaint();//界面重绘
		}
		
	}
	
	@Override
	public void paint(Graphics g) {
		//绘制背景
		g.drawImage(bg, bgX, bgY, bgWidth, bgHeight, null);
		//绘制英雄机
		g.drawImage(hero.heroImg, hero.x, hero.y, hero.width, hero.height, null);
		//g.drawImage(enemy.img, enemy.x, enemy.y, enemy.width, enemy.height, null);
		//绘制敌机
		for(int i=0;i<enemies.size();i++){
			Enemy e=enemies.get(i);
			g.drawImage(e.img, e.x, e.y,e.width, e.height, null);
		}
		//绘制子弹
		for(int i=0;i<bullets.size();i++){
			Bullet b=bullets.get(i);
			g.drawImage(b.img, b.x, b.y,b.width, b.height, null);
		}
		//将得分情况绘制到面板中
		g.drawString("得分："+totalScore, 20, 20);
	}

	
	//拖拽鼠标时触发
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("别拽");
	}

	
	//鼠标在界面中移动时触发
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		int x=e.getX();//获取鼠标所在x轴
		int y=e.getY();//获取鼠标所在y轴
		//System.out.println("当前位置："+x+","+y);
		hero.moveTo(x, y);//改变飞机位置
		repaint();//一旦改变位置，界面立即重绘
	}
	
}
