package bt2;

public class Main {
    public static void main(String[] args) {
        NumberPrinter numberPrinter = new NumberPrinter();

        Thread thread = new Thread(numberPrinter);

        thread.start();
    }
}
