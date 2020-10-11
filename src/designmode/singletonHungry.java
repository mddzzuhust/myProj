package designmode;

public class singletonHungry {
    private static singletonHungry instance = new singletonHungry();

    private singletonHungry(){}
    static singletonHungry getInstance(){
        return instance;
    }
}
