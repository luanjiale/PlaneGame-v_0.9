package cn.edu.xidian.cs;

import java.awt.*;
import java.awt.event.*;
import java.util.Date;

import javax.swing.*;
import javax.xml.crypto.Data;

public class PlaneGameFrame extends Frame {

	/**
	 * 成员变量
	 */
	Image planeimg = GameUtil.getImage("images/plane1.png");
	Image bg = GameUtil.getImage("images/bg.jpg");
	plane plane = new plane(planeimg, 600, 500, 6, 40, 40);
	shell[] shells = new shell[30];
	bigShell[] bigShell = new bigShell[10];
	Explode bao;
	Date startTime = new Date();
	Date endTime;
	int period;// 游戏时间

	/**
	 * 绘画线程，帮助自动绘画
	 * 
	 * @author LJL
	 *
	 */
	class PaintThread extends Thread {
		public void run() {
			while (true) {
				repaint();
				try {
					Thread.sleep(30);
				} catch (InterruptedException e) {
					e.printStackTrace();

				}

			}
		}
	}

	// 定义键盘监听
	class KeyMonitor extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			plane.addDirection(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			plane.minusDirection(e);
		}
	}

	/**
	 * 初始化窗口
	 */
	public void LaunchFrame() {
		this.setTitle("代賬龍打飛機1.0");
		this.setVisible(true);// 窗口可視化
		setSize(constant.GAME_WIDTH, constant.GAME_HEIGHT);
		setLocation(100, 100);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		new PaintThread().start();
		addKeyListener(new KeyMonitor());

		/**
		 * 初始化50个炮弹
		 */
		for (int i = 0; i < shells.length; i++) {
			shells[i] = new shell();
		}
		for (int i = 0; i < bigShell.length; i++) {
			bigShell[i] = new bigShell();
		}
	}

	/**
	 * 绘画方法
	 */
	public void paint(Graphics g) {// 自動被調用，g相當於畫筆
		
        Color c=g.getColor();
        
		g.drawImage(bg, 0, 0, null);
		plane.drawSelf(g);// 画飞机
		/**
		 * 画50个shell
		 */
		for (int i = 0; i < shells.length; i++) {
			shells[i].drawSelf(g);

			boolean peng = shells[i].getRect().intersects(plane.getRect());
			if (peng) {
				plane.live = false;
				if (bao == null) {
					bao = new Explode(plane.x, plane.y);
					endTime = new Date();
					period = (int) ((endTime.getTime() - startTime.getTime()) / 1000);
				}

				bao.draw(g);
			}
			//计时功能
			if (!plane.live) {
				g.setColor(Color.RED);
				Font f=new Font("楷体", Font.BOLD, 38);
				g.setFont(f);
				g.drawString("时间： " + period + "秒", (int) plane.x, (int) plane.y);
			}

		}
		for (int i = 0; i < bigShell.length; i++) {
			bigShell[i].drawSelf(g);
			boolean peng = bigShell[i].getRect().intersects(plane.getRect());
			if (peng) {
				plane.live = false;
				if (bao == null) {
					bao = new Explode(plane.x, plane.y);
					endTime = new Date();
					period = (int) ((endTime.getTime() - startTime.getTime()) / 1000);
				}
				bao.draw(g);
			}
			//计时功能
			if (!plane.live) {
				g.setColor(Color.RED);
				Font f=new Font("楷体", Font.BOLD, 38);
				g.setFont(f);
				g.drawString("时间： " + period + "秒", (int) plane.x, (int) plane.y);
			}
		}
		
		g.setColor(c);
	}

	// main方法
	public static void main(String[] args) {
		PlaneGameFrame pg = new PlaneGameFrame();
		pg.LaunchFrame();
	}

	// 双缓冲解决闪烁问题
	private Image offScreenImage = null;

	public void update(Graphics g) {
		if (offScreenImage == null)
			offScreenImage = this.createImage(constant.GAME_WIDTH, constant.GAME_HEIGHT);
		Graphics gOff = offScreenImage.getGraphics();
		paint(gOff);
		g.drawImage(offScreenImage, 0, 0, null);

	}
}