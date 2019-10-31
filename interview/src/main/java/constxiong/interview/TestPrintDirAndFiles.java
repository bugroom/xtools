package constxiong.interview;

import java.io.File;

/**
 * 使用递归输出某个目录下所有子目录和文件
 * @author ConstXiong
 * @date 2019-10-23 15:16:32
 */
public class TestPrintDirAndFiles {

	public static void main(String[] args) {
		print(new File("E:/"));
	}
	
	private static void print(File file) {
		System.out.println(file.getAbsolutePath());
		if (file.isDirectory()) {
			File[] files = file.listFiles();
			for (File f : files) {
				print(f);
			}
		}
		
	}
}
