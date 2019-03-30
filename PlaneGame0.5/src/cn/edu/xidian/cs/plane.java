package cn.edu.xidian.cs;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

public class plane extends GameObject {
	boolean left, right, up, down;
	boolean live = true;

	public void drawSelf(Graphics g) {
		if (live) {

			g.drawImage(img, (int) x, (int) y, null);
			if (left && x > 20) {
				x -= speed;
			}
			if (right && x < 900) {
				x += speed;
			}
			if (up && y > 50) {
				y -= speed;
			}
			if (down && y < 720) {
				y += speed;
			}
		}else {
			
		}

	}

	public plane(Image img, double x, double y, int speed, int height, int width) {
		this.img = img;
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.width = width;
		this.height = height;
	}

	// 按键增加方向坐标
	public void addDirection(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_A:
			left = true;
			break;
		case KeyEvent.VK_D:
			right = true;
			break;
		case KeyEvent.VK_W:
			up = true;
			break;
		case KeyEvent.VK_S:
			down = true;
			break;
		default:
			break;
		}
	}

	// 松开键取消增加
	public void minusDirection(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_A:
			left = false;
			break;
		case KeyEvent.VK_D:
			right = false;
			break;
		case KeyEvent.VK_W:
			up = false;
			break;
		case KeyEvent.VK_S:
			down = false;
			break;
		default:
			break;
		}
	}
}
