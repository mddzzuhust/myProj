import java.util.HashMap;
import java.util.Scanner;

interface Shape extends Cloneable{
    public Object clone();
    public void countArea();
}
class Circle implements Shape{
    public Object clone(){
        Circle w=null;
        try {
            w=(Circle)super.clone();
        }catch (CloneNotSupportedException e){
            System.out.println("copy circle fail");
        }
        return w;
    }
    public void countArea(){
        int r=0;
        System.out.print("banjing:");
        Scanner input=new Scanner(System.in);
        r=input.nextInt();
        System.out.println("mianji:"+3.1415*r*r+"\n");
    }
}
class Square implements Shape{
    public Object clone(){
        Square b=null;
        try {
            b=(Square)super.clone();
        }catch (CloneNotSupportedException e){
            System.out.println("copy square fail");
        }
        return b;
    }
    public void countArea(){
       int a=0;
       System.out.print("bianchang: ");
       Scanner input=new Scanner(System.in);
       a=input.nextInt();
       System.out.println("square mianji:"+a*a+"\n");
    }
}
class ProtoTypeManager{
    private HashMap<String,Shape>ht=new HashMap<String,Shape>();
    public ProtoTypeManager(){
        ht.put("Circle",new Circle());
        ht.put("Square",new Square());
    }
    public void addshape(String key,Shape obj){
        ht.put(key,obj);
    }
    public Shape getShape(String key){
        Shape temp=ht.get(key);
        return (Shape)temp.clone();
    }
}
public class ProtoTypeShape {
    public static void main(String[] args){
        ProtoTypeManager pm=new ProtoTypeManager();
        Shape obj1=(Circle)pm.getShape("Circle");
        obj1.countArea();
        Shape obj2=(Shape)pm.getShape("Square");
        obj2.countArea();
    }
}
