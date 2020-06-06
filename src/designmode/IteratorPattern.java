package designmode;

import java.util.ArrayList;
import java.util.List;

public class IteratorPattern {
    public static void main(String[] args){
        Aggregate ag=new ConcreteAggregate();
        ag.add("zhongshandaxue");
        ag.add("huananligong");
        ag.add("shaoguanxueyuan");
        System.out.println("juhedeneirong: ");
        Iterator it=ag.getIterator();
        while (it.hasNext()){
            Object ob=it.next();
            System.out.println(ob.toString()+"\t");
        }
        Object ob=it.first();
        System.out.println("\nFirst: "+ob.toString());
    }
}
interface Aggregate{
    public void add(Object obj);
    public void remove(Object obj);
    public Iterator getIterator();
}
class ConcreteAggregate implements Aggregate{
    private List<Object> list=new ArrayList<Object>();
    public void add(Object obj){
        list.add(obj);
    }
    public void remove(Object obj){
        list.remove(obj);
    }
    public Iterator getIterator(){
        return (new ConcreteIterator(list));
    }
}
interface Iterator{
    Object first();
    Object next();
    boolean hasNext();
}
class ConcreteIterator implements Iterator{
    private List<Object> list=null;
    private int index=-1;
    public ConcreteIterator(List<Object> list){
        this.list=list;
    }
    public boolean hasNext(){
        if(index<list.size()-1){
            return true;
        }else {
            return false;
        }
    }
    public Object first(){
        index=0;
        Object obj=list.get(index);
        return obj;
    }
    public Object next(){
        Object obj=null;
        if(this.hasNext()){
            obj=list.get(++index);
        }
        return obj;
    }
}
