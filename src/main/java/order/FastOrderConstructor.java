package order;

import delivery.Delivery;
import delivery.PostDeliveryStrategy;
import flowerstore.Flower;
import flowerstore.FlowerBucket;
import flowerstore.FlowerPack;
import flowerstore.FlowerType;
import lombok.Getter;
import payment.PayPalPaymentStrategy;
import payment.Payment;

@Getter
public enum FastOrderConstructor {
    ROSE_BUCKET(new Flower(22, 10, new int[] {1, 2, 3}, FlowerType.ROSE)),
    TULIP_BUCKET(new Flower(17, 15, new int[] {7, 7, 7}, FlowerType.TULIP)),
    CHAMOMILE_BUCKET(new Flower(15, 5, new int[] {2, 2, 5}, FlowerType.CHAMOMILE));
    private Flower flower;

    FastOrderConstructor(Flower flower) {
        this.flower = flower;
    }

    public static Order createOrder(FastOrderConstructor bucket, int number_of_flowers) {
        FlowerPack pack = new FlowerPack(bucket.flower, number_of_flowers);
        FlowerBucket flower_bucket = new FlowerBucket();
        flower_bucket.addFlowerPack(pack);
        Delivery delivery = new PostDeliveryStrategy();
        Payment payment = new PayPalPaymentStrategy();
        Order order = new Order();
        order.addItem(flower_bucket);
        order.setDeliveryStrategy(delivery);
        order.setPaymentStrategy(payment);
        return order;
    }


}
