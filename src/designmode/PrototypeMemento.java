package designmode;

public class PrototypeMemento {
    public static void main(String[] args){
        OriginatorPrototype or=new OriginatorPrototype();
        PrototypeCaretaker cr=new PrototypeCaretaker();
        or.setState("S0");
        System.out.println("chushizhuangtai: "+or.getState());
        cr.setMemento(or.createMemento());
        or.setState("S1");
        System.out.println("xindezhuangtai: "+or.getState());
        or.restoreMemento(cr.getMemento());
        System.out.println("huifuzhuangtai: "+or.getState());
    }
}
class OriginatorPrototype implements Cloneable{
    private String state;
    public void setState(String state){
        this.state=state;
    }
    public String getState(){
        return state;
    }
    public OriginatorPrototype createMemento(){
        return this.clone();
    }
    public void restoreMemento(OriginatorPrototype opt){
        this.setState(opt.getState());;
    }
    public OriginatorPrototype clone(){
        try{
            return (OriginatorPrototype)super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return null;
    }
}
class PrototypeCaretaker{
    private OriginatorPrototype opt;
    public void setMemento(OriginatorPrototype opt){
        this.opt=opt;
    }
    public OriginatorPrototype getMemento(){
        return opt;
    }
}