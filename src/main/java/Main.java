import flowerstore.Flower;
import flowerstore.FlowerType;
import flowerstore.Item;

public class Main {
    public static void main(String[] args) {
        Item flower = new Flower(10, 10, new int[]{1, 1}, FlowerType.CHAMOMILE);
        System.out.println(flower.getPrice());
    }
}
