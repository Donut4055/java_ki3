package practice2.Entity;

public class Product {
    private String productId;
    private String productName;
    private float importPrice;
    private float exportPrice;
    private float profit;
    private int quantity;
    private String descriptions;
    private boolean status;

    // Constructor mặc định
    public Product() {
    }

    // Constructor đầy đủ tham số
    public Product(String productId, String productName, float importPrice, float exportPrice,
                   int quantity, String descriptions, boolean status) {
        this.productId = productId;
        this.productName = productName;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.quantity = quantity;
        this.descriptions = descriptions;
        this.status = status;
    }

    // Getters và Setters
    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }
    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }
    public float getImportPrice() { return importPrice; }
    public void setImportPrice(float importPrice) { this.importPrice = importPrice; }
    public float getExportPrice() { return exportPrice; }
    public void setExportPrice(float exportPrice) { this.exportPrice = exportPrice; }
    public float getProfit() { return profit; }
    public void setProfit(float profit) { this.profit = profit; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
    public String getDescriptions() { return descriptions; }
    public void setDescriptions(String descriptions) { this.descriptions = descriptions; }
    public boolean isStatus() { return status; }
    public void setStatus(boolean status) { this.status = status; }
}