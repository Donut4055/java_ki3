package bt4;

import java.time.LocalDate;
import java.time.Period;
import java.util.Locale;

public class Person {
    String name;
    LocalDate birthDate;

    public Person(){}

    public Person(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public void printInfo() {
        System.out.println("Name: " + name + ", age: " + Period.between(birthDate, LocalDate.now()).getYears());
    }
}
