package bt10;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product("P001", "Áo thun", 150000));
        products.add(new Product("P002", "Quần jeans", 300000));
        products.add(new Product("P003", "Giày thể thao", 500000));

        ShoppingCart cart = new ShoppingCart();
        int choice = 0;
        do {
            System.out.println("\n=== HỆ THỐNG MUA SẮM ===");
            System.out.println("1. Xem danh sách sản phẩm");
            System.out.println("2. Thêm sản phẩm vào giỏ hàng");
            System.out.println("3. Xóa sản phẩm khỏi giỏ hàng");
            System.out.println("4. Xem giỏ hàng");
            System.out.println("5. Thanh toán");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");


            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập số hợp lệ!");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.println("\nDanh sách sản phẩm:");
                    for (Product p : products) {
                        System.out.println(p);
                    }
                    break;

                case 2:
                    System.out.print("Nhập mã sản phẩm: ");
                    String productId = sc.nextLine();
                    Product selectedProduct = null;
                    for (Product p : products) {
                        if (p.getId().equals(productId)) {
                            selectedProduct = p;
                            break;
                        }
                    }
                    if (selectedProduct == null) {
                        System.out.println("Sản phẩm không tồn tại!");
                    } else {
                        System.out.print("Nhập số lượng: ");
                        try {
                            int quantity = Integer.parseInt(sc.nextLine());
                            cart.addToCart(selectedProduct, quantity);
                            System.out.println("Đã thêm vào giỏ hàng!");
                        } catch (NumberFormatException e) {
                            System.out.println("Lỗi: Số lượng không hợp lệ!");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;

                case 3:
                    System.out.print("Nhập mã sản phẩm cần xóa: ");
                    String removeId = sc.nextLine();
                    try {
                        cart.removeFromCart(removeId);
                        System.out.println("Đã xóa sản phẩm khỏi giỏ hàng!");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    cart.displayCart();
                    break;

                case 5:
                    cart.displayCart();
                    cart.checkout();
                    break;

                case 0:
                    System.out.println("Cảm ơn bạn đã mua sắm!");
                    break;

                default:
                    System.out.println("Chức năng không hợp lệ!");
            }
        } while (choice != 0);

    }
}