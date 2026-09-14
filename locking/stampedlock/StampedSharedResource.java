package locking.stampedlock;

import java.util.concurrent.locks.StampedLock;

public class StampedSharedResource {
    /**
     * Supports read/write lock functionality like ReadWriteLock
     */

    boolean isAvailable = true;
    int x = 5;
    public void read(StampedLock lock) {
        long stamp = lock.readLock();
        try {
            System.out.println("Stamped read lock acquired by thread: "+ Thread.currentThread().getName());
            isAvailable = false;
            Thread.sleep(4000);
            System.out.println("Read value:"+x);
        } catch (Exception e) {
            System.out.println("Exception occurred: "+ e.getMessage());
        } finally {
            lock.unlockRead(stamp);
            System.out.println("Stamped read lock released by thread: "+ Thread.currentThread().getName());
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
