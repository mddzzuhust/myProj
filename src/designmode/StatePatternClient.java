public class StatePatternClient {
    public static void main(String[] args){
        Context1 context1=new Context1();
        context1.Handle();
        context1.Handle();
        context1.Handle();
        context1.Handle();
    }
}
class Context1{
    private State state;
    public Context1(){
        this.state=new ConcreteStateA();
    }
    public void setState(State state){
        this.state=state;
    }
    public State getState(){
        return (state);
    }
    public void Handle(){
        state.Handle(this);
    }
}
abstract class State{
    public abstract void Handle(Context1 context1);
}
class ConcreteStateA extends State{
    public void Handle(Context1 context1){
        System.out.println("A.");
        context1.setState(new ConcreteStateB());
    }
}
class ConcreteStateB extends State{
    public void Handle(Context1 context1){
        System.out.println("B");
        context1.setState(new ConcreteStateA());
    }
}
