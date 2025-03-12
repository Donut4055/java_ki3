package practice;

import java.util.Scanner;

public class Main {
    static final int MAX_BOOKS = 100;
    static Book[] bookList = new Book[MAX_BOOKS];
    static int bookCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            displayMenu();
            System.out.print("Chọn chức năng: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        displayBookList();
                        break;
                    case 2:
                        addNewBook(scanner);
                        break;
                    case 3:
                        calculateAndDisplayProfit();
                        break;
                    case 4:
                        updateBook(scanner);
                        break;
                    case 5:
                        deleteBook(scanner);
                        break;
                    case 6:
                        sortByProfit();
                        break;
                    case 7:
                        searchByAuthor(scanner);
                        break;
                    case 8:
                        searchByPriceRange(scanner);
                        break;
                    case 9:
                        statisticsByAuthor();
                        break;
                    case 10:
                        System.out.println("Thoát chương trình.");
                        break;
                    default:
                        System.out.println("Chức năng không hợp lệ.");
                }
            } else {
                System.out.println("Vui lòng nhập số hợp lệ.");
                scanner.next();
                choice = 0;
            }
            System.out.println();
        } while (choice != 10);
    }

    public static void displayMenu() {
        System.out.println("*************** MENU ***************");
        System.out.println("1. Hiển thị danh sách sách");
        System.out.println("2. Thêm sách mới");
        System.out.println("3. Tính lợi nhuận sách");
        System.out.println("4. Cập nhật sách");
        System.out.println("5. Xóa sách");
        System.out.println("6. Sắp xếp theo lợi nhuận tăng dần");
        System.out.println("7. Tìm kiếm sách theo tác giả");
        System.out.println("8. Tìm kiếm sách theo khoảng giá");
        System.out.println("9. Thống kê số lượng sách theo tác giả");
        System.out.println("10. Thoát");
    }

    public static void displayBookList() {
        if (bookCount == 0) {
            System.out.println("Danh sách sách trống.");
        } else {
            for (int i = 0; i < bookCount; i++) {
                bookList[i].displayData();
                System.out.println("------------------------");
            }
        }
    }

    public static void addNewBook(Scanner sc) {
        if (bookCount >= MAX_BOOKS) {
            System.out.println("Không thể thêm sách. Danh sách đã đầy.");
            return;
        }
        Book newBook = new Book();
        newBook.inputData(sc);
        bookList[bookCount++] = newBook;
        System.out.println("Thêm sách thành công.");
    }

    public static void calculateAndDisplayProfit() {
        double total = 0;
        for (int i = 0; i < bookCount; i++) {
            bookList[i].calInterest();
            total += bookList[i].getInterest();
            System.out.println("Sách: " + bookList[i].getBookName() + ", Lợi nhuận: " + bookList[i].getInterest());
        }
        System.out.println("Tổng lợi nhuận: " + total);
    }

    public static void updateBook(Scanner sc) {
        System.out.print("Nhập mã sách cần cập nhật: ");
        String id = sc.nextLine();
        boolean found = false;
        for (int i = 0; i < bookCount; i++) {
            if (bookList[i].getBookId().equals(id)) {
                System.out.println("Thông tin cũ:");
                bookList[i].displayData();
                System.out.println("Nhập lại thông tin mới:");
                bookList[i].inputData(sc);
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Không tìm thấy sách có mã: " + id);
    }

    public static void deleteBook(Scanner sc) {
        System.out.print("Nhập mã sách cần xóa: ");
        String id = sc.nextLine();
        boolean removed = false;
        for (int i = 0; i < bookCount; i++) {
            if (bookList[i].getBookId().equals(id)) {
                for (int j = i; j < bookCount - 1; j++) {
                    bookList[j] = bookList[j + 1];
                }
                bookCount--;
                removed = true;
                System.out.println("Xóa thành công.");
                break;
            }
        }
        if (!removed) System.out.println("Không tìm thấy sách có mã: " + id);
    }

    public static void sortByProfit() {
        for (int i = 0; i < bookCount - 1; i++) {
            for (int j = i + 1; j < bookCount; j++) {
                if (bookList[i].getInterest() > bookList[j].getInterest()) {
                    Book temp = bookList[i];
                    bookList[i] = bookList[j];
                    bookList[j] = temp;
                }
            }
        }
        System.out.println("Đã sắp xếp sách theo lợi nhuận tăng dần.");
    }

    public static void searchByAuthor(Scanner sc) {
        System.out.print("Nhập tên tác giả: ");
        String author = sc.nextLine();
        boolean found = false;
        for (int i = 0; i < bookCount; i++) {
            if (bookList[i].getAuthor().toLowerCase().contains(author.toLowerCase())) {
                bookList[i].displayData();
                System.out.println("----------------------");
                found = true;
            }
        }
        if (!found) System.out.println("Không tìm thấy sách của tác giả này.");
    }

    public static void searchByPriceRange(Scanner sc) {
        System.out.print("Nhập giá tối thiểu: ");
        double min = sc.nextDouble();
        System.out.print("Nhập giá tối đa: ");
        double max = sc.nextDouble();
        sc.nextLine(); // bỏ dòng thừa

        boolean found = false;
        for (int i = 0; i < bookCount; i++) {
            double price = bookList[i].getExportPrice();
            if (price >= min && price <= max) {
                bookList[i].displayData();
                System.out.println("--------------------");
                found = true;
            }
        }
        if (!found) System.out.println("Không có sách nào trong khoảng giá này.");
    }

    public static void statisticsByAuthor() {
        System.out.println("Thống kê sách theo tác giả:");
        for (int i = 0; i < bookCount; i++) {
            String author = bookList[i].getAuthor();
            int count = 0;
            boolean alreadyCounted = false;
            for (int j = 0; j < i; j++) {
                if (bookList[j].getAuthor().equals(author)) {
                    alreadyCounted = true;
                    break;
                }
            }
            if (alreadyCounted) continue;
            for (int j = 0; j < bookCount; j++) {
                if (bookList[j].getAuthor().equals(author)) {
                    count++;
                }
            }
            System.out.println("Tác giả: " + author + " - Số lượng sách: " + count);
        }
    }
}
