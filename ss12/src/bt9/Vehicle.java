package bt9;

public abstract class Vehicle {
    public abstract String move();
    public abstract String sound();

    public String move(int time, int speed) {
        double distance = (double) speed * time;
        return "Phương tiện di chuyển được " + distance + " km trong " + time + " giờ với tốc độ " + speed + " km/h.";
    }
}
