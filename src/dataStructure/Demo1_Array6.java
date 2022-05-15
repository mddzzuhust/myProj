package dataStructure;

import java.util.ArrayList;
import java.util.List;

public class Demo1_Array6 {
    public static void main(String[] args) {
        List<String> array = new ArrayList<>();
        array.add("hello");
        array.add("world");
        array.add("扩容！");
        System.out.println(array.size());
        for(String str:array){
            System.out.println(str + " ");
        }
    }
}