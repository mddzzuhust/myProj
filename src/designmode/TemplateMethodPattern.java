public class TemplateMethodPattern {
    public static void main(String[] args){
        AbstractClass tm=new ConcreteClass();
        tm.TemplateMethod();
    }
}
abstract class AbstractClass{
    public void TemplateMethod(){
        SpecificMethod();
        abstractMethod1();
        abstractMethod2();
    }
    public void SpecificMethod(){
        System.out.println("jutifangfa");
    }
    public abstract void abstractMethod1();
    public abstract void abstractMethod2();
}

class ConcreteClass extends AbstractClass{
    public void abstractMethod1(){
        System.out.println("chouxiang1");
    }
    public void abstractMethod2(){
        System.out.println("chouxiang2");
    }
}
