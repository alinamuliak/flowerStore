package store;

import flowerstore.Flower;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter @Setter
public class Store {
    public ArrayList<Flower> search(ArrayList<Flower> flowers, SearchSpecification filterSpecification) {
        return filterSpecification.filter(flowers);
    }
}
