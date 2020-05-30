package lambda;

interface Displayable{
    void display();

    default int add(int a,int b){
        return a+b;
    }
}
public class LambdaAndInner {
    private int age=12;
    private static String name="Czhongwenwang";

    public void test(){
        String url="abc";
        Displayable dis= ()->{
            System.out.println(url);
            System.out.println(age);
            System.out.println(name);
        };
        dis.display();
        System.out.println(dis.add(3,5));
    }

    public static void main(String[] args){
        LambdaAndInner lambdaAndInner = new LambdaAndInner();
        lambdaAndInner.test();
    }
}