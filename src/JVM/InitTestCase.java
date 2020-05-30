package JVM;

class Parent{
    static int a=1;
    static {
        System.out.println("Parent's static block");
    }
}

class Child extends Parent{
    static int b=2;
    static {
        System.out.println("Child's static block");
    }
}

public class InitTestCase {
    static {
        System.out.println("InitTestCase's static block");
    }

    public static void main(String[] args) {
//System.out.println(Child.b);
        System.out.println(Child.a);
    }
}