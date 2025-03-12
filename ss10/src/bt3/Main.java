package bt3;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Toyota", "Corolla", 2020);
        car1.displayInfo();

        car1.setMake("Honda");
        car1.setModel("Civic");

        car1.setYear(2022);

        car1.setYear(2030);

        System.out.println("\nThông tin sau khi cập nhật:");
        car1.displayInfo();
    }
}

