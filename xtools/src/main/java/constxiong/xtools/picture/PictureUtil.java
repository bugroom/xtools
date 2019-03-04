package constxiong.xtools.picture;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 图片工具
 * @author ConstXiong
 * @date 2019-03-01 18:00:17
 */
public class PictureUtil {
	
	/**
	 * 绘制图片
	 * @param bufferedImage 缓冲图片
	 * @param type 图片类型
	 * @param file 文件
	 * @throws IOException 
	 */
	public static void drawImage(BufferedImage bufferedImage, String type, File file) throws IOException {
		Graphics graphics = bufferedImage.getGraphics();//获取图片画笔
		graphics.fillRect(0, 50, 200, 100);//填充图片，默认白色
		graphics.setColor(new Color(12, 123, 88));//设置画笔颜色
		graphics.setFont(new Font("宋体", Font.ITALIC, 30));//设置字体
		graphics.drawString("绘制简单图片", 10, 100);
		graphics.dispose();//释放画笔
		ImageIO.write(bufferedImage, type, file);
	}
}
