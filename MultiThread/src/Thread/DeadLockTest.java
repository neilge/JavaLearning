package Thread;

/**
 *
 * 不同线程分别占用对方需要的同步资源不放弃, 都在等待对方放弃自己需要的同步资源, 就形成了线程的死锁.
 * 出现死锁后, 不会出现异常, 不会出现提示, 只是所有的线程都处于阻塞状态, 无法继续.
 *
 * @author Neo
 * @since 09/19/2020-4:27 PM
 */
public class DeadLockTest {
    public static void main(String[] args) {

        StringBuffer s1 = new StringBuffer();
        StringBuffer s2 = new StringBuffer();

        new Thread() {
            @Override
            public void run() {
                synchronized (s1) {

                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    s1.append("a");
                    s2.append("1");

                    synchronized (s2) {
                        s1.append("b");
                        s2.append("2");

                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                synchronized (s2) {

                    try {
                        sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    s1.append("c");
                    s2.append("3");

                    synchronized (s1) {
                        s1.append("d");
                        s2.append("4");

                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
        }.start();
    }
}
