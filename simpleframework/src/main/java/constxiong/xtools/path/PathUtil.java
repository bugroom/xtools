package constxiong.xtools.path;

import java.io.File;
import java.io.IOException;

/**
 * 路径工具类
 * @author ConstXiong
 * @date 2019-03-04 16:34:01
 */
public class PathUtil {

	/**
	 * 获取项目路径
	 * @return
	 */
	public static String getProjectPath() {
		return System.getProperty("user.dir");
	}
	
	/**
	 * 获取项目路径
	 * @return
	 * @throws IOException 
	 */
	public static String getProjectPath2() throws IOException {
		File directory = new File("");// 参数为空
        return directory.getCanonicalPath();
	}
	
}
