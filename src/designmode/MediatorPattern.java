package designmode;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.util.ArrayList;
import java.util.List;

public class MediatorPattern {
    public static void main(String[] args){
        Mediator md=new ConcreteMediator();
        Colleague c1,c2;
        c1=new ConcreteColleague1();
        c2=new ConcreteColleague2();
        md.register(c1);
        md.register(c2);
        c1.send();
        System.out.println("----------");
        c2.send();
    }
}
abstract class Mediator{
    public abstract void register(Colleague colleague);
    public abstract void relay(Colleague cl);
}
class ConcreteMediator extends Mediator{
    private List<Colleague> colleagues=new ArrayList<Colleague>();
    public void register(Colleague colleague){
        if(!colleagues.contains(colleague)){
            colleagues.add(colleague);
            colleague.setMedium(this);
        }
    }
    public void relay(Colleague cl){
        for(Colleague ob:colleagues){
            if(!ob.equals(cl)){
                ((Colleague)ob).receive();
            }
        }
    }
}
abstract class Colleague{
    protected Mediator mediator;
    public void setMedium(Mediator mediator){
        this.mediator=mediator;
    }
    public abstract void receive();
    public abstract void send();
}
class ConcreteColleague1 extends Colleague{
    public void receive(){
        System.out.println("1shoudao");
    }
    public void send(){
        System.out.println("1fachu");
        mediator.relay(this);
    }
}
class ConcreteColleague2 extends Colleague{
    public void receive(){
        System.out.println("2shoudao");
    }
    public void send(){
        System.out.println("2fachu");
        mediator.relay(this);
    }
}
