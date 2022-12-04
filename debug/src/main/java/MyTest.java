public class MyTest {
    Object obj1 = new Object();
    Object obj2 = new Object();

    public void fun1(){
        synchronized (obj1){
            fun2();
        }
    }

    public void fun2(){
        synchronized (obj2){
            while (true){
                System.out.print("");
            }
        }
    }

    public static void main(String[] args) {
        MyTest aa = new MyTest();
        aa.fun1();
    }
}
