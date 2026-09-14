package locking.stampedlock;

import java.util.concurrent.locks.StampedLock;

public class StampedLockDriver {
    public static void main(String[] args) {
        StampedSharedResource resource = new StampedSharedResource();
        StampedLock lock = new StampedLock();

        Thread th1 = new Thread(()-> resource.read(lock));
        Thread th2 = new Thread(()-> resource.write(lock));
        Thread th3 = new Thread(()-> resource.read(lock));

        th1.start();
        th2.start();
        th3.start();


        OptimisticLockExampleResource resource1 = new OptimisticLockExampleResource();
        StampedLock lock1 = new StampedLock();

        Thread t1 = new Thread(()-> resource1.readAndUpdate(lock1));
        Thread t2 = new Thread(()-> resource1.readAndUpdate(lock1));
        Thread t3 = new Thread(()-> resource1.write(lock1));

        t1.start();
        t2.start();
        t3.start();
    }

}
