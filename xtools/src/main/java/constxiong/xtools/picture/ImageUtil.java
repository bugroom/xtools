package constxiong.xtools.picture;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

/**
 * 图片工具
 * @author ConstXiong
 * @date 2019-03-01 18:00:17
 */
public class ImageUtil {
	
	/**
	 * 绘制图片
	 * @param bufferedImage 缓冲图片
	 * @param type 图片类型
	 * @param file 文件
	 * @throws IOException 
	 */
	public static boolean drawSimpleImage(BufferedImage bufferedImage, String type, File file) throws IOException {
		Graphics g = bufferedImage.getGraphics();//获取图片画笔
		try {
			int backgroundX = 10;//背景x坐标
			int backgroundY = 40;//背景y坐标
			int backgroundWith = 180;//背景宽
			int backgroundHeight = 120;//背景高
			g.fillRect(backgroundX, backgroundY, backgroundWith, backgroundHeight);//填充背景，默认白色
			
			g.setColor(new Color(120, 120, 120));//设置画笔颜色
			
			int fontSize = 28;//字体大小
			g.setFont(new Font("宋体", Font.BOLD, fontSize));//设置字体
			
			int stringX = 10;//文字x坐标
			int stringY = 100;//文字y坐标
			g.drawString("绘制简单图片", stringX, stringY);
			return ImageIO.write(bufferedImage, type, file);
		} finally {
			g.dispose();//释放画笔
		}
	}
	
	/**
	 * 裁剪生成原图，生成新的图片
	 * @param srcPath 原图地址
	 * @param destPath 裁剪后的图片地址
	 * @param x 裁剪开始x坐标
	 * @param y 裁剪开始y坐标
	 * @param width 裁剪宽度
	 * @param height 裁剪高度
	 */
	public static boolean cutImage(String srcPath, String destPath, int x, int y, int width, int height) {
		return false;
	}
	
	/**
	 * 判断文件是否为
	 * @param srcPath
	 * @return
	 */
	public static boolean isImage(String srcPath) {
		return false;
	}
	
	public static boolean isImage(InputStream srcInputStream) {
		return false;
	}
	
	public static boolean compress (String srcPath, String destPath, float quality) {
		return false;
	}
	
	public static boolean resize (String srcPath, String destPath, int newWith, int newHeight) {
		return false;
	}
	
	public static boolean downloadImage() {
		return false;
	}
}
