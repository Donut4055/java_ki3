package test.presentation;

import test.util.Validator;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        do  {
            System.out.print("nhap so nguyen");
            String input = sc.nextLine();
            if (Validator.validateInteger(input)) {
                System.out.println("So nguyen hop le");
                break;
            } else {
                System.out.println("So nguyen khong hop le");
            }
        } while (true);


        do  {
            System.out.print("nhap so float");
            String input = sc.nextLine();
            if (Validator.validateFloat(input)) {
                System.out.println("So float hop le");
                break;
            } else {
                System.out.println("So float khong hop le");
            }
        } while (true);


        do  {
            System.out.print("nhap so double");
            String input = sc.nextLine();
            if (Validator.validateDouble(input)) {
                System.out.println("So double hop le");
                break;
            } else {
                System.out.println("So double khong hop le");
            }
        } while (true);


        do  {
            System.out.print("nhap so boolean");
            String input = sc.nextLine();
            if (Validator.validateBoolean(input)) {
                System.out.println("So boolean hop le");
                break;
            } else {
                System.out.println("So boolean khong hop le");
            }
        } while (true);


        do  {
            System.out.print("nhap string");
            String input = sc.nextLine();
            if (Validator.validateString(input)) {
                System.out.println("string hop le");
                break;
            } else {
                System.out.println("string khong hop le");
            }
        } while (true);


        do  {
            System.out.print("nhap email");
            String input = sc.nextLine();
            if (Validator.validateEmail(input)) {
                System.out.println("email hop le");
                break;
            } else {
                System.out.println("email khong hop le");
            }
        } while (true);


        do  {
            System.out.print("nhap so dien thoai");
            String input = sc.nextLine();
            if (Validator.validatePhoneNumber(input)) {
                System.out.println("so dien thoai hop le");
                break;
            } else {
                System.out.println("so dien thoai khong hop le");
            }
        } while (true);
    }
}
