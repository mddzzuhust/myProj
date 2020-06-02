import java.util.ArrayList;
import java.util.List;

public class RMBrateTest {
    public static void main(String[] args){
        Rate rate=new RMBrate();
        Company watcher1=new ImportCompany();
        Company watcher2=new ExportCompany();
        rate.add(watcher1);
        rate.add(watcher2);
        rate.change(10);
        rate.change(-9);
    }
}
abstract class Rate{
    protected List<Company> companys=new ArrayList<Company>();
    public void add(Company company){
        companys.add(company);
    }
    public void remove(Company company){
        companys.remove(company);
    }
    public abstract void change(int number);
}
class RMBrate extends Rate{
    public void change(int number){
        for(Company obs:companys){
            ((Company)obs).response(number);
        }
    }
}
interface Company{
    void response(int number);
}
class ImportCompany implements Company{
    public void response(int number){
        if(number>0){
            System.out.println("人民币汇率升值"+number+"个基点，降低了进口产品成本，提升了进口公司利润率。");
        }else if(number<0){
            System.out.println("人民币汇率贬值"+(-number)+"个基点，提升了进口产品成本，降低了进口公司利润率。");
        }
    }
}
class ExportCompany implements Company{
    public void response(int number){
        if(number>0){
            System.out.println("人民币汇率升值"+number+"个基点，降低了出口产品收入，降低了出口公司的销售利润率。");
        }else if(number<0){
            System.out.println("人民币汇率贬值"+(-number)+"个基点，提升了出口产品收入，提升了出口公司的销售利润率。");
        }
    }
}
