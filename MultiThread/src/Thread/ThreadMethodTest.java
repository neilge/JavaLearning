package Thread;

/**
 * 測試Thread中的常用方法
 *
 * 1. start() 启动当前线程, 调用当前线程run()
 * 2. run() 通常需要重写Thread类中方法, 讲创建的建成要执行的操作声明在此方法中
 * 3. currentThread() 静态方法, 返回当前代码执行的线程
 * 4. getName() 获取当前线程名字
 * 5. setName() 设置当前线程名字
 * 6. yield() 释放CPU执行权
 * 7. join() 在线程a中调用线程b的join方法,线程a就进入阻塞状态,直到线程b完全执行完后,线程a结束阻塞状态.
 * 8. sleep(long) 当前线程睡一段时间
 * 9. isAlive() 判断当前线程是否存活
 *
 * 线程的优先级
 *
 * MAX_PRIORITY = 10
 * MIN_PRIORITY = 1
 * NORM_PRIORITY = 5 (default)
 * 高优先级要抢占低优先级的执行权,但仅是从概率上讲. 高线程在高概率的情况下被执行, 并不意味着只有当高优先级执行完之后,低优先级才执行.
 *
 * @author Neo
 * @since 09/18/2020-12:42 PM
 *
 */

class HelloThread extends Thread {

    @Override
    public void run() {
        setName("Hello thread");
        for (int i = 0; i < 100; i++) {
            System.out.println(currentThread().getName() + ": " + i + ": " + currentThread().getPriority());
//            if (i % 20 == 0) {
//                try {
//                    sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }
    }
}

public class ThreadMethodTest {
    public static void main(String[] args) {

        Thread thread1 = new HelloThread();
        thread1.setPriority(Thread.MAX_PRIORITY);
        thread1.start();

        for (int i = 0; i < 100; i++) {
            Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
            System.out.println(Thread.currentThread().getName() + ": " + i + ": " + Thread.currentThread().getPriority());
//            if (i == 20) {
//                try {
//                    thread1.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
        }

        System.out.println(thread1.isAlive());
    }
}
