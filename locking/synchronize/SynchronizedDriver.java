package locking.synchronize;

public class SynchronizedDriver {

    public static void main(String[] args) {
        SharedResource resource1 = new SharedResource();
        //th1 acquires a lock
        Thread th1 = new Thread(()-> {
            resource1.producer();
        });
        //th2 also acquires a lock via different object.
        //solution to this is custom locks like Reentrant lock, ReadWriteLock, Stamped Lock
        SharedResource resource2 = new SharedResource();
        Thread th2 = new Thread(() -> {
            resource2.producer();
        });

        th1.start();
        th2.start();
    }
}
