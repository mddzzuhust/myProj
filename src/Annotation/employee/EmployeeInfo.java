package Annotation.employee;

public class EmployeeInfo {
    @EmployeeName("zfq")
    private String employeeName;
    @EmployeeSex(employeeSex = EmployeeSex.Sex.Woman)
    private String employeeSex;
    @Company(id = 1,name = "HYR集团",address = "河南开封")
    private String company;

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeSex() {
        return employeeSex;
    }

    public void setEmployeeSex(String employeeSex) {
        this.employeeSex = employeeSex;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
