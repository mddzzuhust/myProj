import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {
    public static void main(String[] args){
        Subject1 subject1=new ConcreteSubject();
        Observer obs1=new ConcreteObserver1();
        Observer obs2=new ConcreteObserver2();
        subject1.add(obs1);
        subject1.add(obs2);
        subject1.notifyObserver();
    }
}
abstract class Subject1{
    protected List<Observer> observers=new ArrayList<Observer>();
    public void add(Observer observer){
        observers.add(observer);
    }
    public void remove(Observer observer){
        observers.remove(observer);
    }
    public abstract void notifyObserver();
}
class ConcreteSubject extends Subject1{
    public void notifyObserver(){
        System.out.println("jutimubiao...");
        System.out.println("-------");
        for(Object obs:observers){
            ((Observer)obs).response();
        }
    }
}
interface Observer{
    void response();
}
class ConcreteObserver1 implements Observer{
    public void response(){
        System.out.println("jutiguanchazhe1");
    }
}
class ConcreteObserver2 implements Observer{
    public void response(){
        System.out.println("jutiguanchazhe2");
    }
}