package bt9;

public class Main {
    public static void main(String[] args) {
        BookManager manager = new BookManager();

        manager.addBook(new Book(1, "Java cơ bản", "Nguyễn Văn A", "NXB Giáo Dục", 150.0));
        manager.addBook(new Book(2, "Lập trình Python", "Trần Văn B", "NXB Trẻ", 180.0));
        manager.addBook(new Book(3, "Cấu trúc dữ liệu", "Lê Thị C", "NXB Khoa Học", 200.0));

        System.out.println("\nDanh sách sách:");
        manager.displayAllBooks();

        manager.updateBook(new Book(2, "Lập trình Python nâng cao", "Trần Văn B", "NXB Trẻ", 220.0));

        System.out.println("\nDanh sách sách sau khi cập nhật:");
        manager.displayAllBooks();

        manager.deleteBook(1);

        System.out.println("\nDanh sách sách sau khi xóa:");
        manager.displayAllBooks();
    }
}
