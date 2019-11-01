package constxiong.interview;

import java.io.UnsupportedEncodingException;

/**
 * 字符串字符集转换
 * @author ConstXiong
 * @date 2019-11-01 10:57:34
 */
public class TestCharsetConvert {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "爱编程";
		String strIso = new String(str.getBytes("GB2312"), "ISO-8859-1");
		System.out.println(strIso);
	}
}
