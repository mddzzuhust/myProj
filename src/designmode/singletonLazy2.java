package designmode;

public class singletonLazy2 {
    private static singletonLazy2 instance = null;
    private singletonLazy2(){}
    static singletonLazy2 getInstance(){
        if(instance==null)
            instance = new singletonLazy2();
        return instance;
    }
}
