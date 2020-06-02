import org.omg.Messaging.SYNC_WITH_TRANSPORT;

public class MementoPattern {
    public static void main(String[] args){
        Originator or=new Originator();
        Caretaker cr=new Caretaker();
        or.setState("SO");
        System.out.println("chushizhuangtai: "+or.getState());
        cr.setMemento(or.createMemento());
        or.setState("S1");
        System.out.println("xindezhuangtai: "+or.getState());
        or.restoreMemento(cr.getMemento());
        System.out.println("huifuzhuangtai:"+or.getState());
    }
}
class Memento{
    private String state;
    public Memento(String state){
        this.state=state;
    }
    public void setState(String state){
        this.state=state;
    }
    public String getState(){
        return state;
    }
}
class Originator{
    private String state;
    public void setState(String state){
        this.state=state;
    }
    public String getState(){
        return state;
    }
    public Memento createMemento(){
        return new Memento(state);
    }
    public void restoreMemento(Memento m){
        this.setState(m.getState());
    }
}
class Caretaker{
    private Memento memento;
    public void setMemento(Memento m){
        memento=m;
    }
    public Memento getMemento(){
        return memento;
    }
}
