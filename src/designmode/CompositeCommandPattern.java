package designmode;

import java.util.ArrayList;

public class CompositeCommandPattern {
    public static void main(String[] args){
        AbstractCommand cmd1=new ConcreteCommand1();
        AbstractCommand cmd2=new ConcreteCommand2();
        CompositeInvoker ir=new CompositeInvoker();
        ir.add(cmd1);
        ir.add(cmd2);
        System.out.println("executefangfa");
        ir.execute();
    }
}
interface AbstractCommand{
    public abstract void execute();
}
class ConcreteCommand1 implements AbstractCommand{
    private CompositeReceiver receiver;
    ConcreteCommand1(){
        receiver=new CompositeReceiver();
    }
    public void execute(){
        receiver.action1();
    }
}
class ConcreteCommand2 implements AbstractCommand{
    private CompositeReceiver receiver;
    ConcreteCommand2(){
        receiver=new CompositeReceiver();
    }
    public void execute(){
        receiver.action2();
    }
}
class CompositeInvoker implements AbstractCommand{
    private ArrayList<AbstractCommand> children=new ArrayList<AbstractCommand>();
    public void add(AbstractCommand c){
        children.add(c);
    }
    public void remove(AbstractCommand c){
        children.remove(c);
    }
    public AbstractCommand getChild(int i){
        return children.get(i);
    }
    public void execute(){
        for(Object obj:children){
            ((AbstractCommand)obj).execute();
        }
    }
}
class CompositeReceiver{
    public void action1(){
        System.out.println("action1");
    }
    public void action2(){
        System.out.println("action2");
    }
}
