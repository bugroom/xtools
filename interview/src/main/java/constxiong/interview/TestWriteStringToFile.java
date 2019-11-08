package constxiong.interview;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 测试写入字符串到文件
 * @author ConstXiong
 * @date 2019-11-08 12:05:49
 */
public class TestWriteStringToFile {

	public static void main(String[] args) {
		String cx = "ConstXiong";
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream("E:/a.txt");
			fos.write(cx.getBytes());//注意字符串编码
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
}
