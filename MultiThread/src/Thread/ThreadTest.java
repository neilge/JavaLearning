package Thread;

import javax.sound.midi.Soundbank;

/**
 * 多线程的创建
 * 方式一: 继承Thread类
 * 1. 创建一个继承于Thread类的子类
 * 2. 重写Thread类的run方法
 * 3. 创建Thread类的子类对象
 * 4. 调用Thread的start方法
 *
 *  @author Neo
 * @since 09/18/2020-12:04 PM
 */

class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }
}

public class ThreadTest {
    public static void main(String[] args) {
        MyThread t1 = new MyThread();
        t1.start();
//        t1.run(); // 如果直接调用run,则并没有启动一个新的线程,而仍然为主线程.

       for (int i = 0; i < 100; i++) {
            if (i % 2 == 0) {
                System.out.println(Thread.currentThread().getName() + ": " + i + "**");
            }
        }
    }
}
