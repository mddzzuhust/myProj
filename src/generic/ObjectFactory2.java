package generic;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ObjectFactory2 {
    public static <T> T getInstance(Class<T> cls){
        try {
            return cls.newInstance();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args){
        Date d = ObjectFactory2.getInstance(Date.class);
        JFrame f = ObjectFactory2.getInstance(JFrame.class);

//不能创建一个确切的泛型类型的数组
//List<String>[] ls = new ArrayList<String>[10];
        List<?>[] ls = new ArrayList<?>[10];
        List<String>[] ls1 = new ArrayList[10];


// 这种情况下，由于JVM泛型的擦除机制，在运行时JVM是不知道泛型信息的，所以可以给oa[1]赋上一个ArrayList而不会出现异常，
//
// 但是在取出数据的时候却要做一次类型转换，所以就会出现ClassCastException，如果可以进行泛型数组的声明，
//
// 上面说的这种情况在编译期将不会出现任何的警告和错误，只有在运行时才会出错。
//
// 而对泛型数组的声明进行限制，对于这样的情况，可以在编译期提示代码有类型安全问题，比没有任何提示要强很多。
// List<String>[] lsa = new List<String>[10]; // Not really allowed.
// Object o = lsa;
// Object[] oa = (Object[]) o;
// List<Integer> li = new ArrayList<Integer>();
// li.add(new Integer(3));
// oa[1] = li; // Unsound, but passes run time store check
// String s = lsa[1].get(0); // Run-time error: ClassCastException.

        List<?>[] lsa = new List<?>[10];
        Object o = lsa;
        Object[] oa = (Object[]) o;
        List<Integer> li = new ArrayList<Integer>();
        li.add(new Integer(3));
        oa[1] = li;
        Integer i = (Integer)lsa[1].get(0);
    }
}