package cn.edu.xidian.cs;

import java.awt.Graphics;
import java.awt.Image;

public class Explode {
       double x,y;
       static Image[] image=new Image[16];
       static {
    	   for(int i=0;i<16;i++) {
    		   image[i]=GameUtil.getImage("images/explode/e"+(i+1)+".gif");
    		   image[i].getWidth(null);
    	   }
       }
       
       public Explode(double x,double y) {
    	   this.x=x;
    	   this.y=y;
       }
       int count;
       
       public void draw(Graphics g) {
    	   if(count<=15) {
    		   g.drawImage(image[count],(int)x,(int)y,null);
    		   count++;
    	   }
       }
}
