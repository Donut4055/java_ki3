package bt3;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Toyota Camry", 180, 4);

        Bike bike = new Bike("Honda Wave", 120, false);

        car.start();
        car.displayInfo();

        System.out.println();

        bike.start();
        bike.displayInfo();
    }
}
