package bt3;

public class Bike extends Vehicle {
    private boolean hasSideCar;

    public Bike(String name, int speed, boolean hasSideCar) {
        super(name, speed);
        this.hasSideCar = hasSideCar;
    }

    @Override
    public void displayInfo() {
        System.out.println("Bike Details:");
        System.out.println("Name: " + name);
        System.out.println("Speed: " + speed + " km/h");
        System.out.println("Has side car: " + (hasSideCar ? "Yes" : "No"));
    }
}