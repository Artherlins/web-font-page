package com.softeem.planeGame;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

import javax.imageio.ImageIO;
/**
 * 图片加载器  用于加载指定的游戏图片资源
 * @author Administrator
 *
 */
public class ImageLoader {

	public static BufferedImage load(String path) {
	   try {
		   //读取指定的文件并获取当前文件所表示的URL对象
		URL url=ImageLoader.class.getResource("/imgs/"+path);
		
			//读取制定的图片并且加载为Java对象
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
