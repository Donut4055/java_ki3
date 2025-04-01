package bt6;

class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(getName() + " (Ưu tiên: " + getPriority() + "): Lần " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(getName() + " bị gián đoạn: " + e.getMessage());
            }
        }
        System.out.println(getName() + " đã kết thúc.");
    }
}