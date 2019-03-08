package constxiong.xtools.convert;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

/**
 * 十六进制转换测试
 * @author ConstXiong
 * @date 2019-03-08 14:52:42
 */
public class HexConverterTest {

	private static final String TEST_HEX_STR = "2A0F";
	private static final byte[] TEST_HEX_BYTES = new byte[]{42, 15};
	
	/**
	 * 测试 字节数组 转 十六进制字符串
	 */
	@Test
	public void testByteArrayToHexString() {
		boolean toUpper = true;
		Assert.assertEquals(TEST_HEX_STR, HexConverter.byteArrayToHexString(TEST_HEX_BYTES, toUpper));
	}
	
	/**
	 * 测试 十六进制字符串，转单个字节
	 */
	@Test
	public void testHexStringToByte() {
		String hexStr = "0B";
		byte b = 11;
		Assert.assertTrue(b == HexConverter.hexStringToByte(hexStr));
		
		hexStr = "A0B";
		Assert.assertTrue(b == HexConverter.hexStringToByte(hexStr));//只取最后两个字符"0B"
	}
	
	/**
	 * 测试 十六进制字符串转字节数组
	 */
	@Test
	public void testHexStringToByteArray() {
		Assert.assertTrue(Arrays.equals(TEST_HEX_BYTES, 
				HexConverter.hexStringToByteArray(TEST_HEX_STR)));
	}
	
	/**
	 * 测试 判断是否为十六进制字符
	 */
	@Test
	public void testIsHexChar() {
		char c = 'a';
		Assert.assertTrue(HexConverter.isHexChar(c));
		
		c = 'k';
		Assert.assertFalse(HexConverter.isHexChar(c));
	}
	
	/**
	 * 测试 判断是否为十六进制字符串
	 */
	@Test
	public void testIsHexStr() {
		String hexStr = "0Abd";
		Assert.assertTrue(HexConverter.isHexStr(hexStr));
		
		hexStr = "10Abd";
		Assert.assertFalse(HexConverter.isHexStr(hexStr));
		
		hexStr = "k10Abd";
		Assert.assertFalse(HexConverter.isHexStr(hexStr));
	}
}
