package designmode;

import java.util.ArrayList;

public class ShoppingTest {
    public static void main(String[] args){
        float s=0;
        Bags BigBag,mediumBag,smallRedBag,smallWhiteBag;
        Goods sp;
        BigBag=new Bags("dadaizi");
        mediumBag=new Bags("zhongdaizi");
        smallRedBag=new Bags("hongsexiaodaizi");
        smallWhiteBag=new Bags("baisexiaodaizi");
        sp=new Goods("wuyuantechan",2,7.9f);
        smallRedBag.add(sp);
        sp=new Goods("wuyuanditu",1,9.9f);
        smallRedBag.add(sp);
        sp=new Goods("shaoguanxianggu",2,68);
        smallWhiteBag.add(sp);
        sp=new Goods("shaoguanhongcha",3,180);
        smallWhiteBag.add(sp);
        sp=new Goods("jingdezhenciqi",1,380);
        mediumBag.add(sp);
        mediumBag.add(smallRedBag);
        sp=new Goods("liningpaiyundongxie",1,198);
        BigBag.add(sp);
        BigBag.add(smallWhiteBag);
        BigBag.add(mediumBag);
        System.out.println("ninxuangoudeshangpinyou: ");
        BigBag.show();
        s=BigBag.calculation();
        System.out.println("zongjiashi: "+s);
    }
}
interface Articles{
    public float calculation();
    public void show();
}
class Goods implements Articles{
    private String name;
    private int quantity;
    private float unitPrice;
    public Goods(String name,int quantity,float unitPrice){
        this.name=name;
        this.quantity=quantity;
        this.unitPrice=unitPrice;
    }
    public float calculation(){
        return quantity*unitPrice;
    }
    public void show(){
        System.out.println(name+"shuliang: "+quantity+"danjia: "+unitPrice+" yuan");
    }
}

class Bags implements Articles{
    private String name;
    private ArrayList<Articles> bags=new ArrayList<Articles>();
    public Bags(String name){
        this.name=name;
    }
    public void add(Articles c){
        bags.add(c);
    }
    public void remove(Articles c){
        bags.remove(c);
    }
    public Articles getChild(int i){
        return bags.get(i);
    }
    public float calculation(){
        float s=0;
        for(Object obj:bags){
            s+=((Articles)obj).calculation();
        }
        return s;
    }
    public void show(){
        for(Object obj:bags){
            ((Articles)obj).show();
        }
    }
}