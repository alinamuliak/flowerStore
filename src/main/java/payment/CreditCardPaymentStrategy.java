package payment;

public class CreditCardPaymentStrategy implements Payment{
    @Override
    public int pay(double price) {
        System.out.println("Payed " + price + " $ with Credit Card.");
        return 0;
    }
}
