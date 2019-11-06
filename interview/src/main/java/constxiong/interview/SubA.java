package constxiong.interview;

public class SubA extends ParentA{
    public SubA(){
        System.out.print("AA");
    }

    public static void main(String[] args) {
    	SubA aa = new SubA();
    }
}

class ParentA {
    public ParentA(){
        System.out.print("A");
    }
}