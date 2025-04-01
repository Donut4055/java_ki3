package bt5;

class Reader implements Runnable {
    private SharedData sharedData;

    public Reader(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        sharedData.receiveMessage();
    }
}