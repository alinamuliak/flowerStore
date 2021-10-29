package payment;

public class PayPalPaymentStrategy implements Payment {
    @Override
    public int pay(double price) {
        System.out.println("Payed " + price + " $ with PayPal.");
        return 0;
    }
}