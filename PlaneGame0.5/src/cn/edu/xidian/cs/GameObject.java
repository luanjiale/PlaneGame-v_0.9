package cn.edu.xidian.cs;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class GameObject {
	/**
	 *��Ϸ����ĸ���
	 * @author LJL
	 */
      Image img;
      double x,y;
      int speed;
      int height,width;
     
     public void drawSelf(Graphics g) {
    	 g.drawImage(img, (int)x, (int)y, null);
     }
    //������
	public GameObject(Image img, double x, double y, int speed, int height, int width) {
		super();
		this.img = img;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.height = height;
		this.width = width;
	}
    //������
	public GameObject(Image img, double x, double y) {
		super();
		this.img = img;
		this.x = x;
		this.y = y;
	}
     public GameObject() {
     }
     //�����������ھ��Σ�������ײ���
     //@return
     public Rectangle getRect() {
    	 return new Rectangle((int)x, (int)y, width, height);
     }
}
