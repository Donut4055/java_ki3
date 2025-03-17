package bt8;

public class Garage {
    private Car[] cars;
    private int count;
    private final int MAX_CARS = 10;

    public Garage() {
        cars = new Car[MAX_CARS];
        count = 0;
    }

    public void addCar(Car car) {
        if (count < MAX_CARS) {
            cars[count] = car;
            count++;
            System.out.println(car.getModel() + " đã được thêm vào gara.");
        } else {
            System.out.println("Gara đã đầy. Không thể thêm xe mới.");
        }
    }

    public void startAllCars() {
        System.out.println("\n=== Khởi động tất cả xe ===");
        for (int i = 0; i < count; i++) {
            System.out.println(cars[i].start());
        }
    }

    public void stopAllCars() {
        System.out.println("\n=== Dừng tất cả xe ===");
        for (int i = 0; i < count; i++) {
            System.out.println(cars[i].stop());
        }
    }

    // Phương thức nạp nhiên liệu cho tất cả các xe
    public void refuelAllCars() {
        System.out.println("\n=== Nạp nhiên liệu cho tất cả xe ===");
        for (int i = 0; i < count; i++) {
            if (cars[i] instanceof IRefuelable) {
                IRefuelable refuelableCar = (IRefuelable) cars[i];
                System.out.println(refuelableCar.refuel());
            } else {
                System.out.println("Xe " + cars[i].getModel() + " không hỗ trợ nạp nhiên liệu.");
            }
        }
    }

    // Phương thức hiển thị tất cả xe trong gara
    public void displayAllCars() {
        System.out.println("\n=== Danh sách xe trong gara ===");
        if (count == 0) {
            System.out.println("Gara trống.");
            return;
        }

        for (int i = 0; i < count; i++) {
            String carType = (cars[i] instanceof ElectricCar) ? "Điện" : "Xăng";
            System.out.println((i+1) + ". Xe " + carType + ": " + cars[i].getInfo());
        }
    }
}
