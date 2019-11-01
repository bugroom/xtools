package constxiong.interview;

public class AA extends A{
    public AA(){
        System.out.print("AA");
    }

    public static void main(String[] args) {
        AA aa = new AA();
    }
}

class A {
    public A(){
        System.out.print("A");
    }
}