package bt4;

public class Main {
    public static void main(String[] args) {
        IElectronic[] devices = new IElectronic[4];

        devices[0] = new TV("Samsung Smart TV");
        devices[1] = new Radio("Sony FM Radio");
        devices[2] = new TV("LG OLED TV");
        devices[3] = new Radio("Panasonic Radio");

        System.out.println("=== Turning on all devices ===");
        for (int i = 0; i < devices.length; i++) {
            devices[i].turnOn();
        }

        System.out.println("\n=== Turning off all devices ===");
        for (int i = 0; i < devices.length; i++) {
            devices[i].turnOff();
        }
    }
}