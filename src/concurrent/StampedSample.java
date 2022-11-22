package concurrent;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.concurrent.locks.StampedLock;

public class StampedSample {
    private final StampedLock s1 = new StampedLock();

    void mutate(){
        long stamp = s1.writeLock();
        try {
            System.out.println("写锁");
        }finally {
            s1.unlock(stamp);
        }
    }

    Date access(){
        long stamp = s1.tryOptimisticRead();
        Date date = new Date();
        if(s1.validate(stamp)){
            stamp = s1.readLock();
            try {
                date = new Date();
            }finally {
                s1.unlockRead(stamp);
            }
        }
        return date;
    }
}
