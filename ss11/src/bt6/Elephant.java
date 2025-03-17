package bt6;

public class Elephant extends Animal {
    private double trunkLength;

    public Elephant(String name, int age, double trunkLength) {
        super(name, age);
        this.trunkLength = trunkLength;
    }

    public double getTrunkLength() {
        return trunkLength;
    }

    @Override
    public void sound() {
        System.out.println(name + " says: Trumpet!");
    }

    @Override
    public void move() {
        System.out.println("The elephant is walking.");
    }
}