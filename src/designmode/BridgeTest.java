public class BridgeTest {
    public static void main(String[] args){
        Implementor imple=new ConcreteImplementorA();
        Abstraction abs=new RefineAbstraction(imple);
        abs.Operation();
    }
}
interface Implementor{
    public void OperationImpl();
}
class ConcreteImplementorA implements Implementor{
    public void OperationImpl(){
        System.out.println("jutishixianhua");
    }
}
abstract class Abstraction{
    protected Implementor imple;
    protected Abstraction(Implementor imple){
        this.imple=imple;
    }
    public abstract void Operation();
}
class RefineAbstraction extends Abstraction{
    protected RefineAbstraction(Implementor imple){
        super(imple);
    }
    public void Operation(){
        System.out.println("kuozhanchouxianghua");
        imple.OperationImpl();
    }
}
