package com.softeem.planeGame;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

import javax.imageio.ImageIO;
/**
 * ͼƬ������  ���ڼ���ָ������ϷͼƬ��Դ
 * @author Administrator
 *
 */
public class ImageLoader {

	public static BufferedImage load(String path) {
	   try {
		   //��ȡָ�����ļ�����ȡ��ǰ�ļ�����ʾ��URL����
		URL url=ImageLoader.class.getResource("/imgs/"+path);
		
			//��ȡ�ƶ���ͼƬ���Ҽ���ΪJava����
		  return ImageIO.read(url);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;	
	}
	public static void main(String[] args) {
		System.out.println(load("background.png"));
	}
}
