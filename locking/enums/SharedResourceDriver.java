package locking.enums;

public class SharedResourceDriver {
    public static void main(String[] args) {
        Thread t1 = new Thread(()-> SharedResource.INSTANCE.readResource());
        Thread t2 = new Thread(() -> SharedResource.INSTANCE.readResource());
        Thread t3 = new Thread(SharedResource.INSTANCE::updateResource);
        Thread t4 = new Thread(SharedResource.INSTANCE::updateResource);
        Thread t5 = new Thread(SharedResource.INSTANCE::readResource);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
