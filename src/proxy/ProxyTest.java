package proxy;

import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        Subject subject = new SubjectImpl();
        Subject proxy = (Subject) Proxy
                .newProxyInstance(
                        subject.getClass().getClassLoader(),
                        subject.getClass().getInterfaces(),
                        new ProxyInvocationHandler(subject));

        proxy.sayHello();
        /**
         * 打印输出如下
         * 调用处理器：🧱 🧱 🧱 进入代理调用处理器
         * 被代理实现类：Hello World
         */
    }
}