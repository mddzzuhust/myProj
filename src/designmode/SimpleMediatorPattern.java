package designmode;

import java.util.ArrayList;
import java.util.List;

public class SimpleMediatorPattern {
    public static void main(String[] args){
        SimpleColleague c1,c2;
        c1=new SimpleConcreteColleague1();
        c2=new SimpleConcreteColleague2();
        c1.send();
        System.out.println("------------");
        c2.send();
    }
}
class SimpleMediator{
    private static SimpleMediator smd=new SimpleMediator();
    private List<SimpleColleague> colleagues=new ArrayList<SimpleColleague>();
    private SimpleMediator(){ }
    public static SimpleMediator getMedium(){
        return (smd);
    }
    public void register(SimpleColleague colleague){
        if(!colleagues.contains(colleague)){
            colleagues.add(colleague);
        }
    }
    public void relay(SimpleColleague scl){
        for(SimpleColleague ob:colleagues){
            if(!ob.equals(scl)){
                ((SimpleColleague)ob).receive();
            }
        }
    }
}
interface SimpleColleague{
    void receive();
    void send();
}
class SimpleConcreteColleague1 implements SimpleColleague{
    SimpleConcreteColleague1(){
        SimpleMediator smd=SimpleMediator.getMedium();
        smd.register(this);
    }
    public void receive(){
        System.out.println("1shoudaoqingqiu");
    }
    public void send(){
        SimpleMediator smd=SimpleMediator.getMedium();
        System.out.println("1fachuqingqiu");
        smd.relay(this);
    }
}
class SimpleConcreteColleague2 implements SimpleColleague{
    SimpleConcreteColleague2(){
        SimpleMediator smd=SimpleMediator.getMedium();
        smd.register(this);
    }
    public void receive(){
        System.out.println("2shoudaoqingqiu");
    }
    public void send(){
        SimpleMediator smd=SimpleMediator.getMedium();
        System.out.println("2fachuqingqiu");
        smd.relay(this);
    }
}