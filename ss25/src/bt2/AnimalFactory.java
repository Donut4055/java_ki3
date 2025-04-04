package bt2;

class AnimalFactory {
    public Animal createAnimal(String type) {
        if (type == null) {
            return null;
        }

        switch (type.toLowerCase()) {
            case "dog":
                return new Dog();
            case "cat":
                return new Cat();
            default:
                throw new IllegalArgumentException("Unknown animal type: " + type);
        }
    }
}

