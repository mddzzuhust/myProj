public class HookTemplateMethod {
    public static void main(String[] args){
        HookAbstractClass tm=new HookConcreteClass();
        tm.TemplateMethod();
    }
}
abstract class HookAbstractClass{
    public void TemplateMethod(){
        abstractMethod1();
        HookMethod1();
        if(HookMethod2()){
            SpecificMethod();
        }
        abstractMethod2();
    }
    public void SpecificMethod(){
        System.out.println("jutifangfa");
    }
    public void HookMethod1() {}
    public boolean HookMethod2(){
        return true;
    }
    public abstract void abstractMethod1();
    public abstract void abstractMethod2();
}
class HookConcreteClass extends HookAbstractClass{
    public void abstractMethod1(){
        System.out.println("chouxiangfangfa1");
    }
    public void abstractMethod2(){
        System.out.println("chouxiangfangfa2");
    }
    public void HookMethod1(){
        System.out.println("gouzifangfa1");
    }
    public boolean HookMethod2(){
        return false;
    }
}
