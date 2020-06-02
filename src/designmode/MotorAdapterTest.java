interface Motor{
    public void drive();
}
class ElectricMotor{
    public void electricDrive(){
        System.out.println("dianneng");
    }
}
class OpticalMotor{
    public  void opticalDrive(){
        System.out.println("guangneng");
    }
}
class ElectricAdapter implements Motor{
    private ElectricMotor emotor;
    public ElectricAdapter(){
        emotor=new ElectricMotor();
    }
    public void drive(){
        emotor.electricDrive();
    }
}

class OpticalAdapter implements Motor{
    private OpticalMotor omotor;
    public OpticalAdapter(){
        omotor=new OpticalMotor();
    }
    public void drive(){
        omotor.opticalDrive();
    }
}
public class MotorAdapterTest {
    public static void main(String[] args){
        System.out.println("ceshi");
        Motor motor=(Motor)ReadXML.getObject("bag");
        motor.drive();
    }
}
