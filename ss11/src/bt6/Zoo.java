package bt6;

public class Zoo {
    private Animal[] animals;
    private int count;
    private final int MAX_ANIMALS = 10;

    public Zoo() {
        animals = new Animal[MAX_ANIMALS];
        count = 0;
    }

    public void addAnimal(Animal animal) {
        if (count < MAX_ANIMALS) {
            animals[count] = animal;
            count++;
            System.out.println(animal.getName() + " has been added to the zoo.");
        } else {
            System.out.println("The zoo is full. Cannot add more animals.");
        }
    }

    public void makeAllSounds() {
        System.out.println("\n=== Zoo Animal Sounds ===");
        for (int i = 0; i < count; i++) {
            System.out.print(animals[i].getName() + " (Age " + animals[i].getAge() + "): ");
            animals[i].sound();
        }
    }

    public void moveAllAnimals() {
        System.out.println("\n=== Zoo Animal Movements ===");
        for (int i = 0; i < count; i++) {
            System.out.print(animals[i].getName() + ": ");
            animals[i].move();
        }
    }

    public void displayAllAnimals() {
        System.out.println("\n=== Zoo Animals ===");
        for (int i = 0; i < count; i++) {
            System.out.println((i+1) + ". " + animals[i].getName() + " (Age: " + animals[i].getAge() + ")");
        }
    }
}
