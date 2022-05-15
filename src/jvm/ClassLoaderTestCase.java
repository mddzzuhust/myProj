package jvm;

class Test{
    static {
        System.out.println("Test's static block");
    }
}

public class ClassLoaderTestCase {
    public static void main(String[] args) throws ClassNotFoundException{
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        System.out.println("ClassLoader:"+classLoader);

        Class<?> testClass = classLoader.loadClass("jvm.ClassLoaderTestCase");

        System.out.println("using class.forName('JVM.Test')");

        testClass = Class.forName("jvm.Test");
    }
}