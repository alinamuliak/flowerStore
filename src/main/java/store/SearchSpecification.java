package store;

import flowerstore.Flower;

import java.util.ArrayList;

public abstract class SearchSpecification {
    public ArrayList<Flower> filter(ArrayList<Flower> flowers) {
        return applyFilter(flowers);
    }

    protected abstract ArrayList<Flower> applyFilter(ArrayList<Flower> flowers);
}
