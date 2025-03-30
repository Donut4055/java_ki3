package bt10;

import java.util.ArrayList;

class ShoppingCart {
    private ArrayList<CartItem> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addToCart(Product product, int quantity) throws Exception {
        if (quantity <= 0) {
            throw new Exception("Lỗi: Số lượng không hợp lệ!");
        }

        for (CartItem item : items) {
            if (item.getProduct().getId().equals(product.getId())) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        items.add(new CartItem(product, quantity));
    }

    public void removeFromCart(String productId) throws Exception {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getProduct().getId().equals(productId)) {
                items.remove(i);
                return;
            }
        }
        throw new Exception("Lỗi: Không tìm thấy sản phẩm trong giỏ hàng!");
    }

    public void displayCart() {
        if (items.isEmpty()) {
            System.out.println("Giỏ hàng trống!");
        } else {
            System.out.println("\n=== GIỎ HÀNG ===");
            for (CartItem item : items) {
                System.out.println(item.getProduct() + " | Số lượng: " + item.getQuantity() +
                        " | Thành tiền: " + item.getSubtotal() + " đồng");
            }
        }
    }

    public void checkout() {
        if (items.isEmpty()) {
            System.out.println("Giỏ hàng trống, không có gì để thanh toán!");
        } else {
            double total = 0;
            for (CartItem item : items) {
                total += item.getSubtotal();
            }
            System.out.println("Tổng tiền cần thanh toán: " + total + " đồng");
        }
    }
}

