package dataStructure;

public class Demo1_Array {
    public static void main(String[] args) {
        String[] array = new String[5];
        array[0] = "hello";
        array[1] = "world";
        array[4] = "Mufasa";

        for (String str:array){
            System.out.println(str+" ");
        }
    }
}