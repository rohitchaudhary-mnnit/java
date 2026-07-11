package locking.readwritelockk;

import java.util.concurrent.locks.ReadWriteLock;

public class ReadWriteSharedResource {
    /**
     * ReadLock: More than 1 thread can acquire readLock
     * WriteLock: Only 1 thread can acquire writeLock
     */

    boolean isAvailable = true;
    int x = 5;
    public void readResource(ReadWriteLock lock) {
        lock.readLock().lock();
        try {
            System.out.println("Lock is acquired by thread: " + Thread.currentThread().getName());
            isAvailable = false;
            System.out.println("Read value: "+x);
            Thread.sleep(6000);
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        } finally {
            lock.readLock().unlock();
            isAvailable = true;
            System.out.println("Read Lock is released by thread: " + Thread.currentThread().getName());
        }
    }

    public void writeResource(ReadWriteLock lock) {
        lock.writeLock().lock();
        try {
            System.out.println("Lock is acquired by thread: " + Thread.currentThread().getName());
            isAvailable = false;
            x = 6;
            System.out.println("Updated value: "+x);
            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        } finally {
            lock.writeLock().unlock();
            isAvailable = true;
            System.out.println("Write Lock is released by thread: " + Thread.currentThread().getName());
        }
    }
}
