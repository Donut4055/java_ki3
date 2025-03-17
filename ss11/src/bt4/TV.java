package bt4;

public class TV implements IElectronic {
    private String model;

    public TV(String model) {
        this.model = model;
    }

    @Override
    public void turnOn() {
        System.out.println("Turning on TV...");
    }

    @Override
    public void turnOff() {
        System.out.println("Turning off TV...");
    }

    public String getModel() {
        return model;
    }
}
