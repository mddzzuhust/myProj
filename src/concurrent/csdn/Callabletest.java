package concurrent.csdn;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Callabletest {
    public static void main(String[] args){
        MyCallable myCallable = new MyCallable();
        FutureTask<Integer> ft = new FutureTask<Integer>(myCallable);

        for(int i=0;i<100;i++){
            if(i==30){
                Thread thread = new Thread(ft);
                thread.start();
            }
        }
        try {
            System.out.println(ft.get());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
class MyCallable implements Callable<Integer>{
    int sum=0;
    @Override
    public Integer call() {
        for (int i = 0; i < 100; i++) {
            sum = sum+i;
        }
        return sum;
    }
}