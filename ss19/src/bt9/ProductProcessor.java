package bt9;

import java.util.List;

interface ProductProcessor {
    double calculateTotalValue(List<Product> products);

    static void printProductList(List<Product> products) {
        System.out.println("Danh sách sản phẩm:");
        products.forEach(product ->
                System.out.println("Tên: " + product.getName() + ", Giá: " + product.getPrice()));
    }

    default boolean hasExpensiveProduct(List<Product> products) {
        return products.stream()
                .anyMatch(product -> product.getPrice() > 100);
    }
}