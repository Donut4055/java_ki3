package bt9;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
class BookManager {
    private static final String FILE_NAME = "books.dat";
    private List<Book> books;

    public BookManager() {
        this.books = readBooksFromFile();
    }

    public void addBook(Book book) {
        books.add(book);
        saveBooksToFile();
    }

    public void updateBook(Book book) {
        for (Book b : books) {
            if (b.getId() == book.getId()) {
                b.setName(book.getName());
                b.setAuthor(book.getAuthor());
                b.setPublisher(book.getPublisher());
                b.setPrice(book.getPrice());
                saveBooksToFile();
                return;
            }
        }
        System.out.println("Không tìm thấy sách có ID: " + book.getId());
    }

    public void deleteBook(int id) {
        books.removeIf(b -> b.getId() == id);
        saveBooksToFile();
    }

    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("Danh sách sách trống.");
        } else {
            books.forEach(System.out::println);
        }
    }

    private void saveBooksToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(books);
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }

    private List<Book> readBooksFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Book>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}

