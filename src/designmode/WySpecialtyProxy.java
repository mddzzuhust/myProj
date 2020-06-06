package designmode;

import javax.swing.*;

public class WySpecialtyProxy {
    public static void main(String[] args){
        SgProxy proxy=new SgProxy();
        proxy.display();
    }
}
interface Specialty{
    void display();
}
class WySpecialty1 extends JFrame implements Specialty{
    private static final long serialVersion=1L;
    public WySpecialty1(){
        super("teseceshi");
        JLabel l1=new JLabel(new ImageIcon("src/WuyuanSpecialty.jpg"));
        this.add(l1);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void display(){
        this.setVisible(true);
    }
}

class SgProxy implements Specialty{
    private WySpecialty1 realSubject=new WySpecialty1();
    public void display(){
        preRequest();
        realSubject.display();
        postRequest();
    }
    public void preRequest(){
        System.out.println("kaishi");
    }
    public void postRequest(){
        System.out.println("jieshu");
    }
}
