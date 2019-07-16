package constxiong.interview.inject;

//import javax.annotation.Resource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Component;

//@Component //注册所有bean
//@Controller //注册控制层的bean
//@Service //注册服务层的bean
//@Repository //注册dao层的bean
public class Person {

//	@Autowired
//	@Qualifier("bowl")
//	@Resource(name="bowl")
	private Bowl bowl;
	
	public Person() {
		
	}
	
//	public Person(Bowl bowl) {
//		this.bowl = bowl;
//	}

	public void eat() {
		bowl.putRice();
		System.out.println("开始吃饭...");
	}

	public void setBowl(Bowl bowl) {
		this.bowl = bowl;
	}
	
}
