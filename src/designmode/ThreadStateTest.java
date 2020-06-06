package designmode;

public class ThreadStateTest {
    public static void main(String[] args){
        ThreadContext context=new ThreadContext();
        context.start();
        context.getCPU();
        context.suspend();
        context.resume();
        context.getCPU();
        context.stop();
    }
}
class ThreadContext{
    private ThreadState state;
    ThreadContext(){
        state=new New();
    }
    public void setState(ThreadState state){
        this.state=state;
    }
    public ThreadState getState(){
        return state;
    }
    public void start(){
        ((New)state).start(this);
    }
    public void getCPU(){
        ((Runnable)state).getCPU(this);
    }
    public void suspend(){
        ((Running)state).suspend(this);
    }
    public void stop(){
        ((Running)state).stop(this);
    }
    public void resume(){
        ((Blocked)state).resume(this);
    }
}
abstract class ThreadState{
    protected String stateName;
}
class New extends ThreadState{
    public New(){
        stateName="xinjianzhuangtai";
        System.out.println("xinjianzhuangtai");
    }
    public void start(ThreadContext hj){
        System.out.print("startfangfa");
        if(stateName.equals("xinjianzhuangtai")){
            hj.setState(new Runnable());
        }else {
            System.out.println("bunengdiaoyong");
        }
    }
}
class Runnable extends ThreadState{
    public Runnable(){
        stateName="jiuxuzhuangtai";
        System.out.println("jiuxuzhuangtai");
    }
    public void getCPU(ThreadContext hj){
        System.out.print("huodeCPUshijian--->");
        if(stateName.equals("jiuxuzhuangtai")){
            hj.setState(new Running());
        }else {
            System.out.println("bunenghuoquCPU");
        }
    }
}
class Running extends ThreadState{
    public Running(){
        stateName="yunxingzhuangtai";
        System.out.println("yunxingzhuangtai");
    }
    public void suspend(ThreadContext hj){
        System.out.print("suspendfangfa-->");
        if(stateName.equals("yunxingzhuangtai")){
            hj.setState(new Blocked());
        }else {
            System.out.println("suspendfangfa");
        }
    }
    public void stop(ThreadContext hj){
        System.out.print("stop()fangfan--->");
        if(stateName.equals("yunxingzhuangtai")){
            hj.setState(new Dead());
        }else {
            System.out.println("stop()fangfa");
        }
    }
}
class Blocked extends ThreadState{
    public Blocked(){
        stateName="zusezhuangtai";
        System.out.println("zusezhuangtai");
    }
    public void resume(ThreadContext hj){
        System.out.print("resumefangfa---->");
        if(stateName.equals("zusezhuangtai")){
            hj.setState(new Runnable());
        }else {
            System.out.println("bunengdiaoyong");
        }
    }
}
class Dead extends ThreadState{
    public Dead(){
        stateName="siwangzhuangtai";
        System.out.println("siwangzhuangtai");
    }
}