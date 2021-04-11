package proxy;

public class SubjectImpl implements Subject {  // 定义代理接口实现类
    @Override
    public String sayHello() {
        System.out.println(" Hello World");
        return "success";
    }
}