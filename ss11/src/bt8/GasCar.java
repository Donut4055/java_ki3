package bt8;

public class GasCar extends Car implements IRefuelable {
    private String fuelType;

    public GasCar(String model, int year, double price) {
        super(model, year, price);
        this.fuelType = "Xăng";
    }

    public GasCar(String model, int year, double price, String fuelType) {
        super(model, year, price);
        this.fuelType = fuelType;
    }

    public String getFuelType() {
        return fuelType;
    }

    @Override
    public String start() {
        return "Xe chạy xăng " + getInfo() + " đã khởi động với tiếng động cơ.";
    }

    @Override
    public String stop() {
        return "Xe chạy xăng " + getInfo() + " đã dừng và động cơ tắt";
    }

    @Override
    public String refuel() {
        return "Xe chạy xăng " + getInfo() + " đang được đổ xăng...";
    }
}
