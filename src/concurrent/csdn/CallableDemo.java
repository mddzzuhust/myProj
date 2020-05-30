package concurrent.csdn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

// 在Java 5之后，任务分两类：一类是实现了Runnable接口的类，一类是实现了Callable接口的类。
// 两者都可以被ExecutorService执行，但是Runnable任务没有返回值，而Callable任务有返回值。
// 并且Callable的call()方法只能通过ExecutorService的submit(Callable<T> task) 方法来执行，
// 并且返回一个 <T>Future<T>，是表示任务等待完成的 Future。
//Callable接口类似于Runnable，两者都是为那些其实例可能被另一个线程执行的类设计的。
// 但是 Runnable 不会返回结果，并且无法抛出经过检查的异常而Callable又返回结果，
// 而且当获取返回结果时可能会抛出异常。Callable中的call()方法类似Runnable的run()方法，区别同样是有返回值，后者没有。
//当将一个Callable的对象传递给ExecutorService的submit方法，则该call方法自动在一个线程上执行，
// 并且会返回执行结果Future对象。同样，将Runnable的对象传递给ExecutorService的submit方法，
// 则该run方法自动在一个线程上执行，并且会返回执行结果Future对象，但是在该Future对象上调用get方法，将返回null。

public class CallableDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> resultList = new ArrayList<Future<String>>();

        for (int i = 0; i < 10; i++) {
            Future<String> future = executorService.submit(new TaskWithResult(i));
            resultList.add(future);
        }

        for(Future<String> fs : resultList){
            try {
                while (!fs.isDone());
                System.out.println(fs.get());
            }catch (InterruptedException e){
                e.printStackTrace();
            }catch (ExecutionException e){
                e.printStackTrace();
            }finally {
                executorService.shutdown();
            }
        }
    }
}

class TaskWithResult implements Callable<String>{
    private int id;

    public TaskWithResult(int id){
        this.id = id;
    }

    public String call() throws Exception{
        System.out.println("call()方法被自动调用！！！"+Thread.currentThread().getName());
        return "call()方法被自动调用，任务返回的结果是："+id+" " + Thread.currentThread().getName();
    }
}

//从结果中可以同样可以看出，submit也是首先选择空闲线程来执行任务，如果没有，才会创建新的线程来执行任务。
// 另外，需要注意：如果Future的返回尚未完成，则get（）方法会阻塞等待，直到Future完成返回，
// 可以通过调用isDone（）方法判断Future是否完成了返回。