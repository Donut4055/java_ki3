package bt8;

public class Main {
    public static void main(String[] args) {
        Product[] products = new Product[4];
        products[0] = new Product("Generic Item", 1000);
        products[1] = new Electronics("TV", 5000);
        products[2] = new Clothing("Shirt", 800);
        products[3] = new Food("Bread", 200);

        System.out.println("Giá sau chiết khấu mặc định:");
        for (Product p : products) {
            System.out.printf("%s: %.2f%n", p.toString(), p.getFinalPrice());
        }

        System.out.println("\nGiá sau chiết khấu khi mua 50 sản phẩm:");
        for (Product p : products) {
            System.out.printf("%s: %.2f%n", p.toString(), p.getFinalPrice(50));
        }

        System.out.println("\nGiá sau chiết khấu khi mua 150 sản phẩm:");
        for (Product p : products) {
            System.out.printf("%s: %.2f%n", p.toString(), p.getFinalPrice(150));
        }
    }
}
