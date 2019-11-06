package constxiong.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * 一个不包含相同元素的整数集合，返回所有可能的不重复子集集合
 * 
 * @author ConstXiong
 * @date 2019-11-06 14:09:49
 */
public class TestGetAllSubArray {
	
	public static void main(String[] args) {
		int[] arr = {1, 2, 3};
		System.out.println(getAllSubList(arr));
	}
	

	public static List< List< Integer>> getAllSubList(int[] arr) {
		List< List< Integer>> res = new ArrayList< List< Integer>>();
		if (arr.length == 0 || arr == null) {
			return res;
		}
//		Arrays.sort(arr);//排序 
		
		List< Integer> item = new ArrayList< Integer>();
		subList(arr, 0, item, res);
		
//		res.add(new ArrayList< Integer>());// 如果需要，加上空集
		
		return res;
	}

	/**
	 * 递归获取子集合
	 * 从数组第一位数开始，获取该数与后面数组合的所有可能。第一位组合完到第二位...直到最后一位
	 * @param arr
	 * @param start
	 * @param item
	 * @param res
	 */
	public static void subList(int[] arr, int start, List< Integer> item, List< List< Integer>> res) {
		for (int i = start; i < arr.length; i++) {
			item.add(arr[i]);
			res.add(new ArrayList< Integer>(item));
			subList(arr, i + 1, item, res);
			item.remove(item.size() - 1);
		}
	}

}
