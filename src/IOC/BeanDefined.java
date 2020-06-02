package IOC;

public class BeanDefined {

    // bean的id
   private String beanId;

   // bean的文件路径
   private String classPath;

    public String getBeanId() {
        return beanId;
    }
    public void setBeanId(String beanId) {
        this.beanId = beanId;
    }
    public String getClassPath() {
        return classPath;
    }
    public void setClassPath(String classPath) {
        this.classPath = classPath;
    }
}
