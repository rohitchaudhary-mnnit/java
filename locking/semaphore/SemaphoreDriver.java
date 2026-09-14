package locking.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreDriver {
    public static void main(String[] args) {
        SharedResource sharedResource1 = new SharedResource();
        Semaphore lock = new Semaphore(2, true);

        Thread thread1 = new Thread(()-> sharedResource1.produce(lock));
        Thread thread2 = new Thread(()-> sharedResource1.produce(lock));
        Thread thread3 = new Thread(()-> sharedResource1.produce(lock));
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
