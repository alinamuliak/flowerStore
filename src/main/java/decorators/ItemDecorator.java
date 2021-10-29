package decorators;

import flowerstore.Item;
import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class ItemDecorator extends Item {
    private Item item;


    public ItemDecorator(Item item) {
        this.item = item;
    }

    @Override
    public double getPrice() {
        return this.item.getPrice();
    }

    @Override
    public String getDescription() {
        return this.item.getDescription();
    }
}
