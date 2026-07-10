package locking.reentrant;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantSharedResource {
    boolean isAvailable;
    public void producer(ReentrantLock lock) {
        lock.lock();
        try {
            System.out.println("Lock is acquired by thead: " + Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(6000);
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }
        finally {
            lock.unlock();
            isAvailable = false;
            System.out.println("Lock is released by thread: " + Thread.currentThread().getName());
        }
    }
}
