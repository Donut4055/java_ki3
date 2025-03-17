package bt6;

public class Lion extends Animal {
    private String gender;

    public Lion(String name, int age, String gender) {
        super(name, age);
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    @Override
    public void sound() {
        System.out.println(name + " says: Roar!");
    }

    @Override
    public void move() {
        System.out.println("The lion is running.");
    }
}
