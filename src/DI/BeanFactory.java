package DI;

/**
 * 仔细分析代码，我们可以发现，没有显示的new对象，也没用用set方法去赋值，
 * 但是模拟出来了依赖注入的效果，这也是Spring中依赖注入的原理，
 * 当然这里是最简单的实现，剩下的路，还需要骚年你自己走哇~
 */
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class BeanFactory{

        // 存放bean的集合
        private List<BeanDefined> beanDefinedList;

        public List<BeanDefined> getBeanDefinedList() {
        return beanDefinedList;
        }

        public void setBeanDefinedList(List<BeanDefined> beanDefinedList) {
            this.beanDefinedList = beanDefinedList;
        }
        /**
     * 获取bean实例
     *
     * @param beanId
     * @return
     * @throws Exception
     */
        public Object getBean(String beanId) throws Exception {
        Object instance;
        for (BeanDefined bean : beanDefinedList) {
            if (beanId.equals(bean.getBeanId())) {
                String classPath = bean.getClassPath();
                Class classFile = Class.forName(classPath);
                // 在spring中调用默认的构造方法，这里我们也调用默认的构造方法
                instance = classFile.newInstance();
                // 获取bean的属性配置
                Map<String, String> propertyMap = bean.getPropertyMap();
                if(propertyMap !=null) {
                    setValue(instance, classFile, propertyMap);
                }
                return instance;
            }
        }
        return null;
  }

        /**
     * 依赖注入的方法
     *
     * @param instance    当前的实例对象
     * @param classFile   当前实例对象所关联的类文件
     * @param propertyMap 属性
     */
     public void setValue(Object instance, Class classFile, Map<String, String> propertyMap) throws Exception {
        if(propertyMap !=null ) {
                /***
                * 获取map的所有属性配置
                */
            Set<String> proper = propertyMap.keySet();
            for(String string : proper) {
                // 通过字符串拼接，拼出set方法名
                char c = string.toUpperCase().charAt(0);
                String s = "set" + c + string.substring(1);
                // 获取当前属性的类型
                Field field = classFile.getDeclaredField(string);
                // 根据属性的类型进行调用
                Method m = instance.getClass().getMethod(s, field.getType());
                /**
                                 * 直接try注入普通类型，或者catch注入bean工厂中的其他类型
                                 */
                try {
                    m.invoke(instance, propertyMap.get(string));
                } catch (Exception e) {
                    m.invoke(instance, getBean(propertyMap.get(string)));
                }
            }
        }
      }
}