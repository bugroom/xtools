package constxiong.interview;

import java.io.Serializable;

public class TestSerializable implements Serializable {

	private static final long serialVersionUID = 5887391604554532906L;
	
	private int id;
	
	private String name;

	public TestSerializable(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	//https://www.cnblogs.com/yangchunze/p/6728086.html
	public static void main(String[] args) {
		//序列化
//		Object
		
		//反序列化
	}
	

}
