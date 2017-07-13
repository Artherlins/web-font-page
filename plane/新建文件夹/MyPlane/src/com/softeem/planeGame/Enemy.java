package com.softeem.planeGame;

import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 敌机类
 * 每一架敌机都是一个独立的线程对象
 * @author Administrator
 *
 */
public class Enemy extends Thread{

	BufferedImage img;//声明用于渲染敌机的图片对象
	int x;//绘制敌机的位置的x轴
	int y;//绘制敌机的位置的y轴
	int width;//敌机宽度
	int height;//敌机高度
	int type;//敌机类型
	int speed;//飞行速度
	int blood;//飞机的血槽
	int score;//飞机价值，即得分情况
	boolean isDead;//标志位，标记飞机是否已经被销毁（不代表从面板中消失）
	
	public Enemy() {
		// TODO Auto-generated constructor stub
		Random r=new Random();//创建一个随机工具对象
		//x=r.nextInt(400);
		int i=r.nextInt(10)+1;//生成1-10之间的随机数
		type=i%10==0?2:i%3==0?1:0;//设置不同类型敌机出现的概率6：3：1
//		if(i%10==0){
//			type=2;
//		}else if(i%3==0){
//			type=1;
//		}else{
//			type=0;
//		}
		img=ImageLoader.load("enemy"+type+".png");
		//获取飞机的大小，等比例缩小1倍
		width=img.getWidth()/2;
		height=img.getHeight()/2;
		//根据飞机类型设定飞行速度以及血量
		if(type==0){
			speed=15;
			blood=1;
			score=30;
		}else if(type==1){
			speed=10;
			blood=6;
			score=50;
		}else if(type==2){
			speed=8;
			blood=30;
			score=70;
		}
		//随机产生一个x坐标
		x=r.nextInt(Setting.WIDTH-width);
		y=-height;
//		if(x>(x-width)){
//			x=x-width;
//		}
	}
	
	
	public void run() {
		while(true){
		try {
			y+=speed;
			//判断敌机是否已经飞出屏幕外
			if(y>Setting.HEIGHT){
				//移除敌机对象
				GamePanel.enemies.remove(this);
				break;//结束循环
			}
			sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	}
	
	//销毁敌机
	public void boom() {
		isDead=true;
		GamePanel.totalScore +=this.score;
		//System.out.println(GamePanel.totalScore);
		//GamePanel.enemies.remove(this);
		//执行销毁动画(内部类：匿名内部类)
		new Thread(){
			public void run() {
				int count=0;//计数器  统计已播放的图片数
				while(true){
					count++;
					if(type==2){
						if(count>6){
							count=0;
							GamePanel.enemies.remove(Enemy.this);
							break;
						}else{
						//大型飞机
						img=ImageLoader.load("enemy"+type+"_down"+count+".png");
						}
						}else{
						if(count>4){
							count=0;
							GamePanel.enemies.remove(Enemy.this);
							break;
						}else{
							//中小型飞机
							img=ImageLoader.load("enemy"+type+"_down"+count+".png");
							}
						}
						try {
							sleep(200);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						
					}
				}
			}
		}.start();
	}
	
	
	
}
