package reflection.TestReflect;

class S {
}

public class IsInstance {
    public static void main(String args[]) {
        try {
            Class cls = Class.forName("S");
            boolean b1 = cls.isInstance(new Integer(37));
            System.out.println(b1);
            boolean b2 = cls.isInstance(new S());
            System.out.println(b2);
        }
        catch (Throwable e) {
            System.err.println(e);
        }
    }
}
