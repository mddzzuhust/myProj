package designmode;

import java.util.*;
import java.util.Iterator;

public class BellEventTest {
    public static void main(String[] args){
        BellEventSource bell=new BellEventSource();
        bell.addPersonListener(new TeachEventListener());
        bell.addPersonListener(new StuEventListener());
        bell.ring(true);
        System.out.println("----------");
        bell.ring(false);
    }
}
class RingEvent extends EventObject{
    private static final long serialVersionUID=1L;
    private boolean sound;
    public RingEvent(Object source,boolean sound){
        super(source);
        this.sound=sound;
    }
    public void setSound(boolean sound){
        this.sound=sound;
    }
    public boolean getSound(){
        return this.sound;
    }
}
class BellEventSource{
    private List<BellEventListener> listener;
    public BellEventSource(){
        listener=new ArrayList<BellEventListener>();
    }
    public void addPersonListener(BellEventListener ren){
        listener.add(ren);
    }
    public void ring(boolean sound){
        String type=sound?"shangkeling":"xiakeling";
        System.out.println(type+"xiang!");
        RingEvent event=new RingEvent(this,sound);
        nofifies(event);
    }
    protected void nofifies(RingEvent e){
        BellEventListener ren=null;
        Iterator<BellEventListener> iterator=listener.iterator();
        while (iterator.hasNext()){
            ren= (BellEventListener) iterator.next();
            ren.heardBell(e);
        }
    }
}
interface BellEventListener extends EventListener{
    public void heardBell(RingEvent e);
}
class TeachEventListener implements BellEventListener{
    public void heardBell(RingEvent e){
        if(e.getSound()){
            System.out.println("laoshishangkele...");
        }else {
            System.out.println("laoshixiakele");
        }
    }
}
class StuEventListener implements BellEventListener{
    public void heardBell(RingEvent e){
        if(e.getSound()){
            System.out.println("tongxuemen,shangkele");
        }else {
            System.out.println("tongxuemen,xiakele");
        }
    }
}