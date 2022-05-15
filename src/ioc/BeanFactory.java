package ioc;

import java.util.List;

public class BeanFactory {
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
            return instance;
        }
    }
    return null;
   }
}

