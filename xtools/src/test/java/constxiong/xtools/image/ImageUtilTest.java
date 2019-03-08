package constxiong.xtools.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;

import constxiong.xtools.image.ImageUtil;
import constxiong.xtools.path.PathUtil;

/**
 * 图片工具测试类
 * @author ConstXiong
 * @date 2019-03-04 16:28:11
 */
public class ImageUtilTest {
	
	private static final String IMAGE_PATH = PathUtil.getProjectPath() + File.separator + "images" + File.separator;
	
	private static final String FILE_PATH = PathUtil.getProjectPath() + File.separator + "files" + File.separator;

	/**
	 * 测试图片绘制
	 * @throws IOException
	 */
	@Test
	public void testDrawImage() throws IOException {
		BufferedImage bufferedImage = new BufferedImage(200, 200, BufferedImage.TYPE_INT_BGR);
		File dir = new File(IMAGE_PATH); 
		if (!dir.exists()) {
			dir.mkdirs();
		}
		ImageUtil.drawSimpleImage(bufferedImage, "jpg", 
				new File(IMAGE_PATH + "simple.jpg"));
	}
	
	/**
	 * 测试图片剪切
	 */
	@Test
	public void testCutImage() {
		String imageName = "simple.jpg";
		String cutImageName = "simple_cut.jpg";
		String srcPath = IMAGE_PATH + imageName;
		String destPath  = IMAGE_PATH + cutImageName;
		int x = 10; 
		int y = 40;
		int width = 180;
		int height = 120;
		String formatName = "jpg";
		ImageUtil.cutImage(srcPath, destPath, x, y, width, height, formatName);
	}
	
	/**
	 * 测试图片后缀名
	 */
	@Test
	public void testIsImageBySuffix() {
		String imageSuffix = "jpg";
		Assert.assertTrue(ImageUtil.isImageBySuffix(imageSuffix));
		
		imageSuffix = "jpG";
		Assert.assertTrue(ImageUtil.isImageBySuffix(imageSuffix));
		
		imageSuffix = "png";
		Assert.assertTrue(ImageUtil.isImageBySuffix(imageSuffix));
		
		imageSuffix = "bmp";
		Assert.assertTrue(ImageUtil.isImageBySuffix(imageSuffix));
		
		imageSuffix = "gif";
		Assert.assertTrue(ImageUtil.isImageBySuffix(imageSuffix));
		
		imageSuffix = "JPEG";
		Assert.assertTrue(ImageUtil.isImageBySuffix(imageSuffix));
		
		imageSuffix = "wbmp";
		Assert.assertTrue(ImageUtil.isImageBySuffix(imageSuffix));
		
		imageSuffix = "xxx";
		Assert.assertFalse(ImageUtil.isImageBySuffix(imageSuffix));
	}
	
	/**
	 * 测试文件名是否为图片格式
	 */
	@Test
	public void testIsImageByFileName() {
		String imageName = "simple.jpg";
		Assert.assertTrue(ImageUtil.isImageByFileName(imageName));
		
		String textName = "text.txt";
		Assert.assertFalse(ImageUtil.isImageByFileName(textName));
	}
	
	/**
	 * 测试文件是否为图片
	 * @throws FileNotFoundException 
	 * @throws MalformedURLException 
	 */
	@SuppressWarnings("resource")
	@Test
	public void testIsImage() throws FileNotFoundException, MalformedURLException {
		String imageName = "simple.jpg";
		String srcPath = IMAGE_PATH + imageName;
		Assert.assertTrue(ImageUtil.isImage(srcPath, true));
		
		Assert.assertTrue(ImageUtil.isImage(new File(srcPath)));
		
		Assert.assertTrue(ImageUtil.isImage(new FileInputStream(srcPath)));
		
		String baiduLogoUrl = "https://www.baidu.com/img/bd_logo1.png";//百度logo图片
		Assert.assertTrue(ImageUtil.isImage(new URL(baiduLogoUrl)));
		
		String textName = "text.txt";
		String txtPath = FILE_PATH + textName;
		Assert.assertFalse(ImageUtil.isImage(txtPath, true));
	}
	
	/**
	 * 测试获取图片类型
	 * @throws FileNotFoundException 
	 */
	@Test
	public void testGetImageType() throws FileNotFoundException {
		String imageName = "simple.jpg";
		String srcPath = IMAGE_PATH + imageName;
		Assert.assertEquals(ImageUtil.JPG, ImageUtil.getImageType(new FileInputStream(srcPath)));
		
		imageName = "bd_logo1.png";
		srcPath = IMAGE_PATH + imageName;
		Assert.assertEquals(ImageUtil.PNG, ImageUtil.getImageType(new FileInputStream(srcPath)));
	}
	
	/**
	 * 测试图片下载
	 */
	@Test
	public void testDownloadImage() {
		String baiduLogoUrl = "https://www.baidu.com/img/bd_logo1.png";
		File localFile = new File(IMAGE_PATH + "bd_logo1.png");
		Assert.assertTrue(ImageUtil.downloadImage(baiduLogoUrl, ImageUtil.PNG, localFile));
	}
	
}
