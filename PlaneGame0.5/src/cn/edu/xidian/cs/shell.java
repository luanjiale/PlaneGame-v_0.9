package cn.edu.xidian.cs;

import java.awt.Color;
import java.awt.Graphics;

/**
 * ÅÚµ¯Àà
 * @author LJL
 *
 */

public class shell extends GameObject {
        double degree;
        public shell() {
        	x=400;
        	y=350;
        	width=15;
        	height=15;
        	speed=5;
        	degree=Math.random()*Math.PI*2;
        }

        public void drawSelf(Graphics g) {
        	Color c=g.getColor();
        	g.setColor(Color.RED);
        	g.fillOval((int)x, (int)y, width, height);
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
