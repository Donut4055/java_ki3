package test.entity;

import java.util.Scanner;

public class Student {
    private String id;
    private String name;
    private int age;
    private float avg_score;
    Scanner sc = new Scanner(System.in);
    public Student(){}

    public Student(String id, String name, int age, float avg_score) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.avg_score = avg_score;
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public float getAvg_score() {
        return avg_score;
    }

    public String setId(String id) {
        return this.id = id;
    }
    public String setName(String name) {
        return this.name = name;
    }
    public int setAge(int age) {
        return this.age = age;
    }
    public float setAvg_score(float avg_score) {
        return this.avg_score = avg_score;
    }
 }
