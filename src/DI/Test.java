package DI;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Test {
    public static void main(String[] args) throws Exception {
        // 1、声明注册bean
        BeanDefined beanObj = new BeanDefined();
        beanObj.setBeanId("student");
        beanObj.setClassPath("DI.Student");
        // 设置 property
        Map<String, String> propertyMap = beanObj.getPropertyMap();
        propertyMap.put("name", "kxm");
        propertyMap.put("age", "22岁");
        propertyMap.put("teacher", "teacher");
        // 注册教师类
        BeanDefined teacher = new BeanDefined();
        teacher.setBeanId("teacher");
        teacher.setClassPath("DI.Teacher");
        List<BeanDefined> beanList = new ArrayList<BeanDefined>();
        beanList.add(beanObj);
        beanList.add(teacher);

        // 2、声明一个BeanFactory，类似于Spring中的ApplicationContext
        BeanFactory factory = new BeanFactory();
        factory.setBeanDefinedList(beanList);

        // 3、开发人员向BeanFactory索要实例对象
        Student student = (Student) factory.getBean("student");
        System.out.println(student);
    }
}
