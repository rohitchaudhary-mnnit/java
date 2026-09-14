package locking.stampedlock;

import java.util.concurrent.locks.StampedLock;

public class OptimisticLockExampleResource {
    boolean isAvailable = true;
    int x = 5;

    public void readAndUpdate(StampedLock lock) {
        long stamp = lock.tryOptimisticRead();
        System.out.println("Optimistic read lock acquired by thread: "+ Thread.currentThread().getName());
        try {
            isAvailable = false;
            System.out.println("Read value: "+ x +" by thread: "+ Thread.currentThread().getName());
            Thread.sleep(4000);
            x = 20;
            if(lock.validate(stamp)) {
                System.out.println("Updated value successfully "+x);
            } else {
                System.out.println("Performing roll back activity for thread: "+Thread.currentThread().getName());
                x = 5;
            }
        } catch (Exception e) {
            System.out.println("Exception occurred: "+ e.getMessage());
        } finally {
            System.out.println("Optimistic read lock released by thread: "+ Thread.currentThread().getName());
            isAvailable = true;
        }
    }

    public void write(StampedLock lock) {
        long stamp = lock.writeLock();
        try {
            System.out.println("Stamped write lock acquired by thread: "+ Thread.currentThread().getName());
            isAvailable = false;
            Thread.sleep(6000);
            x = 10;
            System.out.println("Updated value: "+x);
        } catch (Exception e) {
            System.out.println("Exception occurred: "+ e.getMessage());
        } finally {
            lock.unlockWrite(stamp);
            System.out.println("Stamped write lock released by thread: "+ Thread.currentThread().getName());
            isAvailable = true;
        }
    }
}
