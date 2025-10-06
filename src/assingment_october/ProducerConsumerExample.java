package assingment_october;


import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ArrayBlockingQueue;

// Producer class
class Producer implements Runnable {
    private BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            int value = 0;
            while (true) {
                System.out.println("Produced: " + value);
                queue.put(value); // puts item in queue (waits if full)
                value++;
                Thread.sleep(500); // simulate delay
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

// Consumer class
class Consumer implements Runnable {
    private BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                int value = queue.take(); // takes item from queue (waits if empty)
                System.out.println("Consumed: " + value);
                Thread.sleep(1000); // simulate delay
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

public class ProducerConsumerExample {
    public static void main(String[] args) {
        // Shared buffer of size 5
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);

        // Create Producer and Consumer
        Thread producerThread = new Thread(new Producer(queue));
        Thread consumerThread = new Thread(new Consumer(queue));

        // Start threads
        producerThread.start();
        consumerThread.start();
    }
}