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
public class PictureUtilTest {

	@Test
	public void testDrawImage() throws IOException {
		BufferedImage bufferedImage = new BufferedImage(200, 200, BufferedImage.TYPE_INT_BGR);
		String imagePath = PathUtil.getProjectPath() + File.separator + "images" + File.separator;
		File dir = new File(imagePath); 
		if (!dir.exists()) {
			dir.mkdirs();
		}
		PictureUtil.drawImage(bufferedImage, "jpg", 
				new File(imagePath + "simple.jpg"));
	}
}
