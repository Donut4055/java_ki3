package practice;

import java.util.Scanner;

public class Book {
    private String bookId;
    private String bookName;
    private double importPrice;
    private double exportPrice;
    private String title;
    private String author;
    private double interest;
    private int year;

    public Book() {
    }

    public Book(String bookId, String bookName, double importPrice, double exportPrice, String title, String author, int year) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.title = title;
        this.author = author;
        this.year = year;
        this.interest = exportPrice - importPrice;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getInterest() {
        return interest;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void inputData(Scanner scanner) {
        boolean validInput = false;
        do {
            System.out.print("Nhập mã sách (5 ký tự, bắt đầu bằng 'B'): ");
            String bookId = scanner.nextLine();
            if (bookId.length() == 5 && bookId.startsWith("B")) {
                this.bookId = bookId;
                validInput = true;
            } else {
                System.out.println("Mã sách không hợp lệ. Vui lòng nhập lại.");
            }
        } while (!validInput);

        validInput = false;
        do {
            System.out.print("Nhập tên sách (6-100 ký tự): ");
            String bookName = scanner.nextLine();
            if (bookName.length() >= 6 && bookName.length() <= 100) {
                this.bookName = bookName;
                validInput = true;
            } else {
                System.out.println("Tên sách không hợp lệ. Vui lòng nhập lại.");
            }
        } while (!validInput);

        validInput = false;
        do {
            System.out.print("Nhập giá nhập (lớn hơn 0): ");
            if (scanner.hasNextDouble()) {
                double importPrice = scanner.nextDouble();
                if (importPrice > 0) {
                    this.importPrice = importPrice;
                    validInput = true;
                } else {
                    System.out.println("Giá nhập phải lớn hơn 0. Vui lòng nhập lại.");
                }
            } else {
                System.out.println("Giá nhập không hợp lệ. Vui lòng nhập số.");
                scanner.next();
            }
        } while (!validInput);
        scanner.nextLine();

        validInput = false;
        do {
            System.out.print("Nhập giá bán (lớn hơn giá nhập ít nhất 10%): ");
            if (scanner.hasNextDouble()) {
                double exportPrice = scanner.nextDouble();
                if (exportPrice > this.importPrice * 1.1) {
                    this.exportPrice = exportPrice;
                    validInput = true;
                } else {
                    System.out.println("Giá bán phải lớn hơn giá nhập ít nhất 10%. Vui lòng nhập lại.");
                }
            } else {
                System.out.println("Giá bán không hợp lệ. Vui lòng nhập số.");
                scanner.next();
            }
        } while (!validInput);
        scanner.nextLine();


        System.out.print("Nhập tiêu đề sách: ");
        this.title = scanner.nextLine();

        System.out.print("Nhập tác giả: ");
        this.author = scanner.nextLine();

        validInput = false;
        do {
            System.out.print("Nhập năm xuất bản (sau năm 1970): ");
            if (scanner.hasNextInt()) {
                int year = scanner.nextInt();
                if (year > 1970) {
                    this.year = year;
                    validInput = true;
                } else {
                    System.out.println("Năm xuất bản phải sau năm 1970. Vui lòng nhập lại.");
                }
            } else {
                System.out.println("Năm xuất bản không hợp lệ. Vui lòng nhập số nguyên.");
                scanner.next();
            }
        } while (!validInput);
        scanner.nextLine();

        calInterest();
    }

    public void displayData() {
        System.out.println("Mã sách: " + bookId);
        System.out.println("Tên sách: " + bookName);
        System.out.println("Giá nhập: " + importPrice);
        System.out.println("Giá bán: " + exportPrice);
        System.out.println("Tiêu đề sách: " + title);
        System.out.println("Tác giả: " + author);
        System.out.println("Lợi nhuận: " + interest);
        System.out.println("Năm xuất bản: " + year);
    }

    public void calInterest() {
        this.interest = exportPrice - importPrice;
    }
}
