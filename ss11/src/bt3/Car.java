package bt3;

public class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String name, int speed, int numberOfDoors) {
        super(name, speed);
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void displayInfo() {
        System.out.println("Car Details:");
        System.out.println("Name: " + name);
        System.out.println("Speed: " + speed + " km/h");
        System.out.println("Number of doors: " + numberOfDoors);
    }
}
