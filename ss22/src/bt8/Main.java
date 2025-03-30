package bt8;

import java.io.*;
import java.util.List;

public class Main {
    private static final String FILE_NAME = "products.dat";

    public static void main(String[] args) {
        List<Product> products = List.of(
                new Product(1, "Laptop", 1500.00),
                new Product(2, "Chuột", 20.50),
                new Product(3, "Bàn phím", 45.99),
                new Product(4, "Màn hình", 300.00),
                new Product(5, "Tai nghe", 75.50)
        );

        writeProductsToFile(products);

        List<Product> loadedProducts = readProductsFromFile();
        if (loadedProducts != null) {
            System.out.println("\nDanh sách sản phẩm:");
            loadedProducts.forEach(System.out::println);
        }
    }

    private static void writeProductsToFile(List<Product> products) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(products);
            System.out.println("Đã ghi danh sách sản phẩm vào file " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }

    private static List<Product> readProductsFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (List<Product>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
            return null;
        }
    }
}
