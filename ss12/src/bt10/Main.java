package bt10;

public class Main {
    public static void main(String[] args) {
        PaymentMethod[] payments = new PaymentMethod[3];
        payments[0] = new CreditCard(1000.0);
        payments[1] = new DebitCard(1000.0);
        payments[2] = new Cash(1000.0);

        System.out.println("Kết quả thanh toán:");
        for (PaymentMethod payment : payments) {
            System.out.println("Phương thức: " + payment.toString());
            System.out.printf("Phí: %.2f%n", payment.calculateFee());
            System.out.printf("Tổng số tiền: %.2f%n", payment.processPayment());
            System.out.println("------------------------");
        }

        System.out.println("\nThanh toán với đơn vị tiền tệ:");
        for (PaymentMethod payment : payments) {
            System.out.println("Phương thức: " + payment.toString());
            System.out.println("Thanh toán 2000 với USD: " +
                    payment.processPayment(2000.0, "USD"));
            System.out.println("Thanh toán 2000 với VND: " +
                    payment.processPayment(2000.0, "VND"));
            System.out.println("------------------------");
        }
    }
}
