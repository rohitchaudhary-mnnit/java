package threadpool.workstealingpool;

import java.util.concurrent.*;

public class ComputeSumTaskDriver {
    public static void main(String[] args) {
        ForkJoinPool stealingPool = (ForkJoinPool) Executors.newWorkStealingPool();
        ComputeSumTask taskA = new ComputeSumTask(1, 10);
        //Using Future
        Future<Integer> result = stealingPool.submit(taskA);
        try {
            System.out.println("Final Sum: " +result.get());
        } catch (Exception e) {
            e.printStackTrace();
        }


        ComputeSumTask taskB = new ComputeSumTask(1, 20);
        //using CompletableFuture
        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(()->{
            return taskB.compute();
            }, stealingPool);
        //Above statement using lambda expression
        //CompletableFuture<Integer> future = CompletableFuture.supplyAsync(taskB::compute, stealingPool);
        try {
            System.out.println("Final Sum: " +future.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
