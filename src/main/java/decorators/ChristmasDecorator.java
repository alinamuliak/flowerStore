package decorators;

import flowerstore.Item;

public class ChristmasDecorator extends ItemDecorator {
    private Item item;
    public ChristmasDecorator(Item item) {
        super(item);
    }

    @Override
    public double getPrice() {
        return item.getPrice() * 0.70;
    }
}
