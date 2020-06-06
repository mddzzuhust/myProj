package designmode;

public class SingletonLazy {
    public static void main(String[] args){
        President zt1=President.getInstance();
        zt1.getName();
        President zt2=President.getInstance();
        zt2.getName();
        if(zt1==zt2){
            System.out.println("They are the same");
        }else {
            System.out.println("They are not the same");
        }
    }
}
class President{
    private static volatile President instance=null;
    private President(){
        System.out.println("a president");
    }
    public static synchronized President getInstance(){
        if(instance==null){
            instance=new President();
        }else {
            System.out.println(" not a president");
        }
        return instance;
    }
    public void getName(){
        System.out.println("I am trump");
    }
}
