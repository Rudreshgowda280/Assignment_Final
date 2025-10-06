package assingment_october;

//Q3. Create a program to implement a thread-safe Singleton class using double-checked locking.
public class SingletonDemo {
    public static void main(String[] args) {

        // Creating multiple threads to test thread safety
        Runnable task = () -> { // lamda that will be executed by thread
            Singleton singleton = Singleton.getInstance();  //calls the Singleton’s factory method to get the single instance.
            singleton.showMessage(); // this is call method
        };

        Thread t1 = new Thread(task);
        t1.start();

    }
}


class Singleton {
    // Volatile ensures visibility and prevents instruction reordering
    private static volatile Singleton instance;

    // Private constructor prevents instantiation
    private Singleton()
    {
        System.out.println("Singleton instance created!");
    }

    public static Singleton getInstance() {
        if (instance == null) {  // First check (no locking)
            synchronized (Singleton.class) {
                if (instance == null) {  // Second check (with lock)
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    // Example method
    public void showMessage() {
        System.out.println("Hello from Singleton!");
}
}
