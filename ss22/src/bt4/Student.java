package bt4;

import java.io.Serializable;
import java.security.PublicKey;

class Student implements Serializable {
    private String name;
    private int age;
    private double score;

    public Student() {
    }

    public Student(String name, int age, double score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Tên: " + name + ", Tuổi: " + age + ", Điểm: " + score;
    }
}

