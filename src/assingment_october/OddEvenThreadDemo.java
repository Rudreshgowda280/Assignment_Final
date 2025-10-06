package assingment_october;


class NumberPrinter {
    private int number = 1;   // start from 1
    private final int MAX = 20;

    public synchronized void printOdd() {
        while (number <= MAX) {
            while (number % 2 == 0) {  // wait if it's even's turn
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (number <= MAX) {
                System.out.println("Odd Thread: " + number);
                number++;
                notify();  // wake up even thread
            }
        }
    }

    public synchronized void printEven() {
        while (number <= MAX) {
            while (number % 2 != 0) {  // wait if it's odd's turn
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (number <= MAX) {
                System.out.println("Even Thread: " + number);
                number++;
                notify();  // wake up odd thread
            }
        }
    }
}

public class OddEvenThreadDemo {
    public static void main(String[] args) {
        NumberPrinter printer = new NumberPrinter();

        Thread oddThread = new Thread(() -> printer.printOdd());
        Thread evenThread = new Thread(() -> printer.printEven());

        oddThread.start();
        evenThread.start();
    }
}
