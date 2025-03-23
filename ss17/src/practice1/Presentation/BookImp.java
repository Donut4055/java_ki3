package practice1.Presentation;

import practice1.Entity.Book;
import practice1.Validate.BookValidator;

import java.util.ArrayList;
import java.util.Scanner;

public class BookImp {
    private static ArrayList<Book> books = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            displayMenu();
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    inputBooks();
                    break;
                case 2:
                    calculateInterests();
                    break;
                case 3:
                    displayBooks();
                    break;
                case 4:
                    sortByExportPrice();
                    break;
                case 5:
                    sortByInterest();
                    break;
                case 6:
                    searchByName();
                    break;
                case 7:
                    statisticByYear();
                    break;
                case 8:
                    statisticByAuthor();
                    break;
                case 9:
                    System.out.println("Thoát chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 9);
    }

    private static void displayMenu() {
        System.out.println("\nMENU*******MENU****MENU");
        System.out.println("1. Nhập thông tin n sách");
        System.out.println("2. Tính lợi nhuận các sách");
        System.out.println("3. Hiển thị thông tin sách");
        System.out.println("4. Sắp xếp sách theo giá bán tăng dần");
        System.out.println("5. Sắp xếp sách theo lợi nhuận giảm dần");
        System.out.println("6. Tìm sách theo tên sách");
        System.out.println("7. Thống kê số lượng sách theo năm xuất bản");
        System.out.println("8. Thống kê số lượng sách theo tác giả");
        System.out.println("9. Thoát");
        System.out.print("Chọn chức năng (1-9): ");
    }

    private static void inputBooks() {
        System.out.print("Nhập số lượng sách: ");
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin sách thứ " + (i + 1) + ":");
            Book book = BookValidator.inputData(scanner, books);
            books.add(book);
        }
        System.out.println("Đã nhập xong thông tin sách!");
    }

    private static void calculateInterests() {
        if (books.isEmpty()) {
            System.out.println("Danh sách sách rỗng!");
            return;
        }
        System.out.println("Đã tính lợi nhuận cho các sách!");
    }

    private static void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("Danh sách sách rỗng!");
            return;
        }
        System.out.println("\nDanh sách sách:");
        for (Book book : books) {
            book.displayData();
        }
    }

    private static void sortByExportPrice() {
        if (books.isEmpty()) {
            System.out.println("Danh sách sách rỗng!");
            return;
        }
        for (int i = 0; i < books.size() - 1; i++) {
            for (int j = 0; j < books.size() - 1 - i; j++) {
                if (books.get(j).getExportPrice() > books.get(j + 1).getExportPrice()) {
                    Book temp = books.get(j);
                    books.set(j, books.get(j + 1));
                    books.set(j + 1, temp);
                }
            }
        }
        System.out.println("Đã sắp xếp sách theo giá bán tăng dần!");
        displayBooks();
    }

    private static void sortByInterest() {
        if (books.isEmpty()) {
            System.out.println("Danh sách sách rỗng!");
            return;
        }
        for (int i = 0; i < books.size() - 1; i++) {
            for (int j = 0; j < books.size() - 1 - i; j++) {
                if (books.get(j).getInterest() < books.get(j + 1).getInterest()) {
                    Book temp = books.get(j);
                    books.set(j, books.get(j + 1));
                    books.set(j + 1, temp);
                }
            }
        }
        System.out.println("Đã sắp xếp sách theo lợi nhuận giảm dần!");
        displayBooks();
    }

    private static void searchByName() {
        if (books.isEmpty()) {
            System.out.println("Danh sách sách rỗng!");
            return;
        }
        System.out.print("Nhập tên sách cần tìm: ");
        String searchName = scanner.nextLine();
        boolean found = false;

        System.out.println("\nKết quả tìm kiếm:");
        for (Book book : books) {
            if (book.getBookName().equalsIgnoreCase(searchName)) {
                book.displayData();
                found = true;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sách với tên: " + searchName);
        }
    }

    private static void statisticByYear() {
        if (books.isEmpty()) {
            System.out.println("Danh sách sách rỗng!");
            return;
        }
        System.out.println("\nThống kê số lượng sách theo năm xuất bản:");
        int[] years = new int[books.size()];
        int[] counts = new int[books.size()];
        int uniqueYears = 0;

        for (Book book : books) {
            boolean found = false;
            for (int i = 0; i < uniqueYears; i++) {
                if (years[i] == book.getYear()) {
                    counts[i]++;
                    found = true;
                    break;
                }
            }
            if (!found) {
                years[uniqueYears] = book.getYear();
                counts[uniqueYears] = 1;
                uniqueYears++;
            }
        }

        for (int i = 0; i < uniqueYears; i++) {
            System.out.println("Năm " + years[i] + ": " + counts[i] + " sách");
        }
    }

    private static void statisticByAuthor() {
        if (books.isEmpty()) {
            System.out.println("Danh sách sách rỗng!");
            return;
        }
        System.out.println("\nThống kê số lượng sách theo tác giả:");
        ArrayList<String> authors = new ArrayList<>();
        ArrayList<Integer> counts = new ArrayList<>();

        for (Book book : books) {
            int index = authors.indexOf(book.getAuthor());
            if (index == -1) {
                authors.add(book.getAuthor());
                counts.add(1);
            } else {
                counts.set(index, counts.get(index) + 1);
            }
        }

        for (int i = 0; i < authors.size(); i++) {
            System.out.println("Tác giả " + authors.get(i) + ": " + counts.get(i) + " sách");
        }
    }
}