import flowerstore.Flower;
import flowerstore.FlowerType;
import flowerstore.Item;
import user.Receiver;
import user.Sender;
import user.User;

public class Main {
    public static void main(String[] args) {
        User user = new Receiver();
        System.out.println(user.getId());
        User user1 = new Sender();
        System.out.println(user1.getId());
    }
}
