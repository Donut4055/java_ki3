package bt3;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car.CarBuilder()
                .setEngine("V6")
                .setSeats(4)
                .setColor("Red")
                .build();

        Car car2 = new Car.CarBuilder()
                .setEngine("V8")
                .setColor("Black")
                .build();

        System.out.println("Car 1: " + car1);
        System.out.println("Car 2: " + car2);
    }
}