package locking.semaphore;

import java.util.concurrent.Semaphore;

public class SharedResource {
    boolean isAvailable=true;

    public void produce(Semaphore lock) {
        try {
            lock.acquire();
            System.out.println("Semaphore lock acquired by thread: "+Thread.currentThread().getName());
            isAvailable = false;
            Thread.sleep(4000);
        } catch (Exception e) {
            System.out.println("Exception occurred: "+e.getMessage());
        } finally {
            isAvailable = true;
            lock.release();
            System.out.println("Lock released on shared resource by thread: "+Thread.currentThread().getName());
        }
    }
}
