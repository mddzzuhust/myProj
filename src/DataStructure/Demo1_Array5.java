package DataStructure;

public class Demo1_Array5 {
    public static void main(String[] args) {
        String[] array = new String[5];
        array[0] = "hello";
        array[1] = "world";
        array[4] = "Mufasa";
        array = add(array,3,"添加字符串");
        for(String str:array){
            System.out.println(str + " ");
        }
    }

    public static String[] add(Object[] oldArray,int index,String str){
        int size = java.lang.reflect.Array.getLength(oldArray);
        if(index<0||index>size){
            throw new RuntimeException("添加索引范围有误");
        }else {
            Class elementType = oldArray.getClass().getComponentType();
            Object newArray = java.lang.reflect.Array.newInstance(elementType,size+1);
            String[] newStringArray = (String[])newArray;
            int counter = 0;
            for (int i = 0; i < oldArray.length; i++) {
                if(i!=index){
                    newStringArray[counter] = (String)oldArray[i];
                    counter++;
                }else {
                    newStringArray[counter] = (String)oldArray[i];
                    counter++;
                    newStringArray[counter] = str;
                    counter++;
                }
            }
            return newStringArray;
        }
    }
}