package concurrent;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RWSample {
    private final Map<String, String> m = new TreeMap<>();
    private final ReentrantReadWriteLock rw1 = new ReentrantReadWriteLock();
    private final Lock r = rw1.readLock();
    private final Lock w = rw1.writeLock();
    public String get(String key){
        r.lock();
        System.out.println("读锁锁定! ");
        try {
            return m.get(key);
        }finally {
            r.unlock();
        }
    }

    public String put(String key, String entry){
        w.lock();
        System.out.println("写锁锁定! ");
        try {
            return m.put(key, entry);
        }finally {
            w.unlock();
        }
    }
}
