package constxiong.interview;

/**
 * 测试克隆
 * @author ConstXiong
 * @date 2019-06-18 11:21:21
 */
public class TestClone {

	public static void main(String[] args) throws CloneNotSupportedException {
		Person p1 = new Person(1, "ConstXiong", new Food("米饭"));//创建Person 对象 p1
		Person p2 = (Person)p1.clone();//克隆p1
		p2.setName("其不答");//修改p2的name属性
		p2.getFood().setName("面条");//修改p2的自定义引用类型 food 属性
		System.out.println(p1);//修改p2的自定义引用类型 food 属性被改变，p1的自定义引用类型 food 属性也随之改变，说明p2的food属性，只拷贝了引用，没有拷贝food对象
		System.out.println(p2);
	}
	
}

class Person implements Cloneable {
	
	private int pid;
	
	private String name;
	
	private Food food;
	
	public Person(int pid, String name, Food food) {
		this.pid = pid;
		this.name = name;
		this.food = food;
		System.out.println("Person constructor call");
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return "Person [pid:"+pid+", name:"+name+", food:"+food.getName()+"]";
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}
	
}

class Food {
	
	private String name;
	
	public Food(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
