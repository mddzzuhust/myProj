package designmode;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class DatingPlatform {
    public static void main(String[] args){
        Medium md=new EstateMedium();
        Customer1 member1,member2;
        member1=new Seller("巧贵妈");
        member2=new Buyer("巧贵爸");
        md.register(member1);
        md.register(member2);
    }
}
interface Medium{
    void register(Customer1 member);
    void relay(String form,String ad);
}
class EstateMedium implements Medium{
    private List<Customer1> members=new ArrayList<Customer1>();
    public void register(Customer1 member){
        if(!members.contains(member)){
            members.add(member);
            member.setMedium(this);
        }
    }
    public void relay(String from,String ad){
        for(Customer1 ob:members){
            String name=ob.getName();
            if(!name.equals(from)){
                ((Customer1)ob).receive(from,ad);
            }
        }
    }
}
abstract class Customer1 extends JFrame implements ActionListener{
    private static final long serialVersionUID=-7219939540794786080L;
    protected Medium medium;
    protected String name;
    JTextField SentText;
    JTextArea ReceiveArea;
    public Customer1(String name){
        super(name);
        this.name=name;
    }
    void ClientWindow(int x,int y){
        Container cp;
        JScrollPane sp;
        JPanel p1,p2;
        cp=this.getContentPane();
        SentText=new JTextField(18);
        ReceiveArea=new JTextArea(10,18);
        ReceiveArea.setEditable(false);
        p1=new JPanel();
        p1.setBorder(BorderFactory.createTitledBorder("聊天内容"));
        p1.add(ReceiveArea);
        sp=new JScrollPane(p1);
        cp.add(sp,BorderLayout.NORTH);
        p2=new JPanel();
        p2.setBorder(BorderFactory.createTitledBorder("请输入聊天信息"));
        p2.add(SentText);
        cp.add(p2,BorderLayout.SOUTH);
        SentText.addActionListener(this);
        this.setLocation(x,y);
        this.setSize(250,330);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        String tempInfo=SentText.getText().trim();
        SentText.setText("");
        this.send(tempInfo);
    }
    public String getName(){
        return name;
    }
    public void setMedium(Medium medium){
        this.medium=medium;
    }
    public abstract void send(String ad);
    public abstract void receive(String from,String ad);
}
class Seller extends Customer1{
    private static final long serialVersionUID=-1443076716629516027L;
    public Seller(String name){
        super(name);
        ClientWindow(50,100);
    }
    public void send(String ad){
        ReceiveArea.append("maifang"+ad+"\n");
        ReceiveArea.setCaretPosition(ReceiveArea.getText().length());
        medium.relay(name,ad);
    }
    public void receive(String from,String ad){
        ReceiveArea.append(from+"shuo: "+ad+"\n");
        ReceiveArea.setCaretPosition(ReceiveArea.getText().length());
    }
}
class Buyer extends Customer1{
    private static final long serialVersionUID= -474879276076308825L;
    public Buyer(String name){
        super(name);
        ClientWindow(350,100);
    }
    public void send(String ad){
        ReceiveArea.setCaretPosition(ReceiveArea.getText().length());
        medium.relay(name,ad);
    }
    public void receive(String from,String ad){
        ReceiveArea.append(from+"shuo:"+ad+"\n");
        ReceiveArea.setCaretPosition(ReceiveArea.getText().length());
    }
}
