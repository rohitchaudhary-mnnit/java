package threadpool.workstealingpool;

import java.util.concurrent.RecursiveTask;

public class ComputeSumTask extends RecursiveTask<Integer> {
    private int start;
    private int end;

    public ComputeSumTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        if(end - start <= 5) {
            int totalSum = 0;
            for(int i=start; i<=end; i++) {
                totalSum+=i;
            }
            return totalSum;
        } else {
            int mid = start + (end - start)/2;
            ComputeSumTask task1 = new ComputeSumTask(start, mid);
            ComputeSumTask task2 = new ComputeSumTask(mid+1, end);

            task1.fork();
            task2.fork();

            int sum1 = task1.join();
            int sum2 = task2.join();
            return sum1+sum2;
        }
    }
}
