package locking.reentrant;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDriver {
    public static void main(String[] args) {
        ReentrantSharedResource resource1 = new ReentrantSharedResource();
        ReentrantLock lock = new ReentrantLock(true);
        //th1 acquires a lock
        Thread th1 = new Thread(()-> {
            resource1.producer(lock);
        });

        ReentrantSharedResource resource2 = new ReentrantSharedResource();
        Thread th2 = new Thread(() -> {
            resource2.producer(lock);
        });

        th1.start();
        th2.start();
    }
}
