import javax.swing.*;
import java.awt.*;

public class SingletonEager {
    public static void main(String[] args){
        JFrame jf=new JFrame("test");
        jf.setLayout(new GridLayout(1,2));
        Container contentPane=jf.getContentPane();
        Bajie obj1=Bajie.getInstance();
        contentPane.add(obj1);
        Bajie obj2=Bajie.getInstance();
        contentPane.add(obj2);
        if(obj1==obj2){
            System.out.println("they are the same");
        }else {
            System.out.println("they are not the same");
        }
        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
class Bajie extends JPanel{
    private static Bajie instance=new Bajie();
    private Bajie(){
        JLabel l1=new JLabel(new ImageIcon("src/Bajie.jpg"));
        this.add(l1);
    }
    public static Bajie getInstance(){
        return instance;
    }
}
