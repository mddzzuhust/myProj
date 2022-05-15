package jvm;

import java.util.ArrayList;
import java.util.List;

public class JVM {
    public static void main(String[] args) throws Exception{
        int[] arrays = new int[1024*1024];

        for (int i = 0; i < arrays.length; i++) {
            System.out.println(i);
        }

        List<JVM> list = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            Thread.sleep(1000);
            list.add(new JVM());
            System.out.println(i);
        }
    }
}