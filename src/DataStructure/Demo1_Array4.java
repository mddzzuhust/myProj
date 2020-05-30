package DataStructure;

public class Demo1_Array4 {
    public static void main(String[] args) {
        String[] array = new String[5];
        array[0] = "hello";
        array[1] = "world";
        array[4] = "Mufasa";
        array = drop(array, 3);
        for (String str : array) {
            System.out.println(str + " ");
        }
    }

    public static String[] drop(Object[] oldArray, int index) {
        int size = java.lang.reflect.Array.getLength(oldArray);
        if (index < 0 || index > size) {
            throw new RuntimeException("删除索引范围有误");
        } else {
            Class elementType = oldArray.getClass().getComponentType();
            Object newArray = java.lang.reflect.Array.newInstance(elementType, size - 1);
            String[] newStringArray = (String[]) newArray;
            int counter = 0;
            for (int i = 0; i < oldArray.length; i++) {
                if(i!=index){
                    newStringArray[counter] = (String)oldArray[i];
                    counter++;
                }else {
                    continue;
                }
            }
            return newStringArray;
        }
    }
}