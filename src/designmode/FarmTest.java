import javax.swing.*;
import java.awt.*;

public class FarmTest {
    public static void main(String[] args){
        try {
            Farm f;
            Animal a;
            Plant p;
            f=(Farm)ReadXML.getObject("farm");
            a=f.newAnimal();
            p=f.newPlant();
            a.show();
            p.show();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
interface Plant{
    public void show();
}

class Fruitage implements Plant{
    JScrollPane sp;
    JFrame jf=new JFrame("ceshi");
    public Fruitage(){
        Container contentPane=jf.getContentPane();
        JPanel pl=new JPanel();
        pl.setLayout(new GridLayout(1,1));
        pl.setBorder(BorderFactory.createTitledBorder("zhiwu:shuiguo"));
        sp=new JScrollPane(pl);
        contentPane.add(sp,BorderLayout.CENTER);
        JLabel l1=new JLabel(new ImageIcon("src/P_Fruitage.jpg"));
        pl.add(l1);
        jf.pack();
        jf.setVisible(false);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void show(){
        jf.setVisible(true);
    }
}

class Vegetables implements Plant{
    JScrollPane sp;
    JFrame jf=new JFrame("ceshi");
    public Vegetables(){
        Container contentPane=jf.getContentPane();
        JPanel pl=new JPanel();
        pl.setLayout(new GridLayout(1,1));
        pl.setBorder(BorderFactory.createTitledBorder("zhiwu:shucai"));
        sp=new JScrollPane(pl);
        contentPane.add(sp,BorderLayout.CENTER);
        JLabel l1=new JLabel(new ImageIcon("src/P_Vegetables.jpg"));
        pl.add(l1);
        jf.pack();
        jf.setVisible(false);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void show(){
        jf.setVisible(true);
    }
}
interface Farm{
    public Animal newAnimal();
    public Plant newPlant();
}

class SGfarm implements Farm{
    public Animal newAnimal(){
        System.out.println("xinniuchusheng");
        return new Cattle();
    }
    public Plant newPlant(){
        System.out.println("shucaizhangcheng");
        return new Vegetables();
    }
}

class SRfarm implements Farm{
    public Animal newAnimal(){
        System.out.println("xinmachusheng");
        return new Horse();
    }
    public Plant newPlant(){
        System.out.println("shuiguozhangcheng");
        return new Fruitage();
    }
}
