package bt8;

public class Main {
    public static void main(String[] args) {
        Garage garage = new Garage();

        Car tesla = new ElectricCar("Tesla Model 3", 2023, 50000);
        Car nissan = new ElectricCar("Nissan Leaf", 2022, 35000, 62);
        Car toyota = new GasCar("Toyota Camry", 2022, 35000);
        Car honda = new GasCar("Honda Civic", 2023, 28000, "Xăng A95");

        garage.addCar(tesla);
        garage.addCar(nissan);
        garage.addCar(toyota);
        garage.addCar(honda);

        garage.displayAllCars();

        garage.startAllCars();

        garage.stopAllCars();

        garage.refuelAllCars();
    }
}