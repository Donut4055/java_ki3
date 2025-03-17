package bt9;

public class Main {
    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle bike = new Bike();
        Vehicle bus = new Bus(50);
        Vehicle airplane = new Airplane(10000);

        Vehicle[] vehicles = new Vehicle[]{car, bike, bus, airplane};

        for (Vehicle vehicle : vehicles) {
            System.out.println("Phương tiện: " + vehicle.getClass().getSimpleName());
            System.out.println("Hành động di chuyển: " + vehicle.move());
            System.out.println("Âm thanh: " + vehicle.sound());

            if (vehicle instanceof Car) {
                System.out.println(vehicle.move(2, 60));
            } else if (vehicle instanceof Bike) {
                System.out.println(vehicle.move(3, 15));
            } else if (vehicle instanceof Bus) {
                System.out.println(vehicle.move(1, 40));
            } else if (vehicle instanceof Airplane) {
                System.out.println(vehicle.move(5, 800));
            }
            System.out.println("----------");
        }
    }
}