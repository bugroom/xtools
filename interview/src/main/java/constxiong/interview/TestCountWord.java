package constxiong.interview;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 统计某字符串在文件中出现的次数
 * 
 * @author ConstXiong
 */
public class TestCountWord {

	public static void main(String[] args) {
		String filePath = "/Users/handsome/Desktop/a.txt";
		String word = "ConstXiong";
		System.out.println(countWordAppearTimes(filePath, word));
	}
	
	/**
	 * 统计每行的出现单词的出现次数之后
	 * @param filePath
	 * @param word
	 * @return
	 */
	public static int countWordAppearTimes(String filePath, String word) {
		int times = 0;
		FileReader fr = null;
		BufferedReader br = null;
		try {
			fr = new FileReader(filePath);
			br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {//读文件每行字符串
				//按照单词正则查找出现次数
				Pattern p = Pattern.compile(word);
				Matcher m = p.matcher(line);
				while (m.find()) {
					times++;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return times;
	}

}
