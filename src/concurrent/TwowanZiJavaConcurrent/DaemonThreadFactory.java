package concurrent.TwowanZiJavaConcurrent;

import java.util.concurrent.ThreadFactory;

public class DaemonThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r){
        Thread t = new Thread();
        t.setDaemon(true);
        return t;
    }
}
