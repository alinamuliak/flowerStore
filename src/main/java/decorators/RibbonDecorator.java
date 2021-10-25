package decorators;

import flowerstore.Item;

public class RibbonDecorator extends ItemDecorator {
    private Item item;
    public RibbonDecorator(Item item) {
        super(item);
    }

    @Override
    public double getPrice() {
        return 40 + item.getPrice();
    }
}
