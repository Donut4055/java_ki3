package bt9;

public class Bus extends Vehicle {
    private int seats;

    public Bus(int seats) {
        this.seats = seats;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    @Override
    public String move() {
        return "Xe buýt di chuyển trên mặt đất.";
    }

    @Override
    public String sound() {
        return "Honk";
    }
}
