package flowerstore;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Setter @Getter @ToString
public class FlowerBucket extends Item {
    private List<FlowerPack> flowerPacks = new ArrayList<>();


    public void addFlowerPack(FlowerPack flowerPack) {
        flowerPacks.add(flowerPack);
    }

    public double getPrice() {
        double price = 0;
        for (FlowerPack flowerPack : this.flowerPacks) {
            price += flowerPack.getPrice();
        }
        return price;
    }

    /**
     * Return true if given flower is in this flower bucket.
     * False otherwise.
     * @param flower Flower object representing the flower the user is looking for
     * @return boolean
     */
    public boolean searchFlower(Flower flower) {
        //pass
        return true;
    }
}
