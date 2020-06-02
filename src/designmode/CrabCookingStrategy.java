import javax.swing.*;
import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CrabCookingStrategy implements ItemListener {
    private JFrame f;
    private JRadioButton qz,hs;
    private JPanel CenterJP,SouthJP;
    private Kitchen cf;
    private CrabCooking qzx,hsx;
    CrabCookingStrategy(){
        f=new JFrame("yingyong");
        f.setBounds(100,100,500,400);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        SouthJP=new JPanel();
        CenterJP=new JPanel();
        f.add("South",SouthJP);
        f.add("Center",CenterJP);
        qz=new JRadioButton("qingzheng");
        hs=new JRadioButton("hongshao");
        qz.addItemListener(this);
        hs.addItemListener(this);
        ButtonGroup group=new ButtonGroup();
        group.add(qz);
        group.add(hs);
        SouthJP.add(qz);
        SouthJP.add(hs);
        cf=new Kitchen();
        qzx=new SteamedCrabs();
        hsx=new BraisedCrabs();
    }
    public void itemStateChanged(ItemEvent e){
        JRadioButton jc=(JRadioButton)e.getSource();
        if(jc==qz){
            cf.setStrategy(qzx);
            cf.CookingMethod();
        }else if(jc==hs){
            cf.setStrategy(hsx);
            cf.CookingMethod();
        }
        CenterJP.removeAll();
        CenterJP.repaint();
        CenterJP.add((Component) cf.getStrategy());
        f.setVisible(true);
    }
    public static void main(String[] args){
        new CrabCookingStrategy();
    }
}
interface CrabCooking{
    public void CookingMethod();
}
class SteamedCrabs extends JLabel implements CrabCooking{
    private static final long serialVersionUID=1L;
    public void CookingMethod(){
        this.setIcon(new ImageIcon("src/SteamedCrabs.jpg"));
        this.setHorizontalAlignment(CENTER);
    }
}
class BraisedCrabs extends JLabel implements CrabCooking{
    private static final long serialVersionUID=1L;
    public void CookingMethod(){
        this.setIcon(new ImageIcon("src/BraisedCrabs.jpg"));
        this.setHorizontalAlignment(CENTER);
    }
}

class Kitchen{
    private CrabCooking strategy;
    public void setStrategy(CrabCooking strategy){
        this.strategy=strategy;
    }
    public CrabCooking getStrategy(){
        return strategy;
    }
    public void CookingMethod(){
        strategy.CookingMethod();
    }
}
