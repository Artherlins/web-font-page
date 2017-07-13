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
 * ��Ϸ�����
 * ��Ϸ������Ԫ�صĻ��ƣ��������޸Ķ��ڵ�ǰ������
 * @author Administrator
 *
 */
public class GamePanel extends JPanel implements MouseMotionListener{

	BufferedImage bg;//��Ϸ���汳��ͼƬ
	int bgX;//���Ʊ�������ʼλ��X
	int bgY;//���Ʊ�������ʼλ��Y
	int bgWidth;//������Ϸ����ͼƬ�Ŀ��
	int bgHeight;//������Ϸ����ͼƬ�ĸ߶�
	int initSpeed=10;//��ʼ��Ϸ�ٶ�
	Timer timer;//������ʱ��
	
	
	Hero hero=new Hero();//������Ӣ�ۻ�
	
	static List<Enemy> enemies=new ArrayList<Enemy>();//�����л�����
	static List<Bullet> bullets=new ArrayList<Bullet>();//�����ӵ�����
	static int totalScore;//ͳ���ܷ�
	//Enemy enemy=new Enemy();
	
	
	public GamePanel() {
		super();
		// TODO Auto-generated constructor stub
		addMouseMotionListener(this);
		//setBackground(Color.blue);
		//���ر���ͼƬ
		bg=ImageLoader.load("background.png");
		bgWidth=bg.getWidth();//��ȡͼƬ���
		bgHeight=bg.getHeight();//��ȡͼƬ�߶�
		bgY=Setting.HEIGHT-bgHeight;//��ʼ����ͼƬ��ʾ��λ��
		timer=new Timer();//������ʱ��
		timer.schedule(new RefreshTask(), 0,50);//������ʱ����ˢ��ҳ��
		//������ʱ�����л�  ������ʼ����  ÿһ�봴��һ��
		timer.schedule(new EnemyFactory(), 0, 1000);
	}
	//����һ�������л�������
	class EnemyFactory extends TimerTask{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			Enemy e=new Enemy();//�����л�
			e.start();
			enemies.add(e);//���л���������
			//System.out.println("����һ�ܵл�"+e.type);
		}
		
	}
	
	
	
	
	
	//����һ��ˢ�����񣨶�ʱ�ı䱳������ʾλ��  Ӫ�����Ч�����ڲ���
	class RefreshTask extends TimerTask{

		@Override
		public void run() {
			// TODO Auto-generated method stub
			bgY+=initSpeed;//����y��ֵ����ͼƬ�Ļ���λ�õ���
			
			//ͼƬѭ������
			if(bgY>0){
				bgY=Setting.HEIGHT-bgHeight;
			}
			repaint();//�����ػ�
		}
		
	}
	
	@Override
	public void paint(Graphics g) {
		//���Ʊ���
		g.drawImage(bg, bgX, bgY, bgWidth, bgHeight, null);
		//����Ӣ�ۻ�
		g.drawImage(hero.heroImg, hero.x, hero.y, hero.width, hero.height, null);
		//g.drawImage(enemy.img, enemy.x, enemy.y, enemy.width, enemy.height, null);
		//���Ƶл�
		for(int i=0;i<enemies.size();i++){
			Enemy e=enemies.get(i);
			g.drawImage(e.img, e.x, e.y,e.width, e.height, null);
		}
		//�����ӵ�
		for(int i=0;i<bullets.size();i++){
			Bullet b=bullets.get(i);
			g.drawImage(b.img, b.x, b.y,b.width, b.height, null);
		}
		//���÷�������Ƶ������
		g.drawString("�÷֣�"+totalScore, 20, 20);
	}

	
	//��ק���ʱ����
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		//System.out.println("��ק");
	}

	
	//����ڽ������ƶ�ʱ����
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		int x=e.getX();//��ȡ�������x��
		int y=e.getY();//��ȡ�������y��
		//System.out.println("��ǰλ�ã�"+x+","+y);
		hero.moveTo(x, y);//�ı�ɻ�λ��
		repaint();//һ���ı�λ�ã����������ػ�
	}
	
}
