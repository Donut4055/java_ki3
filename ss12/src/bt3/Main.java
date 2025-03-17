package bt3;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        System.out.println("Âm thanh của Animal:");
        animal.makeSound();

        Dog dog = new Dog();
        System.out.println("\nÂm thanh của Dog:");
        dog.makeSound(); // Gọi phương thức makeSound() của lớp Dog (đã ghi đè)

        Cat cat = new Cat();
        System.out.println("\nÂm thanh của Cat:");
        cat.makeSound(); // Gọi phương thức makeSound() của lớp Cat (đã ghi đè)

        System.out.println("\n--- Đa hình động ---");

        Animal[] zooAnimals = new Animal[3];
        zooAnimals[0] = new Animal();
        zooAnimals[1] = new Dog();
        zooAnimals[2] = new Cat();

        for (Animal zooAnimal : zooAnimals) {
            System.out.println("\nÂm thanh của một động vật trong sở thú:");
            zooAnimal.makeSound();
        }
    }
}
