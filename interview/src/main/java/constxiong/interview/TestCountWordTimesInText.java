package constxiong.interview;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 统计一段长字符串中某字符串的出现次数
 * @author ConstXiong
 * @date 2019-11-13 11:01:22
 */
public class TestCountWordTimesInText {

	public static void main(String[] args) {
		String text = "统计一CX段长CX字符串中某字符串的出C现X次cx数";
		String word = "CX";
		System.out.println(countWordTimesByCutString(text, word));
		System.out.println(countWordTimesByReplace(text, word));
		System.out.println(countWordTimesByRegex(text, word));//正则匹配，需要注意正则表达式的正确使用，可能会达到非自己想要的效果
	}

	/**
	 * 截取字符串统计字符串出现次数
	 * @param text
	 * @param word
	 * @return
	 */
	public static int countWordTimesByCutString(String text, String word) {
		int times = 0;
		if (!isEmpty(text) && !isEmpty(word)) {
			String subText = text;
			int index = -1;
			int wordLength = word.length();
			while (subText.length() >= wordLength && (index = subText.indexOf(word)) > -1) {
				subText = subText.substring(index + wordLength);
				times++;
			}
		}
		return times;
	}
	
	/**
	 * 通过替换字符串，统计字符串出现次数
	 * @param text
	 * @param word
	 * @return
	 */
	public static int countWordTimesByReplace(String text, String word) {
		int times = 0;
		if (!isEmpty(text) && !isEmpty(word)) {
			times = (text.length() - text.replace(word, "").length()) / word.length();
		}
		return times;
	}
	
	/**
	 * 通过正则表达式，统计字符串出现次数.注：
	 * @param text
	 * @param word
	 * @return
	 */
	public static int countWordTimesByRegex(String text, String word) {
		int times = 0;
		if (!isEmpty(text) && !isEmpty(word)) {
			Pattern p = Pattern.compile(word);
			Matcher m = p.matcher(text);
			while (m.find()) {
				times++;
			}
		}
		return times;
	}
	
	/**
	 * 字符串是否为空
	 * @param str
	 * @return
	 */
	private static boolean isEmpty(String str) {
		return str == null || str.length() == 0;
	}
	
}
