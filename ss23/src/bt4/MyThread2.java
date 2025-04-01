package bt4;

class MyThread2 extends Thread {
    private Thread waitForThread;

    public MyThread2(String name, Thread waitForThread) {
        super(name);
        this.waitForThread = waitForThread;
    }

    @Override
    public void run() {
        try {
            waitForThread.join();
        } catch (InterruptedException e) {
            System.out.println("Thread bị gián đoạn: " + e.getMessage());
        }
        System.out.println(getName() + " bắt đầu...");
    }
}