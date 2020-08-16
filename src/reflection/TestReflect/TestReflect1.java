package reflection.TestReflect;


public class TestReflect1 {
    public static void main(String[] args) throws SecurityException, NoSuchMethodException {
        // TODO Auto-generated method stub
        String str = "abc";

        System.out.println(String.class.getConstructor(StringBuffer.class));
    }
}
