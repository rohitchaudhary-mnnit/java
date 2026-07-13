package locking.synchronize;


public class SharedResource {
    boolean isAvailable = true;

    public synchronized void producer() {
        try {
            System.out.println("Lock is acquired by " + Thread.currentThread().getName());
            isAvailable = false;
            Thread.sleep(6000);
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        } finally {
            isAvailable = true;
            System.out.println("Lock is released by thread" + Thread.currentThread().getName());
        }
    }
}

