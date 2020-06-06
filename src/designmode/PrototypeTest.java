package designmode;

public class PrototypeTest {
    public static void main(String[] args) throws CloneNotSupportedException{
        Realizetype obj1=new Realizetype();
        Realizetype obj2=(Realizetype)obj1.clone();
        System.out.println("obj1==obj2?"+(obj1==obj2));
    }
}
class Realizetype implements Cloneable{
    Realizetype(){
        System.out.println("create success");
    }
    public Object clone() throws CloneNotSupportedException{
        System.out.println("copy success");
        return (Realizetype)super.clone();
    }
}
