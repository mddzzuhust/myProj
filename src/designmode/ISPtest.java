public class ISPtest {
    public static void main(String[] args){
        InputModule input=StuScoreList.getInputModule();
        CountModule count=StuScoreList.getCountModule();
        PrintModule print=StuScoreList.getPrintModule();
        input.insert();
        count.countTotalScore();
        print.printStuInfo();
    }
}
interface InputModule{
    void insert();
    void delete();
    void modify();
}

interface CountModule{
    void countTotalScore();
    void countAverage();
}

interface PrintModule{
    void printStuInfo();
    void queryStuInfo();
}

class StuScoreList implements InputModule,CountModule,PrintModule{
    private StuScoreList() {}
    public static InputModule getInputModule(){
        return (InputModule)new StuScoreList();
    }
    public static CountModule getCountModule(){
        return (CountModule)new StuScoreList();
    }
    public static PrintModule getPrintModule(){
        return (PrintModule)new StuScoreList();
    }
    public void insert(){
        System.out.println("insert()");
    }
    public void delete(){
        System.out.println("delete()");
    }
    public void modify(){
        System.out.println("modify()");
    }
    public void countTotalScore(){
        System.out.println("countTotalScore()");
    }
    public void countAverage(){
        System.out.println("countAverage");
    }
    public void printStuInfo(){
        System.out.println("printStuInfo()");
    }
    public void queryStuInfo(){
        System.out.println("queryStuInfo()");
    }
}
