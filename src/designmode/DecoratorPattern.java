public class DecoratorPattern {
    public static void main(String[] args){
        Component p=new ConcreteComponent();
        p.operation();
        System.out.println("-------------");
        Component d=new ConcreteDecorator(p);
        d.operation();
    }
}
interface Component{
    public void operation();
}
class ConcreteComponent implements Component{
    public ConcreteComponent(){
        System.out.println("goujianjuese");
    }
    public void operation(){
        System.out.println("operation()");
    }
}
class DecoratorRole implements Component{
    private Component component;
    public DecoratorRole(Component component){
        this.component=component;
    }
    public void operation(){
        component.operation();
    }
}
class ConcreteDecorator extends DecoratorRole{
    public ConcreteDecorator(Component component){
        super(component);
    }
    public void operation(){
        super.operation();
        addedFunction();
    }
    public void addedFunction(){
        System.out.println("addedFunction");
    }
}
