package bt6;

public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();

        Lion lion1 = new Lion("Simba", 5, "Male");
        Lion lion2 = new Lion("Nala", 4, "Female");
        Elephant elephant1 = new Elephant("Dumbo", 10, 2.5);
        Elephant elephant2 = new Elephant("Jumbo", 15, 3.0);

        zoo.addAnimal(lion1);
        zoo.addAnimal(lion2);
        zoo.addAnimal(elephant1);
        zoo.addAnimal(elephant2);

        zoo.displayAllAnimals();

        zoo.makeAllSounds();

        zoo.moveAllAnimals();
    }
}
