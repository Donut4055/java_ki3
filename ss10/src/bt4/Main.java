package bt4;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("bâcc", "aaaaa", 120.5);
        book1.displayInfo();

        book1.setTitle("qưdqwd");
        book1.setAuthor("bbbb");

        book1.setPrice(150.0);

        book1.setPrice(-50.0);

        System.out.println("\nThông tin sau khi cập nhật:");
        book1.displayInfo();
    }
}
