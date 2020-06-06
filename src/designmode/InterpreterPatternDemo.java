package designmode;

import java.util.HashSet;
import java.util.Set;

public class InterpreterPatternDemo {
    public static void main(String[] args){
        Context2 bus=new Context2();
        bus.freeRide("韶关的老人");
        bus.freeRide("韶关的年轻人");
        bus.freeRide("广州的妇女");
        bus.freeRide("广州的儿童");
        bus.freeRide("山东的儿童");
    }
}
interface Expression{
    public boolean interpret(String info);
}
class TerminalExpression implements Expression{
    private Set<String> set=new HashSet<String>();
    public TerminalExpression(String[] data){
        for(int i=0;i<data.length;i++)
            set.add(data[i]);
    }
    public boolean interpret(String info){
        if(set.contains(info)){
            return true;
        }
        return false;
    }
}
class AndExpression implements Expression{
    private Expression city=null;
    private Expression person=null;
    public AndExpression(Expression city,Expression person){
        this.city=city;
        this.person=person;
    }
    public boolean interpret(String info){
        String s[]=info.split("de");
        return city.interpret(s[0])&&person.interpret(s[1]);
    }
}
class Context2{
    private String[] citys={"shaoguan","guangzhou"};
    private String[] persons={"laoren","funv","ertong"};
    private Expression cityPerson;
    public Context2(){
        Expression city=new TerminalExpression(citys);
        Expression person=new TerminalExpression(persons);
        cityPerson=new AndExpression(city,person);
    }
    public void freeRide(String info){
        boolean ok=cityPerson.interpret(info);
        if(ok)
            System.out.println("nishi"+info);
        else
            System.out.println(info+"nibushi");
    }
}
