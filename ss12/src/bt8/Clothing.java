package bt8;

public class Clothing extends Product {
    public Clothing(String name, double price) {
        super(name, price);
    }

    @Override
    public double getDiscount() {
        return 20.0;
    }
}
