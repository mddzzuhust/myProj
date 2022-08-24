package ioc;

/*
* 从代码里面可以看出来，我们是没有直接new学生类的，主要的思想是，
* 定义BeanDefined对象添加进集合中，通过BeanFactory为我们生产出需要的对象，
* 其中用到的核心技术就是：反射
* */

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws Exception {
        // 1、声明注册bean
        BeanDefined beanObj = new BeanDefined();
        beanObj.setBeanId("student");
        beanObj.setClassPath("ioc.Student");
        List<BeanDefined> beanList = new ArrayList<BeanDefined>();
        beanList.add(beanObj);

        // 2、声明一个BeanFactory，类似于Spring中的ApplicationContext
        BeanFactory factory = new BeanFactory();
        factory.setBeanDefinedList(beanList);

        // 3、开发人员向BeanFactory索要实例对象
        Student student = (Student) factory.getBean("student");
        System.out.println(student);
    }
}