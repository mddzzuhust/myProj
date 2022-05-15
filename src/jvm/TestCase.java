package jvm;

import java.util.Random;

class StaticClassTest{
    public static int staticValue = 2/1;

    static {
        System.out.println("StaticClassTest's static block!");
    }
}

class StaticFinalTest1{
    public final static int staticValue = 2/1;

    static {
        System.out.println("StaticFinalTest1's static block！");
    }
}

class StaticFinalTest2{
    public final static int staticValue = new Random().nextInt(10);

    static {
        System.out.println("StaticFinalTest2's static block!");
    }
}

public class TestCase {
    public static void main(String[] args) {
//============================================================
// System.out.println(StaticClassTest.staticValue);
//
// System.out.println(StaticFinalTest1.staticValue);
//
// System.out.println(StaticFinalTest2.staticValue);

//============================================================
// System.out.println("Xmx=" + Runtime.getRuntime().maxMemory() / 1024.0 / 1024 + "M"); //系统的最大空间
//
// System.out.println("free mem=" + Runtime.getRuntime().freeMemory() / 1024.0 / 1024 + "M"); //系统的空闲空间
//
// System.out.println("total mem=" + Runtime.getRuntime().totalMemory() / 1024.0 / 1024 + "M"); //当前可用的总空间
//
// //============================================================
// byte[] b = new byte[1 * 1024 * 1024];
// System.out.println("分配了1M空间给数组");
//
// System.out.println("Xmx=" + Runtime.getRuntime().maxMemory() / 1024.0 / 1024 + "M"); //系统的最大空间
//
// System.out.println("free mem=" + Runtime.getRuntime().freeMemory() / 1024.0 / 1024 + "M"); //系统的空闲空间
//
// System.out.println("total mem=" + Runtime.getRuntime().totalMemory() / 1024.0 / 1024 + "M");

//============================================================
// byte[] b = new byte[10 * 1024 * 1024];
// System.out.println("分配了10M空间给数组");
//
// System.out.println("Xmx=" + Runtime.getRuntime().maxMemory() / 1024.0 / 1024 + "M"); //系统的最大空间
//
// System.out.println("free mem=" + Runtime.getRuntime().freeMemory() / 1024.0 / 1024 + "M"); //系统的空闲空间
//
// System.out.println("total mem=" + Runtime.getRuntime().totalMemory() / 1024.0 / 1024 + "M"); //当前可用的总空间

// //============================================================
        System.gc();

        System.out.println("Xmx=" + Runtime.getRuntime().maxMemory() / 1024.0 / 1024 + "M"); //系统的最大空间

        System.out.println("free mem=" + Runtime.getRuntime().freeMemory() / 1024.0 / 1024 + "M"); //系统的空闲空间

        System.out.println("total mem=" + Runtime.getRuntime().totalMemory() / 1024.0 / 1024 + "M"); //当前可用的总空间
    }
}