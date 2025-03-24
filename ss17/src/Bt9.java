import java.util.*;

class Book {
    private String id;
    private String title;
    private String author;
    private int year;

    public Book(String id, String title, String author, int year) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public int getYear() { return year; }

    @Override
    public String toString() {
        return "id='" + id + "', title='" + title + "', author='" + author + "', year=" + year ;
    }
}

public class Bt9 {
    private Set<Book> library;

    public Bt9() {
        library = new HashSet<>();
    }

    public boolean addBook(Book book) {
        return library.add(book);
    }

    public List<Book> filterBooksByYear(int yearThreshold) {
        List<Book> filteredBooks = new ArrayList<>();
        for (Book book : library) {
            if (book.getYear() > yearThreshold) {
                filteredBooks.add(book);
            }
        }
        return filteredBooks;
    }

    public void sortBooksByTitle(List<Book> books) {
        Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book b1, Book b2) {
                return b1.getTitle().compareTo(b2.getTitle());
            }
        });
    }

    public static void main(String[] args) {
        Bt9 manager = new Bt9();

        manager.addBook(new Book("B001", "Java Programming", "John Doe", 2018));
        manager.addBook(new Book("B002", "Python Basics", "Jane Smith", 2020));
        manager.addBook(new Book("B003", "C++ Advanced", "Bob Johnson", 2015));
        manager.addBook(new Book("B004", "Algorithms", "Alice Brown", 2021));
        boolean isDuplicateAdded = manager.addBook(new Book("B001", "Duplicate Book", "Test Author", 2022));
        System.out.println("Thêm sách trùng id: " + (isDuplicateAdded ? "Thành công" : "Thất bại"));

        List<Book> filteredBooks = manager.filterBooksByYear(2018);

        manager.sortBooksByTitle(filteredBooks);

        System.out.println("\nDanh sách sách xuất bản sau năm 2018 (sắp xếp theo tên):");
        if (filteredBooks.isEmpty()) {
            System.out.println("Không có sách nào phù hợp!");
        } else {
            for (Book book : filteredBooks) {
                System.out.println(book);
            }
        }
    }
}