interface TwoWayTarget{
    public void request();
}
interface TwoWayAdaptee{
    public void specificRequest();
}
class TargetRealize implements TwoWayTarget{
    public void request(){
        System.out.println("mubiaodaima");
    }
}
class AdapteeRealize implements TwoWayAdaptee{
    public void specificRequest(){
        System.out.println("shipeizhe");
    }
}
class TwoWayAdapter implements TwoWayTarget,TwoWayAdaptee{
    private TwoWayTarget target;
    private TwoWayAdaptee adaptee;
    public TwoWayAdapter(TwoWayTarget target){
        this.target=target;
    }
    public TwoWayAdapter(TwoWayAdaptee adaptee){
        this.adaptee=adaptee;
    }
    public void request(){
        adaptee.specificRequest();
    }
    public void specificRequest(){
        target.request();
    }
}
public class TwoWayAdapterTest {
    public static void main(String[] args){
        System.out.println("fangwenshipeizhe:");
        TwoWayAdaptee adaptee=new AdapteeRealize();
        TwoWayTarget target=new TwoWayAdapter(adaptee);
        target.request();
        System.out.println("--------------------");
        System.out.println("fangwenmubiao:");
        target=new TargetRealize();
        adaptee=new TwoWayAdapter(target);
        adaptee.specificRequest();
    }
}
