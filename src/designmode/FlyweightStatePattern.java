import java.util.HashMap;

public class FlyweightStatePattern {
    public static void main(String[] args){
        ShareContext context=new ShareContext();
        context.Handle();
        context.Handle();
        context.Handle();
        context.Handle();
    }
}
class ShareContext{
    private ShareState state;
    private HashMap<String,ShareState> stateSet=
            new HashMap<String, ShareState>();
    public ShareContext(){
        state=new ConcreteState1();
        stateSet.put("1",state);
        state=new ConcreteState2();
        stateSet.put("2",state);
        state=getState("1");
    }
    public void setState(ShareState state){
        this.state=state;
    }
    public ShareState getState(String key){
        ShareState s=(ShareState)stateSet.get(key);
        return s;
    }
    public void Handle(){
        state.Handle(this);
    }
}
abstract class ShareState{
    public abstract void Handle(ShareContext context);
}
class ConcreteState1 extends ShareState{
    public void Handle(ShareContext context){
        System.out.println("zhuangtai1");
        context.setState(context.getState("2"));
    }
}
class ConcreteState2 extends ShareState{
    public void Handle(ShareContext context){
        System.out.println("zhuangtai2");
        context.setState(context.getState("1"));
    }
}
