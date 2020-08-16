package reflection.TestReflect;

import java.lang.reflect.Field;

public class TestReflect3 {
    public static void main(String[] args) throws SecurityException, NoSuchMethodException, NoSuchFieldException, IllegalArgumentException, Exception {
        ReflectPointer rp1 = new ReflectPointer(3,4);
        changeBtoA(rp1);
        System.out.println(rp1);

    }

    private static void changeBtoA(Object obj) throws RuntimeException, Exception {
        Field[] fields = obj.getClass().getFields();

        for(Field field : fields) {
            //if(field.getType().equals(String.class))
            //由于字节码只有一份,用equals语义不准确
            if(field.getType()==String.class) {
                String oldValue = (String)field.get(obj);
                String newValue = oldValue.replace('b', 'a');
                field.set(obj,newValue);
            }
        }
    }
}