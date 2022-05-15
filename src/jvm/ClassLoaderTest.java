package jvm;
class Singleton{
    private static int counter1;

    private static int counter2 = 0;
    private static Singleton singleton = new Singleton();



    public Singleton(){
        counter1++;
        counter2++;
    }

    public static int getCounter1(){
        return counter1;
    }

    public static int getCounter2(){
        return counter2;
    }

    public static Singleton getInstance(){
        return singleton;
    }
}

public class ClassLoaderTest {

    @SuppressWarnings("static-access")
    public static void main(String[] args) throws ClassNotFoundException{

        System.out.println(Class.forName("java.lang.String").getClassLoader());
        Singleton singleton = Singleton.getInstance();
        System.out.println("counter1:" + singleton.getCounter1());
        System.out.println("counter2:" + singleton.getCounter2());
    }
}