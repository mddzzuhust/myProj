package Annotation.employee;

import java.util.Map;

public class EmployeeRun {
    public static void main(String[] args) {
        Map fruitInfo = EmployeeInfoUtil.getEmployeeInfo(EmployeeInfo.class);
        System.out.println(fruitInfo);
    }
}
