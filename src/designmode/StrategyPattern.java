public class StrategyPattern {
    public static void main(String[] args){
        Context c=new Context();
        Strategy s=new ConcreteStategyA();
        c.setStrategy(s);
        c.strategyMethod();
        System.out.println("-----------");
        s=new ConcreteStrategyB();
        c.setStrategy(s);
        c.strategyMethod();
    }
}
interface Strategy{
    public void strategyMethod();
}
class ConcreteStategyA implements Strategy{
    public void strategyMethod(){
        System.out.println("juticelueA");
    }
}
class ConcreteStrategyB implements Strategy{
    public void strategyMethod(){
        System.out.println("juticelueB");
    }
}
class Context{
    private Strategy strategy;
    public Strategy getStrategy(){
        return strategy;
    }
    public void setStrategy(Strategy strategy){
        this.strategy=strategy;
    }
    public void strategyMethod(){
        strategy.strategyMethod();
    }
}
