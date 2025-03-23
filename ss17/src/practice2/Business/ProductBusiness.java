package practice2.Business;

import practice2.Entity.Product;
import java.util.Arrays;
import java.util.Comparator;

public class ProductBusiness {
    public static void calculateProfit(Product product) {
        float profit = product.getExportPrice() - product.getImportPrice();
        product.setProfit(profit);  // Gán profit vào đối tượng Product
    }

    public static void sortByProfit(Product[] arrProduct, int size) {
        Arrays.sort(arrProduct, 0, size, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                // Kiểm tra null để tránh lỗi
                if (p1 == null || p2 == null) return 0;
                return Float.compare(p2.getProfit(), p1.getProfit());
            }
        });
    }

    public static int countProductsByPriceRange(Product[] arrProduct, int size, float fromPrice, float toPrice) {
        int count = 0;
        for (int i = 0; i < size; i++) {
            if (arrProduct[i] != null && arrProduct[i].getExportPrice() >= fromPrice && arrProduct[i].getExportPrice() <= toPrice) {
                count++;
            }
        }
        return count;
    }

    public static void importProduct(Product[] arrProduct, int size, String productId, int quantity) {
        for (int i = 0; i < size; i++) {
            if (arrProduct[i] != null && arrProduct[i].getProductId().equals(productId)) {
                arrProduct[i].setQuantity(arrProduct[i].getQuantity() + quantity);
                break;
            }
        }
    }

    public static boolean sellProduct(Product[] arrProduct, int size, String productName, int quantity) {
        for (int i = 0; i < size; i++) {
            if (arrProduct[i] != null && arrProduct[i].getProductName().equals(productName) && arrProduct[i].getQuantity() >= quantity) {
                arrProduct[i].setQuantity(arrProduct[i].getQuantity() - quantity);
                return true;
            }
        }
        return false;
    }

    public static void updateStatus(Product[] arrProduct, int size, String productId) {
        for (int i = 0; i < size; i++) {
            if (arrProduct[i] != null && arrProduct[i].getProductId().equals(productId)) {
                arrProduct[i].setStatus(!arrProduct[i].isStatus());
                break;
            }
        }
    }
}