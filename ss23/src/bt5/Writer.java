package bt5;

class Writer implements Runnable {
    private SharedData sharedData;
    private String message;

    public Writer(SharedData sharedData, String message) {
        this.sharedData = sharedData;
        this.message = message;
    }

    @Override
    public void run() {
        sharedData.sendMessage(message);
    }
}