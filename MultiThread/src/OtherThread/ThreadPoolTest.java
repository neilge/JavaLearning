package OtherThread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Neo
 * @since 09/20/2020-1:02 AM
 */

class EvenNumber implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}

class OddNumber implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 1) System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}

public class ThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);
        service.execute(new EvenNumber()); // 适用于Runnable
        service.execute(new OddNumber());
//        service.submit(); // 适用于Callable
        service.shutdown();
    }
}
