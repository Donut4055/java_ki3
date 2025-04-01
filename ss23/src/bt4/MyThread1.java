package bt4;

class MyThread1 extends Thread {
    public MyThread1(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + ": " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Thread bị gián đoạn: " + e.getMessage());
            }
        }
        System.out.println(getName() + " đã kết thúc.");
    }
}