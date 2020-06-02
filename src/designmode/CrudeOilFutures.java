import java.util.Observer;
import java.util.Observable;

public class CrudeOilFutures {
    public static void main(String[] args){
        OilFutures oil=new OilFutures();
        Observer bull=new Bull();
        Observer bear=new Bear();
        oil.addObserver(bull);
        oil.addObserver(bear);
        oil.setPrice(10);
        oil.setPrice(-8);
    }
}
class OilFutures extends Observable{
    private float price;
    public float getPrice(){
        return this.price;
    }
    public void setPrice(float price){
        super.setChanged();
        super.notifyObservers(price);
        this.price=price;
    }
}
class Bull implements Observer{
    public void update(Observable o,Object arg){
        Float price=((Float)arg).floatValue();
        if(price>0){
            System.out.println("youjiashangzhang"+price);
        }else {
            System.out.println("youjiaxiadie"+price);
        }
    }
}
class Bear implements Observer{
    public void update(Observable o,Object arg){
        Float price=((Float)arg).floatValue();
        if(price>0){
            System.out.println("youjiashangzhang:"+price);
        }else {
            System.out.println("youjiaxiadie"+price);
        }
    }
}
