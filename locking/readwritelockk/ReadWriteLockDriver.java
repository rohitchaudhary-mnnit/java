package locking.readwritelockk;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockDriver {
    public static void main(String[] args) {
        ReadWriteSharedResource resource1 = new ReadWriteSharedResource();
        ReadWriteLock lock = new ReentrantReadWriteLock();

         Thread t1 = new Thread(()-> resource1.readResource(lock));


        ReadWriteSharedResource resource2 = new ReadWriteSharedResource();
         Thread t2 = new Thread(() ->
             resource2.readResource(lock)
         );

        ReadWriteSharedResource resource3 = new ReadWriteSharedResource();
        Thread t3 = new Thread(() ->
            resource3.writeResource(lock)
        );

        t1.start();
        t2.start();
        t3.start();
    }
}

