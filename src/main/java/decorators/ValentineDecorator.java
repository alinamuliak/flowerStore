package decorators;

import flowerstore.Item;

public class ValentineDecorator extends ItemDecorator {

    public ValentineDecorator(Item item) {
        super(item);
    }

    @Override
    public double getPrice() {
        return this.getItem().getPrice() * 0.70;
    }
}
