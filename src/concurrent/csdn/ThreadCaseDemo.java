package concurrent.csdn;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Info2{
    private String name = "name";
    private String content = "content";
    private boolean flag = true;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void set(String name,String content){
        lock.lock();
        try {
            while (!flag){
                condition.await();
            }
            this.setName(name);
            Thread.sleep(300);
            this.setContent(content);
            flag = false;
            condition.signal();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void get(){
        lock.lock();
        try {
            while (flag){
                condition.await();
            }
            Thread.sleep(300);
            System.out.println(this.getName() +
                    " --> " + this.getContent());
            flag = true;
            condition.signal();
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content){
        this.content = content;
    }
}

class Producer2 implements Runnable{
    private Info2 info = null;
    public Producer2(Info2 info){
        this.info = info;
    }
    public void run(){
        boolean flag = true;
        for (int i = 0; i < 10; i++) {
            if(flag){
                this.info.set("姓名--1","内容--1");
                flag = false;
            }else {
                this.info.set("姓名--2","内容--2");
                flag = true;
            }
        }
    }
}

class Consumer2 implements Runnable{
    private Info2 info = null;
    public Consumer2(Info2 info){
        this.info = info;
    }
    public void run(){
        for (int i = 0; i < 10; i++) {
            this.info.get();
        }
    }
}
public class ThreadCaseDemo {
    public static void main(String[] args) {
        Info2 info2 = new Info2();
        Producer2 pro = new Producer2(info2);
        Consumer2 con = new Consumer2(info2);
        new Thread(pro).start();

        try {
            Thread.sleep(500);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        new Thread(con).start();
    }
}