package concurrent.csdn;

public class MissedNotifyFix extends Object {
    private Object proceedLock;

    //该标志位用来指示线程是否需要等待
    private boolean okToProceed;

    public MissedNotifyFix(){
        print("in MissedNotify");
        proceedLock = new Object();
//先设置为false
        okToProceed = false;
    }

    public void waitToProceed() throws InterruptedException{
        print("in waitToProceed() - entered");

        synchronized (proceedLock){
            print("in waitToProceed() - entered sync block");
//while循环判断，这里不用if的原因是为了防止早期通知
            while (okToProceed == false){
                print("in waitToProceed() - about to wait()");
                proceedLock.wait();
                print("in waitToProceed() - leaving sync block");
            }
        }

        print("in waitToProceed() - leaving");
    }

    public void proceed(){
        print("in proceed() - entered");

        synchronized (proceedLock){
            print("in proceed() - changed okToProceed to true");
//通知之前，将其设置为true，这样即使出现通知遗漏的情况，也不会使线程在wait出阻塞
            okToProceed = true;
            proceedLock.notifyAll();
            print("in proceed() - just did notifyAll()");
            print("in proceed() - leaving sync block");
        }
        print("in proceed - leaving");
    }

    private static void print(String msg){
        String name = Thread.currentThread().getName();
        System.out.println(name + ": " + msg);
    }

    public static void main(String[] args) {
        final MissedNotifyFix mnf = new MissedNotifyFix();

        Runnable runA = new Runnable() {
            @Override
            public void run() {
                try {
//休眠1000ms，大于runB中的500ms，
//是为了后调用waitToProceed，从而先notifyAll，后wait，
                    Thread.sleep(1000);
                    mnf.waitToProceed();
                }catch (InterruptedException x){

                }
            }
        };

        Thread threadA = new Thread(runA,"threadA");
        threadA.start();

        Runnable runB = new Runnable() {
            @Override
            public void run() {
                try {
//休眠500ms，小于runA中的1000ms，
//是为了先调用proceed，从而先notifyAll，后wait
                    Thread.sleep(500);
                    mnf.proceed();
                }catch (InterruptedException x){

                }
            }
        };

        Thread threadB = new Thread(runB,"threadB");
        threadB.start();

        try {
            Thread.sleep(10000);
        }catch (InterruptedException x){

        }

        print("about to invoke interrupt() on threadA");
        threadA.interrupt();
    }
}
//注意代码中加了注释的部分，在threadB进行通知之前，先将okToProceed置为true，这样如果threadA将通知遗漏，
// 那么就不会进入while循环，也便不会执行wait方法，线程也就不会阻塞。
// 如果通知没有被遗漏，wait方法返回后，okToProceed已经被置为true，下次while循环判断条件不成立，便会退出循环。
// 这样，通过标志位和wait、notifyAll的配合使用，便避免了通知遗漏而造成的阻塞问题。

// 总结：在使用线程的等待/通知机制时，一般都要配合一个boolean变量值（或者其他能够判断真假的条件），
// 在notify之前改变该boolean变量的值，让wait返回后能够退出while循环（一般都要在wait方法外围加一层while循环，以防止早期通知），
// 或在通知被遗漏后，不会被阻塞在wait方法处。这样便保证了程序的正确性。