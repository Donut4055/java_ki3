package bt3;

class AlphabetPrinter implements Runnable {
    private SharedResource sharedResource;

    public AlphabetPrinter(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        sharedResource.printAlphabet();
    }
}