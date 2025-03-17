package bt9;

public class Airplane extends Vehicle {
    private int altitude;

    public Airplane(int altitude) {
        this.altitude = altitude;
    }

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    @Override
    public String move() {
        return "Máy bay di chuyển trên không.";
    }

    @Override
    public String sound() {
        return "Whoosh";
    }
}
