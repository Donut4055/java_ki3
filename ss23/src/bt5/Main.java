package bt5;

public class Main {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();

        Thread writerThread = new Thread(new Writer(sharedData, "Xin chào, bạn khỏe không?"), "Writer");
        Thread readerThread = new Thread(new Reader(sharedData), "Reader");

        readerThread.start();
        writerThread.start();
    }
}