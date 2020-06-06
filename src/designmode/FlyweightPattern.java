package designmode;

import java.util.HashMap;

public class FlyweightPattern {
    public static void main(String[] args){
    FlyweightFactory factory=new FlyweightFactory();
    Flyweight f01=factory.getFlyweight("a");
    Flyweight f02=factory.getFlyweight("a");
    Flyweight f03=factory.getFlyweight("a");
    Flyweight f11=factory.getFlyweight("b");
    Flyweight f12=factory.getFlyweight("b");
    f01.operation(new UnsharedConcreteFlyweight("diyicidiaoyonga."));
    f02.operation(new UnsharedConcreteFlyweight("第2次调用a。"));
    f03.operation(new UnsharedConcreteFlyweight("第3次调用a。"));
    f11.operation(new UnsharedConcreteFlyweight("第1次调用b。"));
    f12.operation(new UnsharedConcreteFlyweight("第2次调用b。"));

    }
}
class UnsharedConcreteFlyweight{
    private String info;
    UnsharedConcreteFlyweight(String info){
        this.info=info;
    }
    public String getInfo(){
        return info;
    }
    public void setInfo(String info){
        this.info=info;
    }
}
interface Flyweight{
    public void operation(UnsharedConcreteFlyweight state);
}
class ConcreteFlyweight implements Flyweight{
    private String key;
    ConcreteFlyweight(String key){
        this.key=key;
        System.out.println(key+"chuangjian");
    }
    public void operation(UnsharedConcreteFlyweight outState){
        System.out.print(key+"beidiaoyong");
        System.out.println(outState.getInfo());
    }
}
class FlyweightFactory{
    private HashMap<String,Flyweight> flyweights=new HashMap<String,Flyweight>();
    public Flyweight getFlyweight(String key){
        Flyweight flyweight=(Flyweight)flyweights.get(key);
        if(flyweight!=null){
            System.out.println(key+"huoqu");
        }else {
            flyweight=new ConcreteFlyweight(key);
            flyweights.put(key,flyweight);
        }
        return flyweight;
    }
}
