package bt10;

public class DebitCard extends PaymentMethod {
    public DebitCard(double amount) {
        super(amount);
    }

    @Override
    public double calculateFee() {
        return amount * 0.01;
    }

    @Override
    public double processPayment() {
        double fee = calculateFee();
        return amount + fee;
    }

    @Override
    public String processPayment(double amount, String currency) {
        this.amount = amount;
        double totalAmount = processPayment();
        return String.format("%.2f %s", totalAmount, currency);
    }

    @Override
    public String toString() {
        return "Debit Card";
    }
}
