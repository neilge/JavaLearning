package ThreadCommunication;

/**
 * @author Neo
 * @since 09/19/2020-11:55 PM
 */

class ProductFactory {

    private int numProduct = 0;

    public synchronized void produceProduct() {
        if (numProduct < 20) {
            System.out.println(Thread.currentThread().getName() + ": produce product " + ++numProduct);
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void consumeProduct() {
        if (numProduct > 0) {
            System.out.println(Thread.currentThread().getName() + ": consume product " + numProduct--);
            notify();
        } else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer extends Thread {

    ProductFactory factory;

    public Producer(ProductFactory factory) {
        this.factory = factory;
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            factory.produceProduct();
        }
    }
}

class Consumer extends Thread {

    ProductFactory factory;

    public Consumer(ProductFactory factory) {
        this.factory = factory;
    }

    @Override
    public void run() {
        while (true) {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            factory.consumeProduct();
        }
    }
}

public class ProducerConsumerTest {
    public static void main(String[] args) {
        ProductFactory factory = new ProductFactory();
        Producer producer = new Producer(factory);
        Consumer consumer1 = new Consumer(factory);
        Consumer consumer2 = new Consumer(factory);

        producer.setName("Producer1");
        consumer1.setName("Consumer1");
        consumer2.setName("Consumer2");

        producer.start();
        consumer1.start();
        consumer2.start();
    }
}
