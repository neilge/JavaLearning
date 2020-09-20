package Thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Neo
 * @since 09/18/2020-4:23 PM
 *
 * <p>
 * 方式一: 同步代码块
 * synchronized(同步监视器(锁: 可以是任何类的对象, 多个线程共用一个)) {
 * //需要被同步的代码 (操作共享数据的代码)
 * }
 * 操作同步代码时, 只能有一个线程参与,其他线程等待.相当于是一个单线程的过程,效率低.
 *
 * <p>
 * 方式二: 同步方法
 * 如果操作共享数据的代码完整的声明在一个方法中, 我们可以将方法设置为同步的.
 *
 * <p>
 * 方式三: Lock锁
 * 与synchronized有何不同?
 * synchronized执行完同步代码后, 自动释放同步监视器. lock需要手动的启用同步, 同事结束同步也需要手动实现.`
 */

class Window1 implements Runnable {
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            // 方式一
            synchronized (this) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ": sell ticket, the ticket number is " + ticket--);
                } else {
                    break;
                }
            }
        }
    }
}

class Window2 implements Runnable {
    private int ticket = 100;

    @Override
    public void run() {
        while (true) {
            // 方式二
            show();
        }
    }

    private synchronized void show() {
        if (ticket > 0)
            System.out.println(Thread.currentThread().getName() + ": sell ticket, the ticket number is " + ticket--);
    }
}

class Window3 implements Runnable {
    private int ticket = 100;

    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {

        try {
            while (true) {
                // 方式三
                lock.lock();
                if (ticket > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ": sell ticket, the ticket number is " + ticket--);
                } else {
                    break;
                }
            }
        } finally {
            lock.unlock();
        }

    }
}


public class ThreadSafeTest {

    public static void testRun(Runnable w) {
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("Window 1");
        t2.setName("Window 2");
        t3.setName("Window 3");

        t1.start();
        t2.start();
        t3.start();
    }


    public static void main(String[] args) {
//        testRun(new Window1());
//        testRun(new Window2());
        testRun(new Window3());
    }
}
