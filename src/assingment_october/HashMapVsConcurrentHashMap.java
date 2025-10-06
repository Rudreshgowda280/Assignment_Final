package assingment_october;


import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

//    Q4. Write a program to demonstrate the difference between HashMap and ConcurrentHashMap in a multithreaded environment.

public class HashMapVsConcurrentHashMap {

    // Shared resources
    static Map<Integer, String> hashMap = new HashMap<>();
    static Map<Integer, String> concurrentMap = new ConcurrentHashMap<>();

    public static void main(String[] args) throws InterruptedException {

        // --- Test with HashMap ---
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 1000; i++) {
                hashMap.put(i, "Value " + i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1001; i <= 2000; i++) {
                hashMap.put(i, "Value " + i);
            }
        });

        t1.start();
        t2.start();// start thread
        t1.join(); //Waits for the thread to finish before moving on.
        t2.join();

        System.out.println("HashMap Size (Expected 2000): " + hashMap.size());


        // --- Test with ConcurrentHashMap ---
        Thread t3 = new Thread(() -> {
            for (int i = 1; i <= 1000; i++) {
                concurrentMap.put(i, "Value " + i);
            }
        });

        Thread t4 = new Thread(() -> {
            for (int i = 1001; i <= 2000; i++) {
                concurrentMap.put(i, "Value " + i);
            }
        });

        t3.start();
        t4.start();
        t3.join();
        t4.join();

        System.out.println("ConcurrentHashMap Size (Expected 2000): " + concurrentMap.size());
    }
}