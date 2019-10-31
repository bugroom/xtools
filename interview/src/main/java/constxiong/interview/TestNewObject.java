package constxiong.interview;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 测试创建对象
 * @author ConstXiong
 * @date 2019-10-31 11:53:31
 */
public class TestNewObject implements Cloneable, Serializable{
	
	private static final long serialVersionUID = 1L;

	public TestNewObject() {
		System.out.println("Constructor init");
	}
	
	public static void main(String[] args) throws Exception {
		TestNewObject o1 = new TestNewObject();
		TestNewObject o2 = TestNewObject.class.newInstance();
		TestNewObject o3 = TestNewObject.class.getConstructor().newInstance();
		
		TestNewObject o4 = (TestNewObject)o1.clone();
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(o1);
		ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()));
		TestNewObject o5 = (TestNewObject)ois.readObject();
	}

}
