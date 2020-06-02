import javax.swing.*;
import java.awt.*;

public class ParlourDecorator {
    public static void main(String[] args){
        try {
            Decorator d;
            d=(Decorator)ReadXML.getObject("bag");
            ProjectManager m=new ProjectManager(d);
            Parlour p=m.decorate();
            p.show();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
class Parlour{
    private String wall;
    private String TV;
    private String sofa;

    public void setWall(String wall) {
        this.wall = wall;
    }

    public void setTV(String TV) {
        this.TV = TV;
    }

    public void setSofa(String sofa) {
        this.sofa = sofa;
    }
    public void show(){
        JFrame jf=new JFrame("ceshi");
        Container contentPane=jf.getContentPane();
        JPanel p=new JPanel();
        JScrollPane sp=new JScrollPane(p);
        String parlour=wall+sofa;
        JLabel l=new JLabel(new ImageIcon("src/"+parlour+".jpg"));
        p.setLayout(new GridLayout(1,1));
        p.setBorder(BorderFactory.createTitledBorder("keting"));
        p.add(l);
        contentPane.add(sp,BorderLayout.CENTER);
        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

abstract class Decorator{
    protected Parlour product=new Parlour();
    public abstract void buildWall();
    public abstract void buildTV();
    public abstract void buildSofa();

    public Parlour getResult(){
        return product;
    }
}

class ConcreteDecorator1 extends Decorator{
    public void buildWall(){
        product.setWall("w1");
    }
    public void buildTV(){
        product.setTV("TV1");
    }
    public void buildSofa(){
        product.setSofa("sf1");
    }
}

class ConcreteDecorator2 extends Decorator{
    public void buildWall(){
        product.setWall("w2");
    }
    public void buildTV(){
        product.setTV("TV2");
    }
    public void buildSofa(){
        product.setSofa("sf2");
    }
}

class ProjectManager{
    private Decorator builder;
    public ProjectManager(Decorator builder){
        this.builder=builder;
    }
    public Parlour decorate(){
        builder.buildWall();
        builder.buildTV();
        builder.buildSofa();
        return builder.getResult();
    }
}