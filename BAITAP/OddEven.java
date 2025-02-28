package BAITAP;

public class OddEven {
    static class NumberPrinter { 
        private boolean isOddTurn = true; 

        public synchronized void printOdd(int number) {
            while (!isOddTurn) { 
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Odd Thread Interrupted");
                }
            }
            System.out.println("Odd: " + number);
            isOddTurn = false; 
            notify(); 
        }

        public synchronized void printEven(int number) {
            while (isOddTurn) { 
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Even Thread Interrupted");
                }
            }
            System.out.println("Even: " + number);
            isOddTurn = true; 
            notify(); 
        }
    }

    static class OddThread extends Thread {
        private final NumberPrinter printer;

        public OddThread(NumberPrinter printer) {
            this.printer = printer;
        }

        public void run() {
            for (int i = 1; i <= 20; i += 2) {
                printer.printOdd(i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    static class EvenThread extends Thread {
        private final NumberPrinter printer;

        public EvenThread(NumberPrinter printer) {
            this.printer = printer;
        }

        public void run() {
            for (int i = 2; i <= 20; i += 2) {
                printer.printEven(i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public static void main(String[] args) {
        NumberPrinter printer = new NumberPrinter();
        OddThread oddThread = new OddThread(printer);
        EvenThread evenThread = new EvenThread(printer);

        oddThread.start();
        evenThread.start();
    }
}
    

