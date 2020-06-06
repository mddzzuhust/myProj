package designmode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class VisitorPattern {
    public static void main(String[] args){
        ObjectStructure os=new ObjectStructure();
        os.add(new ConcreteElementA());
        os.add(new ConcreteElementB());
        Visitor visitor=new ConcreteVisitorA();
        os.accept(visitor);
        System.out.println("------------");
        visitor=new ConcreteVisitorB();
        os.accept(visitor);
    }
}
interface Visitor{
    void visit(ConcreteElementA element);
    void visit(ConcreteElementB element);
}
class ConcreteVisitorA implements Visitor{
    public void visit(ConcreteElementA element){
        System.out.println("Afangwen-->"+element.operationA());
    }
    public void visit(ConcreteElementB element){
        System.out.println("Afangwen-->"+element.operationB());
    }
}
class ConcreteVisitorB implements Visitor{
    public void visit(ConcreteElementA element){
        System.out.println("Bfangwen-->"+element.operationA());
    }
    public void visit(ConcreteElementB element){
        System.out.println("Bfangwen-->"+element.operationB());
    }
}
interface Element{
    void accept(Visitor visitor);
}
class ConcreteElementA implements Element{
    public void accept(Visitor visitor){
        visitor.visit(this);
    }
    public String operationA(){
        return "jutiyuansuAdecaozuo";
    }
}
class ConcreteElementB implements Element{
    public void accept(Visitor visitor){
        visitor.visit(this);
    }
    public String operationB(){
        return "jutiyuansuBdecaozuo";
    }
}
class ObjectStructure{
    private List<Element> list=new ArrayList<Element>();
    public void accept(Visitor visitor){
        Iterator<Element> i=list.iterator();
        while (i.hasNext()){
            ((Element)i.next()).accept(visitor);
        }
    }
    public void add(Element element){
        list.add(element);
    }
    public void remove(Element element){
        list.remove(element);
    }
}
