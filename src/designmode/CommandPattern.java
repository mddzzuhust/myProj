public class CommandPattern {
    public static void main(String[] args){
        Command cmd=new ConcreteCommand();
        Invoker ir=new Invoker(cmd);
        System.out.println("callfangfa");
        ir.call();
    }
}
class Invoker{
    private Command command;
    public Invoker(Command command){
        this.command=command;
    }
    public void setCommand(Command command){
        this.command=command;
    }
    public void call(){
        System.out.println("diaoyongcommand");
        command.execute();
    }
}
interface Command{
    public abstract void execute();
}
class ConcreteCommand implements Command{
    private Receiver receiver;
    ConcreteCommand(){
        receiver=new Receiver();
    }
    public void execute(){
        receiver.action();
    }
}
class Receiver{
    public void action(){
        System.out.println("action()beidiaoyong");
    }
}

