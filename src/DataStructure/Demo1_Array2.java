package DataStructure;

public class Demo1_Array2 {
    public static void main(String[] args) {
        String[] array = {"hello","world",null,null,"Mufasa"};
        array = (String[])resizeArray(array,10);
        for (String str:array){
            System.out.println(str+" ");
        }
    }

    private static Object resizeArray(Object oldArray, int newSize){
        int oldSize = java.lang.reflect.Array.getLength(oldArray);
        Class elementType = oldArray.getClass().getComponentType();
        Object newArray = java.lang.reflect.Array.newInstance(elementType,newSize);
        int preserveLength = Math.min(oldSize,newSize);
        if(preserveLength > 0)
            System.arraycopy(oldArray,0,newArray,0,preserveLength);

        return newArray;
    }
}