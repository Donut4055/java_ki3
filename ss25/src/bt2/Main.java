package bt2;

public class Main {
    public static void main(String[] args) {
        AnimalFactory factory = new AnimalFactory();

        Animal dog = factory.createAnimal("dog");
        Animal cat = factory.createAnimal("cat");

        System.out.println("Dog :");
        dog.speak();

        System.out.println("Cat :");
        cat.speak();

        try {
            Animal unknown = factory.createAnimal("bird");
        } catch (IllegalArgumentException e) {
            System.out.println("\nError: " + e.getMessage());
        }
    }
}