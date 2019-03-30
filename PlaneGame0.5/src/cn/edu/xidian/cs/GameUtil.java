package cn.edu.xidian.cs;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.net.URL;

public class GameUtil {
	  //工具類對構造器私有化
      private GameUtil() {
      }
      
      /**
       * 返回指定路径文件的图片对象
       * @param path
       * @return
      */
      
    public static Image getImage(String path) {
    	BufferedImage bi=null;
    try {
    	URL u=GameUtil.class.getClassLoader().getResource(path);
    	bi=ImageIO.read(u);
    } catch	(IOException e) {
    	e.printStackTrace();
    }
      return bi;
    }
}
