package practice1.Validate;

import practice1.Entity.Book;

import java.util.ArrayList;
import java.util.Scanner;

public class BookValidator {
    public static Book inputData(Scanner scanner, ArrayList<Book> books) {
        Book book = new Book();

        while (true) {
            System.out.print("Nhập mã sách: ");
            String id = scanner.nextLine();
            if (id.trim().isEmpty()) {
                System.out.println("Mã sách không được để trống!");
            } else {
                book.setBookId(id);
                break;
            }
        }

        while (true) {
            System.out.print("Nhập tên sách (4 ký tự, bắt đầu bằng 'B'): ");
            String name = scanner.nextLine();
            boolean isDuplicate = false;
            for (Book b : books) {
                if (b.getBookName() != null && b.getBookName().equals(name)) {
                    isDuplicate = true;
                    break;
                }
            }
            if (name.length() != 4 || !name.startsWith("B")) {
                System.out.println("Tên sách phải có 4 ký tự và bắt đầu bằng 'B'!");
            } else if (isDuplicate) {
                System.out.println("Tên sách không được trùng lặp!");
            } else {
                book.setBookName(name);
                break;
            }
        }

        while (true) {
            System.out.print("Nhập giá nhập (> 0): ");
            try {
                float price = Float.parseFloat(scanner.nextLine());
                if (price <= 0) {
                    System.out.println("Giá nhập phải lớn hơn 0!");
                } else {
                    book.setImportPrice(price);
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Giá nhập phải là số!");
            }
        }

        while (true) {
            System.out.print("Nhập giá xuất (lớn hơn giá nhập ít nhất 30%): ");
            try {
                float price = Float.parseFloat(scanner.nextLine());
                if (price < book.getImportPrice() * 1.3) {
                    System.out.println("Giá xuất phải lớn hơn giá nhập ít nhất 30%!");
                } else {
                    book.setExportPrice(price);
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Giá xuất phải là số!");
            }
        }

        while (true) {
            System.out.print("Nhập tác giả (6-50 ký tự): ");
            String auth = scanner.nextLine();
            if (auth.length() < 6 || auth.length() > 50) {
                System.out.println("Tác giả phải có từ 6 đến 50 ký tự!");
            } else {
                book.setAuthor(auth);
                break;
            }
        }

        while (true) {
            System.out.print("Nhập năm xuất bản (>= 2000): ");
            try {
                int y = Integer.parseInt(scanner.nextLine());
                if (y < 2000) {
                    System.out.println("Năm xuất bản phải từ 2000 trở lên!");
                } else {
                    book.setYear(y);
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Năm xuất bản phải là số!");
            }
        }

        return book;
    }
}