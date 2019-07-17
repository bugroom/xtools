package constxiong.interview.assemble;


/**
 * 人
 * @author ConstXiong
 * @date 2019-07-17 09:54:56
 */
public class Person {

	private FishingRod fr;
	
	public Person(FishingRod fr) {
		this.fr = fr;
	}
	
	/**
	 * 钓鱼
	 */
	public void fish() {
		fr.used();
	}
	
}
