package com.softeem.planeGame;

import java.awt.image.BufferedImage;
import java.util.Timer;
import java.util.TimerTask;
/**
 * 英雄机
 * @author Administrator
 *
 */
public class Hero {

	BufferedImage heroImg;//声明用于渲染飞机的图片对象
	int x;//绘制坐标x
	int y;//绘制坐标y
	int width;//英雄机宽度
	int height;//英雄机高度
	int flag=1;//飞机的标识
	Timer timer;
	
	
	public  Hero() {
		heroImg=ImageLoader.load("hero1.png");//加载渲染图片
		width=heroImg.getWidth()/2;//获取飞机的宽度
		height=heroImg.getHeight()/2;//获取飞机的高度
		y=Setting.HEIGHT-height*2;//设置y轴位置
		x=(Setting.WIDTH-width)/2;//设置x轴位置
		//创建定时器
		timer=new Timer();
		//启动飞行定时任务
		timer.schedule(new FlyTask(), 0,200);
		//开始射击
		startShoot();
	}
	//飞行任务  不断切换飞机图片  实现飞机动画效果
	class FlyTask extends TimerTask{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			if(flag==1){
				flag=2;
			}else{
				flag=1;
			}
			//加载制定的飞行图片
			heroImg=ImageLoader.load("hero"+flag+".png");
		}
		
	}
	//发射子弹的任务
	class BulletTask extends TimerTask{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			Bullet b=new Bullet(x+width/2, y);
			//将创建的子弹加入到子弹集合中
			GamePanel.bullets.add(b);
			//启动子弹的飞行线程
			b.start();
		}
		
	}
	
	//开始发射子弹（不断产生子弹对象，并且将子弹对象加入子弹集合）
	public void startShoot() {
		//创建定时器对象
		timer=new Timer();
		//启动子弹创建的任务
		timer.schedule(new BulletTask(), 100, 200);
	}
	
	//停止发射子弹
   public void stopShoot() {
		
	}
	
	//移动英雄机
	public void moveTo(int x,int y) {
		this.x=x-width/2;
		this.y=y-height/2;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
