package bt8;

public class ElectricCar extends Car implements IRefuelable {
    private int batteryCapacity;

    public ElectricCar(String model, int year, double price) {
        super(model, year, price);
        this.batteryCapacity = 100;
    }

    public ElectricCar(String model, int year, double price, int batteryCapacity) {
        super(model, year, price);
        this.batteryCapacity = batteryCapacity;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    @Override
    public String start() {
        return "Xe điện " + getInfo() + " đã khởi động không tiếng ồn";
    }

    @Override
    public String stop() {
        return "Xe điện " + getInfo() + " đã dừng và ngắt kết nối động cơ.";
    }

    @Override
    public String refuel() {
        return "Xe điện " + getInfo() + " đang sạc điện...";
    }
}
