package bt3;

public class Main {
    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource();

        AlphabetPrinter printer1 = new AlphabetPrinter(sharedResource);
        AlphabetPrinter printer2 = new AlphabetPrinter(sharedResource);

        Thread thread1 = new Thread(printer1, "Thread-1");
        Thread thread2 = new Thread(printer2, "Thread-2");

        thread1.start();
        thread2.start();
    }
}