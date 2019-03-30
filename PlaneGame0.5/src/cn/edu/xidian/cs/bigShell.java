//package cn.edu.xidian.cs;
//
//import java.awt.Color;
//import java.awt.Graphics;
//
//public class bigShell extends shell{
//	double degree;
//	public void bigShell() {
//		
//		x=100;
//    	y=100;
//    	width=40;
//    	height=40;
//    	speed=15;
//    	degree=Math.random()*Math.PI*2;
//    }
//	public void drawSelf(Graphics g) {
//		System.out.println("1111");
//    	Color c=g.getColor();
//    	g.setColor(Color.blue);
//    	g.fillOval((int)x, (int)y, width, height);
//    	g.setColor(c);
//    	x+=speed*Math.cos(degree);
//    	y+=speed*Math.sin(degree);
//    	
//    	if(x<5||x>constant.GAME_WIDTH-width-5) {
//    		degree= Math.PI-degree;
//    	}
//    	if(y<40||y>constant.GAME_HEIGHT-height) {
//    		degree= -degree;
//    	}
//    }
//}
package cn.edu.xidian.cs;

import java.awt.Color;
import java.awt.Graphics;

/**
 * ÅÚµ¯Àà
 * @author LJL
 *
 */

public class bigShell extends shell {
        double degree1;
        double x1,y1;
        int width1,height1;
        public void bigShell() {
        	x1=300;
        	y1=300;
        	width1=20;
        	height1=20;
        	speed=15;
        	degree1=Math.random()*Math.PI*2;
        }
        public void drawSelf(Graphics g) {
        	Color c=g.getColor();
        	g.setColor(Color.GREEN);
        	g.fillOval((int)x, (int)y, 20, 20);
        	g.setColor(c);
        	x+=speed*Math.cos(degree);
        	y+=speed*Math.sin(degree);
        	
        	if(x<5||x>constant.GAME_WIDTH-width-5) {
        		degree= Math.PI-degree;
        	}
        	if(y<40||y>constant.GAME_HEIGHT-height) {
        		degree= -degree;
        	}
      
        	
}}
