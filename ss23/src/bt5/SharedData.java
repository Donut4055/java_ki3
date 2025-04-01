package bt5;

class SharedData {
    private String message;
    private boolean isMessageSent = false;

    public synchronized void sendMessage(String msg) {
        this.message = msg;
        System.out.println("Người gửi: Đang gửi tin nhắn - \"" + msg + "\"");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Lỗi khi gửi: " + e.getMessage());
        }
        isMessageSent = true;
        System.out.println("Người gửi: Đã gửi tin nhắn!");
        notify();
    }

    public synchronized void receiveMessage() {
        while (!isMessageSent) {
            try {
                System.out.println("Người nhận: Đang chờ tin nhắn...");
                wait();
            } catch (InterruptedException e) {
                System.out.println("Lỗi khi chờ: " + e.getMessage());
            }
        }
        System.out.println("Người nhận: Đã nhận được tin nhắn - \"" + message + "\"");
    }
}