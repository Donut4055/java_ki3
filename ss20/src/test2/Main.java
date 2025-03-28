package test2;

import test2.entity.Product;
import test2.util.ProductFilter;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    private static List<Product> products = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            displayMenu();
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1: listProducts(); break;
                case 2: addProduct(); break;
                case 3: updateProduct(); break;
                case 4: deleteProduct(); break;
                case 5: searchProductByName(); break;
                case 6: filterProducts(); break;
                case 7: sortProducts(); break;
                case 8: System.exit(0);
                default: System.out.println("lua chon khong hop le");
            }
        }
    }

    private static void displayMenu() {
        System.out.println("**************************MENU*************************");
        System.out.println("1. danh sach san pham");
        System.out.println("2. them san pham");
        System.out.println("3. cap nhat san pham");
        System.out.println("4. xoa san pham");
        System.out.println("5. tim kiem san pham");
        System.out.println("6. loc san pham");
        System.out.println("7. xap xep san pham");
        System.out.println("8. thoat");
        System.out.print("nhap lua chon: ");
    }

    private static void listProducts() {
        products.forEach(Product::displayData);
    }

    private static void addProduct() {
        Product product = new Product();
        product.inputData(scanner);
        products.add(product);
    }

    private static void updateProduct() {
        System.out.print("Enter product ID to update: ");
        int id = Integer.parseInt(scanner.nextLine());
        Optional<Product> optional = products.stream()
                .filter(p -> p.getProductId() == id)
                .findFirst();

        optional.ifPresentOrElse(
                product -> {
                    product.inputData(scanner);
                },
                () -> System.out.println("khong tim thay")
        );
    }

    private static void deleteProduct() {
        System.out.print("nhap id can xoa: ");
        int id = Integer.parseInt(scanner.nextLine());
        products.removeIf(p -> p.getProductId() == id);
    }

    private static void searchProductByName() {
        System.out.print("nhap ten can tim kiem: ");
        String name = scanner.nextLine();
        products.stream()
                .filter(p -> p.getProductName().toLowerCase().contains(name.toLowerCase()))
                .forEach(Product::displayData);
    }

    private static void filterProducts() {
        System.out.println("1. loc theo gia > X");
        System.out.println("2. loc theo danh muc");
        int choice = Integer.parseInt(scanner.nextLine());

        if (choice == 1) {
            System.out.print("nhap gia toi thieu: ");
            float minPrice = Float.parseFloat(scanner.nextLine());
            ProductFilter priceFilter = p -> p.getPrice() > minPrice;
            products.stream()
                    .filter(priceFilter::filter)
                    .forEach(Product::displayData);
        } else {
            System.out.print("nhap danh muc: ");
            String category = scanner.nextLine();
            ProductFilter categoryFilter = p -> p.getCategory().equalsIgnoreCase(category);
            products.stream()
                    .filter(categoryFilter::filter)
                    .forEach(Product::displayData);
        }
    }

    private static void sortProducts() {
        System.out.println("1. tang dan");
        System.out.println("2. giam dan");
        int choice = Integer.parseInt(scanner.nextLine());

        List<Product> sortedProducts = products.stream()
                .sorted(choice == 1 ?
                        Comparator.comparing(Product::getPrice) :
                        Comparator.comparing(Product::getPrice).reversed())
                .toList();

        sortedProducts.forEach(Product::displayData);
    }
}