package bt9;

public class Bike extends Vehicle {
    @Override
    public String move() {
        return "Xe đạp di chuyển với tốc độ chậm.";
    }

    @Override
    public String sound() {
        return "Ring Ring";
    }
}