package designmode;

import javax.swing.*;
import java.awt.*;

public class AnimalFarmTest {
    public static void main(String[] args) {
        try {
            Animal a;
            AnimalFarm af;
            af=(AnimalFarm)ReadXML2.getObject();
            a=af.newAnimal();
            a.show();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

    interface Animal{
        public void show();
    }

    class Horse implements Animal{
        JScrollPane sp;
        JFrame jf=new JFrame("ceshi");
        public Horse(){
            Container contentPane=jf.getContentPane();
            JPanel pl=new JPanel();
            pl.setLayout(new GridLayout(1,1));
            pl.setBorder(BorderFactory.createTitledBorder("dongwu:ma"));
            sp=new JScrollPane(pl);
            contentPane.add(sp,BorderLayout.CENTER);
            JLabel l1=new JLabel(new ImageIcon("src/A_Horse.jpg"));
            pl.add(l1);
            jf.pack();
            jf.setVisible(false);
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        public void show(){
            jf.setVisible(true);
        }
    }

    class Cattle implements Animal{
        JScrollPane sp;
        JFrame jf=new JFrame("ceshi");
        public Cattle(){
            Container contentPane=jf.getContentPane();
            JPanel pl=new JPanel();
            pl.setLayout(new GridLayout(1,1));
            pl.setBorder(BorderFactory.createTitledBorder("dongwu:niu"));
            sp=new JScrollPane(pl);
            contentPane.add(sp,BorderLayout.CENTER);
            JLabel l1=new JLabel(new ImageIcon("src/A_Cattle.jpg"));
            pl.add(l1);
            jf.pack();
            jf.setVisible(false);
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        public void show(){
            jf.setVisible(true);
        }
    }

    interface AnimalFarm{
        public Animal newAnimal();
    }

    class HorseFarm implements AnimalFarm{
        public Animal newAnimal(){
            System.out.println("xinma chusheng");
            return new Horse();
        }
    }

    class CattleFarm implements AnimalFarm{
        public Animal newAnimal(){
            System.out.println("xinniu chusheng");
            return new Cattle();
        }
    }

