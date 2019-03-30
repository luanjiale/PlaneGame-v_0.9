package cn.edu.xidian.cs;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class GameObject {
	/**
	 *游戏物体的父类
	 * @author LJL
	 */
      Image img;
      double x,y;
      int speed;
      int height,width;
     
     public void drawSelf(Graphics g) {
    	 g.drawImage(img, (int)x, (int)y, null);
     }
    //构造器
	public GameObject(Image img, double x, double y, int speed, int height, int width) {
		super();
		this.img = img;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.height = height;
		this.width = width;
	}
    //构造器
	public GameObject(Image img, double x, double y) {
		super();
		this.img = img;
		this.x = x;
		this.y = y;
	}
     public GameObject() {
     }
     //返回物体所在矩形，便于碰撞检测
     //@return
     public Rectangle getRect() {
    	 return new Rectangle((int)x, (int)y, width, height);
     }
}
