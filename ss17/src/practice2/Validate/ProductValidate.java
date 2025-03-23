package practice2.Validate;

import practice2.Entity.Product;


public class ProductValidate {
    public static boolean validateProductId(String productId, Product[] arrProduct) {
        if (productId == null || productId.length() != 4) {
            return false;
        }
        for (Product p : arrProduct) {
            if (p != null && p.getProductId() != null && p.getProductId().equals(productId)) {
                return false;
            }
        }
        return true;
    }

    public static boolean validateProductName(String productName, Product[] arrProduct) {
        if (productName == null || productName.length() < 6 || productName.length() > 50) {
            return false;
        }
        for (Product p : arrProduct) {
            if (p != null && p.getProductName() != null && p.getProductName().equals(productName)) {
                return false;
            }
        }
        return true;
    }

    public static boolean validateImportPrice(float importPrice) {
        return importPrice > 0;
    }

    public static boolean validateExportPrice(float exportPrice, float importPrice) {
        return exportPrice >= importPrice * 1.2;
    }

    public static boolean validateQuantity(int quantity) {
        return quantity > 0;
    }
}