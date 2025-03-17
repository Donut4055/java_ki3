package bt9;

public class Car extends Vehicle {
    @Override
    public String move() {
        return "Xe hơi di chuyển trên mặt đất.";
    }

    @Override
    public String sound() {
        return "Vroom";
    }
}