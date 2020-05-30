package reflection;

import java.lang.reflect.Method;

class A {
    public void foo(String name) {
        System.out.println("Hello, " + name);
    }
}

public class TestClassLoad {
    public static void main(String[] args) throws Exception {
        Class<?> clz = Class.forName("reflection.A");
        Object o = clz.newInstance();
        Method m = clz.getMethod("foo", String.class);
        for (int i = 0; i < 16; i++) {
            m.invoke(o, Integer.toString(i));
            System.out.println(o.getClass());
        }
    }
}