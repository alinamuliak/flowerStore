package decorators;
import flowerstore.Item;
public class PaperDecorator extends ItemDecorator {
    private Item item;
    public PaperDecorator(Item item) {
        super(item);
    }

    @Override
    public double getPrice() {
        return 13 + item.getPrice();
    }
}