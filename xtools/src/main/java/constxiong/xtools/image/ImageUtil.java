package constxiong.xtools.image;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import constxiong.xtools.convert.HexConverter;

/**
 * 图片工具
 * @author ConstXiong
 * @date 2019-03-01 18:00:17
 */
public class ImageUtil {
	
	/**
	 * .分隔符
	 */
	private static final String FILE_CONNECTOR_POINT = "\\.";
	
	/**
	 * jpg格式图片文件头hex信息 
	 */
	private static final String JPG_HEX = "FFD8FF";
	/**
	 * png格式图片文件头hex信息
	 */
	private static final String PNG_HEX = "89504E47";
	/**
	 * gif格式图片文件头hex信息
	 */
	private static final String GIF_HEX = "47494638";
	/**
	 * bmp格式图片文件头hex信息
	 */
	private static final String BMP_HEX = "424D";
	
	/**
	 * jpg格式 
	 */
	public static final String JPG = "jpg";
	/**
	 * png格式
	 */
	public static final String PNG = "png";
	/**
	 * gif格式
	 */
	public static final String GIF = "gif";
	/**
	 * bmp格式
	 */
	public static final String BMP = "bmp";
	
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
	 * 裁剪原图，生成新的图片
	 * @param srcPath 原图地址
	 * @param destPath 裁剪后的图片地址
	 * @param x 裁剪开始x坐标
	 * @param y 裁剪开始y坐标
	 * @param width 裁剪宽度
	 * @param height 裁剪高度
	 * @param formatName 图片类型
	 */
	public static boolean cutImage(String srcPath, String destPath, int x, int y, int width, int height, String formatName) {
		boolean cutSuccess = false;
		Iterator<ImageReader> ite = ImageIO.getImageReadersByFormatName(formatName);
		if (ite.hasNext()) {
			ImageReader reader = ite.next();
			InputStream is = null;
			try {
				is = new FileInputStream(srcPath);
				ImageInputStream iis = ImageIO.createImageInputStream(is);
				reader.setInput(iis);
				ImageReadParam defaultReadParam = reader.getDefaultReadParam();
				Rectangle rec = new Rectangle(x, y, width, height);
				defaultReadParam.setSourceRegion(rec);
				BufferedImage bi = reader.read(0, defaultReadParam);
				cutSuccess =  ImageIO.write(bi, formatName, new File(destPath));
			} catch (IOException e) {
				System.out.println("cut image["+srcPath+"] failed");
				e.printStackTrace();
			} finally {
				if (is != null) {
					try {
						is.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		} else {
			throw new RuntimeException("不支持的格式["+ formatName +"]");
		}
		return cutSuccess;
	}
	
	/**
	 * 判断文件后缀是否为图片文件格式,bmp|gif|jpg|jpeg|png 返回true
	 * @param imageFileSuffix 图片文件后缀名
	 * @return
	 */
	public static boolean isImageBySuffix(String imageFileSuffix) {
		if (StringUtils.isNotEmpty(imageFileSuffix)) {
			//[JPG, jpg, bmp, BMP, gif, GIF, WBMP, png, PNG, wbmp, jpeg, JPEG]
			String[] formatNames = ImageIO.getReaderFormatNames();
			if (ArrayUtils.isNotEmpty(formatNames)) {
				for (String formatName : formatNames) {
					if (imageFileSuffix.toLowerCase().equals(formatName)) {
						return true;
					}
				}
			}
		}
		return false;
	}
	
	/**
	 * 判断文件是否为图片文件格式, bmp|gif|jpg|jpeg|png 后缀的图片文件返回true
	 * @param imageName 图片文件名
	 * @return
	 */
	public static boolean isImageByFileName(String imageName) {
		if (StringUtils.isNotEmpty(imageName)) {
			String[] imageNames = imageName.split(FILE_CONNECTOR_POINT);
			return isImageBySuffix(imageNames[imageNames.length - 1]);
		}
		return false;
	}
	
	/**
	 * 判断文件是否为合法图片
	 * @param srcPath 图片文件绝对路径
	 * @param checkImageName 是否校验图片文件名
	 * @return
	 */
	public static boolean isImage(String srcPath, boolean checkImageName) {
		if (checkImageName) {
			return isImageByFileName(srcPath);
		} else {
			if (StringUtils.isNotEmpty(srcPath)) {
				File imageFile = new File(srcPath);
				if (imageFile.isFile() && imageFile.length() > 0) {
					return isImage(imageFile);
				}
			}
		}
		return false;
	}
	
	/**
	 * 判断文件流是否为合法图片
	 * @param file 图片文件
	 * @return
	 */
	public static boolean isImage(File file) {
		return isImage((Object)file);
	}
	
	/**
	 * 判断文件流是否为合法图片
	 * @param srcInputStream 图片文件的流
	 * @return
	 */
	public static boolean isImage(InputStream srcInputStream) {
		return isImage((Object)srcInputStream);
	}
	
	/**
	 * 判断文件流是否为合法图片
	 * @param srcInputStream 图片文件的流
	 * @return
	 */
	public static boolean isImage(URL url) {
		return isImage((Object)url);
	}
	
	/**
	 * 图片文件读取
	 * @param obj (URL|InputStream|File)
	 * @return
	 */
	private static boolean isImage(Object obj) {
		Image image = null;
		if (obj != null) {
			try {
				if (obj instanceof URL) {
					image = ImageIO.read((URL)obj);
				} else if (obj instanceof InputStream) {
					image = ImageIO.read((InputStream)obj);
				} else if (obj instanceof File) {
					image = ImageIO.read((File)obj);
				} else {
					throw new IllegalArgumentException("不支持这种类型["+obj.getClass().getCanonicalName()+"]");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			if (image != null && image.getWidth(null) > 0 && image.getHeight(null) > 0) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 获取图片类型
	 * @param is 图片文件流
	 * @return 图片类型:jpg|png|gif|bmp
	 */
	public static String getImageType(InputStream is) {
		String type = null;
		if (is != null) {
			byte[] b = new byte[4];
			try {
				is.read(b, 0, b.length);
			} catch (IOException e) {
				e.printStackTrace();
			}
			String hexStr = HexConverter.byteArrayToHexString(b, true);//图片文件流前4个字节的头信息（子文字母）
			if (hexStr != null) {
				if (hexStr.startsWith(JPG_HEX)) {
					type = JPG;
				} else if (hexStr.startsWith(PNG_HEX)) {
					type = PNG;
				} else if (hexStr.startsWith(GIF_HEX)) {
					type = GIF;
				} else if (hexStr.startsWith(BMP_HEX)) {
					type = BMP;
				}
			}
		}
		return type;
	}
	
	
	
	public static boolean compressImage (String srcPath, String destPath, float quality) {
		return false;
	}
	
	public static boolean resizeImage (String srcPath, String destPath, int newWith, int newHeight) {
		return false;
	}
	
	public static boolean zoomImage (String srcPath, String destPath, int newWith, int newHeight) {
		return false;
	}
	
	/**
	 * 网络图片下载
	 * @param url 图片url
	 * @return 下载是否成功
	 */
	public static boolean downloadImage(String imageUrl, String formatName, File localFile) {
		boolean isSuccess = false;
		URL url = null;
		try {
			url = new URL(imageUrl);
			isSuccess = ImageIO.write(ImageIO.read(url), formatName, localFile);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	
}
