package annotation.employee;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class EmployeeInfoUtil {
    public static Map getEmployeeInfo(Class<?> clazz){
        HashMap<String ,String> info = new HashMap<>();
        Field[] fields = clazz.getDeclaredFields();//获取类成员变量
        for (Field field: fields) {//遍历
            if (field.isAnnotationPresent(EmployeeName.class)){//判断是不是EmployeeName类型注解
                EmployeeName employeeName = field.getAnnotation(EmployeeName.class);
                info.put("employeeName",employeeName.value());//获取注解的值
            }
            if (field.isAnnotationPresent(EmployeeSex.class)) {
                EmployeeSex employeeSex = field.getAnnotation(EmployeeSex.class);
                info.put("employeeSex",employeeSex.employeeSex().toString());
            }
            if (field.isAnnotationPresent(Company.class)) {
                Company company = field.getAnnotation(Company.class);
                info.put("company",company.id()+":"+company.name()+":"+company.address());
            }
        }
        return info;
    }
}
