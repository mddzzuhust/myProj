package designmode;

public class LeaveApprovalTest {
    public static void main(String[] args){
        Leader teacher1=new ClassAdviser();
        Leader teacher2=new DepartmentHead();
        Leader teacher3=new Dean();
        teacher1.setNext(teacher2);
        teacher2.setNext(teacher3);
        teacher1.handleRequest(8);
    }
}
abstract class Leader{
    private Leader next;
    public void setNext(Leader next){
        this.next=next;
    }
    public Leader getNext(){
        return next;
    }
    public abstract void handleRequest(int LeaveDays);
}
class ClassAdviser extends Leader{
    public void handleRequest(int LeaveDays){
        if(LeaveDays<=2){
            System.out.println("banzhuren "+LeaveDays);
        }else {
            if(getNext()!=null){
                getNext().handleRequest(LeaveDays);
            }else {
                System.out.println("meiyouren");
            }
        }
    }
}
class DepartmentHead extends Leader{
    public void handleRequest(int LeaveDays){
        if(LeaveDays<=7){
            System.out.println("xizhuren: "+LeaveDays);
        }else {
            if(getNext()!=null){
                getNext().handleRequest(LeaveDays);
            }else {
                System.out.println("meiyouren");
            }
        }
    }
}
class Dean extends Leader{
    public void handleRequest(int LeaveDays){
        if(LeaveDays<=10){
            System.out.println("yuanzhang: "+LeaveDays);
        }else {
            if(getNext()!=null){
                getNext().handleRequest(LeaveDays);
            }else {
                System.out.println("meiyouren");
            }
        }
    }
}
class DeanOfStudies extends Leader{
    public void handleRequest(int LeaveDays){
        if(LeaveDays<=20){
            System.out.println("jiaowuchuzhang: "+LeaveDays);
        }else {
            if(getNext()!=null){
                getNext().handleRequest(LeaveDays);
            }else {
                System.out.println("meiyouren");
            }
        }
    }
}