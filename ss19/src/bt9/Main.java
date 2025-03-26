package bt9;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Product("Laptop", 1200.0),
                new Product("Mouse", 25.0),
                new Product("Keyboard", 80.0),
                new Product("Monitor", 300.0),
                new Product("Headphones", 90.0)
        );

        ProductProcessor processor = new ProductProcessorImpl();

        boolean hasExpensive = processor.hasExpensiveProduct(products);
        System.out.println("Có sản phẩm giá > 100 không? " + hasExpensive);

        if (hasExpensive) {
            List<Product> expensiveProducts = products.stream()
                    .filter(product -> product.getPrice() > 100)
                    .collect(Collectors.toList());
            System.out.println("Các sản phẩm có giá > 100:");
            expensiveProducts.forEach(System.out::println);
        } else {
            System.out.println("Không có sản phẩm đắt tiền");
        }

        double totalValue = processor.calculateTotalValue(products);
        System.out.println("Tổng giá trị của tất cả sản phẩm: " + totalValue);

        ProductProcessor.printProductList(products);
    }
}
