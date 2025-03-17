package bt4;

public class Radio implements IElectronic {
    private String brand;

    public Radio(String brand) {
        this.brand = brand;
    }

    @Override
    public void turnOn() {
        System.out.println("Turning on Radio...");
    }

    @Override
    public void turnOff() {
        System.out.println("Turning off Radio...");
    }

    public String getBrand() {
        return brand;
    }
}
