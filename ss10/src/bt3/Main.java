package bt3;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("acccc", "accacass", 2020);
        car1.displayInfo();

        car1.setMake("123123");
        car1.setModel("qưeqwe");

        car1.setYear(2022);

        car1.setYear(2030);

        System.out.println("\nThông tin sau khi cập nhật:");
        car1.displayInfo();
    }
}

