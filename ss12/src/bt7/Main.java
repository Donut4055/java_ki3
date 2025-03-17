package bt7;

public class Main {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[3];
        vehicles[0] = new Car();
        vehicles[1] = new Bike();
        vehicles[2] = new Bus();

        for (Vehicle vehicle : vehicles) {
            System.out.println("Phương tiện: " + vehicle.getClass().getSimpleName());
            System.out.println("Hành động: " + vehicle.move());
            System.out.println("Âm thanh: " + vehicle.sound());
            System.out.println("----------");
        }
    }
}