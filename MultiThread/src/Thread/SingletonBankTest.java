package Thread;

/**
 * 使用同步机制将单例模式的懒汉式改写为线程安全的.
 *
 * @author Neo
 * @since 09/18/2020-11:45 PM
 */

class Bank {
    private Bank() {}

    private static Bank instance = null;

//    public static synchronized Bank getInstance() {
//        if (instance == null) {
//            instance = new Bank();
//        }
//        return instance;
//    }

    public static Bank getInstance() {
        if(instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}

public class SingletonBankTest {
}
