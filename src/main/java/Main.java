import delivery.Delivery;
import delivery.PostDeliveryStrategy;
import flowerstore.Flower;
import payment.CreditCardPaymentStrategy;
import payment.Payment;

public class Main {
    public static void main(String[] args) {
//        Flower[] flowers = new Flower[5];
//        int[] color = {127, 0, 0};
//        for (int i = 0; i < flowers.length; i++){
//            flowers[i] = new Flower();
//        }
        Payment pay = new CreditCardPaymentStrategy();
        pay.pay(15);

    }
}
