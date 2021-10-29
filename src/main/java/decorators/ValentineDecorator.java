package decorators;

import flowerstore.Item;

public class ValentineDecorator extends ItemDecorator {
    private Item item;
    public ValentineDecorator(Item item) {
        super(item);
    }

    @Override
    public double getPrice() {
        return item.getPrice() * 0.70;
    }
}
