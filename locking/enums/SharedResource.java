package locking.enums;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public enum SharedResource {
    INSTANCE;
    private final ReadWriteLock lock = new ReentrantReadWriteLock();
    private int value = 5;
    private boolean isAvailable = true;

    public void readResource() {
        lock.readLock().lock();
        try {
            System.out.println("Read Lock is acquired by thread: " + Thread.currentThread().getName());
            isAvailable = false;
            System.out.println("Read resource, current value: "+value);
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Some Exception occurred: "+e.getMessage());
        } finally {
            lock.readLock().unlock();
            isAvailable = true;
            System.out.println("Read Lock is released by thread: " + Thread.currentThread().getName());
        }
    }

    public void updateResource() {
        lock.writeLock().lock();
        try {
            System.out.println("Write Lock is acquired by thread: " + Thread.currentThread().getName());
            isAvailable = false;
            value++;
            System.out.println("Updated resource, current value: "+value);
            Thread.sleep(6000);
        } catch (Exception e) {
            System.out.println("Some Exception occurred: "+e.getMessage());
        } finally {
            lock.writeLock().unlock();
            isAvailable = true;
            System.out.println("Write lock is released by thread: "+ Thread.currentThread().getName());
        }
    }

}
