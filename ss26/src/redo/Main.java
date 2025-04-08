package redo;

import redo.presentation.StudentUI;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentUI studentUI = new StudentUI();
        StudentUI.displayStudentMenu(scanner);
        studentUI.displayListStudents();
    }
}