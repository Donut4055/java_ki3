package bt4;

public class Main {
    public static void main(String[] args) {
        MyThread1 thread1 = new MyThread1("Thread-1");
        MyThread2 thread2 = new MyThread2("Thread-2", thread1);
        MyThread2 thread3 = new MyThread2("Thread-3", thread1);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}