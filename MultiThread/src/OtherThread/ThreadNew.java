package OtherThread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author Neo
 * @since 09/20/2020-12:44 AM
 */

class CallableThread implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": Current number is " + i);
                sum += i;
            }
        }
        return sum;
    }
}

public class ThreadNew {

    public static void main(String[] args) {
        CallableThread thread = new CallableThread();
        FutureTask<Integer> futureTask = new FutureTask<>(thread);
        new Thread(futureTask).start();

        try {
            int sum = futureTask.get();
            System.out.println(Thread.currentThread().getName() + ": The sum is " + sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
