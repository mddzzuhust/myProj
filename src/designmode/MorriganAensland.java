package designmode;

import javax.swing.*;
import java.awt.*;

public class MorriganAensland {
    public static void main(String[] args){
        Morrigan m0=new original();
        m0.display();
        Morrigan m1=new Succubus(m0);
        m1.display();
        Morrigan m2=new Girl(m0);
        m2.display();
    }
}
interface Morrigan{
    public void display();
}
class original extends JFrame implements Morrigan{
    private static final long serialVersionUID=1L;
    private String t="Morrigan0.jgp";
    public original(){
        super("ansilan");
    }
    public void setImage(String t){
        this.t=t;
    }
    public void display(){
        this.setLayout(new FlowLayout());
        JLabel l1=new JLabel(new ImageIcon("src/"+t));
        this.add(l1);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
class Changer implements Morrigan{
    Morrigan m;
    public Changer(Morrigan m){
        this.m=m;
    }
    public void display(){
        m.display();
    }
}
class Succubus extends Changer{
    public Succubus(Morrigan m){
        super(m);
    }
    public void display(){
        setChanger();
        super.display();
    }
    public void setChanger(){
        ((original)super.m).setImage("Morrigan1.jpg");
    }
}
class Girl extends Changer{
    public Girl(Morrigan m){
        super(m);
    }
    public void display(){
        setChanger();
        super.display();
    }
    public void setChanger(){
        ((original)super.m).setImage("Morrigan2.jpg");
    }
}
