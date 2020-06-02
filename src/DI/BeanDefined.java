package DI;


import java.util.HashMap;
import java.util.Map;

public class BeanDefined {
    // bean的id
    private String beanId;
    // bean的文件路径
    private String classPath;
    // 存放属性的集合
    private Map<String, String> propertyMap = new HashMap<>();

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

    public Map<String, String> getPropertyMap() {
        return propertyMap;
    }

    public void setPropertyMap(Map<String, String> propertyMap) {
        this.propertyMap = propertyMap;
    }
}