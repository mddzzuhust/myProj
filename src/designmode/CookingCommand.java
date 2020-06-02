import javax.swing.*;

public class CookingCommand {
    public static void main(String[] args){
        Breakfast food1=new ChangFen();
        Breakfast food2=new HunTun();
        Breakfast food3=new HeFen();
        Waiter fwy=new Waiter();
        fwy.setChangFen(food1);
        fwy.setHunTun(food2);
        fwy.setHeFen(food3);
        fwy.chooseChangFen();
        fwy.chooseHeFen();
        fwy.chooseHunTun();
    }
}
class Waiter{
    private Breakfast changFen,hunTun,heFen;
    public void setChangFen(Breakfast f){
        changFen=f;
    }
    public void setHunTun(Breakfast f){
        hunTun=f;
    }
    public void setHeFen(Breakfast f){
        heFen=f;
    }
    public void chooseChangFen(){
        changFen.cooking();
    }
    public void chooseHunTun(){
        hunTun.cooking();
    }
    public void chooseHeFen(){
        heFen.cooking();
    }
}
interface Breakfast{
    public abstract void cooking();
}
class ChangFen implements Breakfast{
    private ChangFenChef receiver;
    ChangFen(){
        receiver=new ChangFenChef();
    }
    public void cooking(){
        receiver.cooking();
    }
}
class HunTun implements Breakfast{
    private HunTunChef receiver;
    HunTun(){
        receiver=new HunTunChef();
    }
    public void cooking(){
        receiver.cooking();
    }
}
class HeFen implements Breakfast{
    private HeFenChef receiver;
    HeFen(){
        receiver=new HeFenChef();
    }
    public void cooking(){
        receiver.cooking();
    }
}

class ChangFenChef extends JFrame{
    private static final long serialVersionUID=1L;
    JLabel l=new JLabel();
    ChangFenChef(){
        super("zhuchangfen");
        l.setIcon(new ImageIcon("src/ChangFen.jpg"));
        this.add(l);
        this.setLocation(30,30);
        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void cooking(){
        this.setVisible(true);
    }
}
class HunTunChef extends JFrame{
    private static final long serialVersionUID=1L;
    JLabel l=new JLabel();
    HunTunChef(){
        super("zhuhundun");
        l.setIcon(new ImageIcon("src/HunTun.jpg"));
        this.add(l);
        this.setLocation(350,50);
        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void cooking(){
        this.setVisible(true);
    }
}
class HeFenChef extends JFrame{
    private static final long serialVersionUID=1L;
    JLabel l=new JLabel();
    HeFenChef(){
        super("zhuhefen");
        l.setIcon(new ImageIcon("src/HeFen.jpg"));
        this.add(l);
        this.setLocation(200,280);
        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void cooking(){
        this.setVisible(true);
    }
}