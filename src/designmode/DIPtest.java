package designmode;

public class DIPtest {
    public static void main(String[] args){
        Customer wang=new Customer();
        System.out.println("gukegoumaiyixiashangpin: ");
        wang.shopping(new ShaoguanShaop());
        wang.shopping(new WuyuanShop());
    }
}

interface Shop{
    public String sell();
}

class ShaoguanShaop implements Shop{
    public String sell(){
        return "xianggu muer";
    }
}

class WuyuanShop implements Shop{
    public String sell(){
        return "lvcha jiucaoyu";
    }
}

class Customer{
    public void shopping(Shop shop){
        System.out.println(shop.sell());
    }
}
