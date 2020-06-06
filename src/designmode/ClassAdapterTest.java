package designmode;

interface Target{
    public void request();
}

class Adaptee{
    public void specificRequest(){
        System.out.println("beidiaoyong");
    }
}

class ClassAdapter extends Adaptee implements Target{
    public void request(){
        specificRequest();
    }
}
public class ClassAdapterTest {
    public static void main(String[] args){
        System.out.println("ceshi");
        Target target=new ClassAdapter();
        target.request();
    }
}
