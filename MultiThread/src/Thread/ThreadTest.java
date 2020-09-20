package Thread;

/**
 * 多线程的创建
 * 方式一: 继承Thread类
 * 1. 创建一个继承于Thread类的子类
 * 2. 重写Thread类的run方法
 * 3. 创建Thread类的子类对象
 * 4. 调用Thread的start方法
 *
 * 方式二: 实现Runnable 接口
 * 1. 创建一个实现Runnable接口的类
 * 2. 实现类去实现Runnable中的方法run()
 * 3. 创建实现类对象
 * 4. 将此对象作为参数传递到Thread的构造器中, 创建Thread类对象
 * 5. 通过Thread类的对象调用start()
 *
 * Runnable 首先没有类的单继承的局限性, 而且适合共享数据, 所以优先选择这种方式
 *
 *  @author Neo
 * @since 09/18/2020-12:04 PM
 */

class ExtendedThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

class RunnableThread implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        // 方法一
        ExtendedThread t1 = new ExtendedThread();
        t1.start();
//        t1.run(); // 如果直接调用run,则并没有启动一个新的线程,而仍然为主线程.

        // 方法二
       Thread t2 = new Thread(new RunnableThread());
        t2.start();

       for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i + "**");
            }
        }


    }
}
