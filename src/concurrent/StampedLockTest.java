package concurrent;

import java.util.concurrent.locks.StampedLock;

/**
 * 所有获取锁的方法，都返回一个邮戳（Stamp），Stamp为0表示获取失败，其余都表示成功；
 * 所有释放锁的方法，都需要一个邮戳（Stamp），这个Stamp必须是和成功获取锁时得到的Stamp一致；
 * StampedLock是不可重入的；（如果一个线程已经持有了写锁，再去获取写锁的话就会造成死锁）
 * StampedLock支持读锁和写锁的相互转换，即支持升降级
 * 无论写锁还是读锁，都不支持Conditon等待
 */
public class StampedLockTest {
    static byte[] bytes = new byte[20];
    static java.util.concurrent.locks.StampedLock lock = new java.util.concurrent.locks.StampedLock();

    //写方法
    static void stWrite() {
        long stamp = lock.writeLock();
        try {
            for (int i = 0; i < bytes.length; i++) {
                bytes[i]++;
                if (bytes[i] >= 127)
                    bytes[i] = 0;
            }
        } finally {
//If the lock state matches the given stamp, releases the corresponding mode of the lock. 这是一段官方注释，大概意思是：如果锁定状态与给定的戳匹配，则释放相应的锁定模式。
            lock.unlockWrite(stamp);
        }
    }

    /*
     乐观读，虽然不能保证数据是最新的，释放锁操作数据的时候是操作的一份副本，
     其他线程在这个时候可能会对原数据改写，但能保证数据的一致性。
     */
    static void optimisticRead() {
        long stamp = lock.tryOptimisticRead();
        byte[] cpb = new byte[bytes.length];
        for (int i = 0; i < bytes.length; i++) { //乐观读，必须先拷贝一份数据到在方法中
            cpb[i] = bytes[i];
        }
        if (!lock.validate(stamp)) {//检查在拷贝过程中有没有排他锁抢占，如果有则悲观读
            try {
                stamp = lock.readLock();
                for (int i = 0; i < bytes.length; i++) { //拷贝到方法栈中供释放锁后使用
                    cpb[i] = bytes[i];
                }
            } finally {
                lock.unlockRead(stamp);
            }
        }
        System.out.println();
        for (byte b : cpb) {
            System.out.printf("%3s", Integer.toHexString(b).toUpperCase());
        }
    }

    //锁升级
    static void lockUpgrade() {
        long stamp = lock.readLock();
        try {
            while (bytes[0] == 0) { //如果值为0，则全部写成7E
                long ws = lock.tryConvertToWriteLock(stamp);//升级写锁
                if (ws != 0L) {//升级成功
                    stamp = ws;
                    for (int i = 0; i < bytes.length; i++) {
                        bytes[i] = 126; //7E
                    }
                    break;
                } else {//升级失败
                    lock.unlockRead(stamp);//释放读锁
                    stamp = lock.writeLock();//显式获取写锁
                }
            }
        } finally {
            lock.unlock(stamp);
        }
    }


    //测试
    public static void main(String[] args) {
        //写线程
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                stWrite();
            }
        }).start();
        //读线程
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                optimisticRead();
            }
        }).start();
        //测试锁升级
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                lockUpgrade();
            }
        }).start();

    }
}