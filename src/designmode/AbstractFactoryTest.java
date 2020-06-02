public class AbstractFactoryTest {
    public static void main(String[] args){
        try {
            Product a;
            AbstractFactory af;
            af=(AbstractFactory)ReadXML1.getObject();
            a=af.newProduct();
            a.show();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
interface Product{
    public void show();
}

class ConcreteProduct1 implements Product{
    public void show(){
        System.out.println("chanpin1 xianshi:");
    }
}

class ConcreteProduct2 implements Product{
    public void show(){
        System.out.println("chanpin2 xianshi:");
    }
}

interface AbstractFactory{
    public Product newProduct();
}

class ConcreteFactory1 implements AbstractFactory{
    public Product newProduct(){
        System.out.println("gongchang1-->chanpin1");
        return new ConcreteProduct1();
    }
}

class ConcreteFactory2 implements AbstractFactory{
    public Product newProduct(){
        System.out.println("gongchang2-->chanpin2");
        return new ConcreteProduct2();
    }
}