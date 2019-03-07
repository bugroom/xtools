package constxiong.xtools.picture;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import org.junit.Test;

import constxiong.xtools.path.PathUtil;

/**
 * 图片工具测试类
 * @author ConstXiong
 * @date 2019-03-04 16:28:11
 */
public class ImageUtilTest {
	
	private static final String IMAGE_PATH = PathUtil.getProjectPath() + File.separator + "images" + File.separator;

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
}
