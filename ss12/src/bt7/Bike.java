package bt7;

public class Bike extends Vehicle {
    @Override
    public String move() {
        return "Bike moving slowly";
    }

    @Override
    public String sound() {
        return "Ring Ring";
    }
}
