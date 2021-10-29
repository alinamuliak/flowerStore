package store;

import flowerstore.Flower;

import java.util.ArrayList;


public class SepalLengthFilterSpecification extends SearchSpecification {
    private double sepalLength;

    public SepalLengthFilterSpecification(double sepalLength) {
        this.sepalLength = sepalLength;
    }

    @Override
    protected ArrayList<Flower> applyFilter(ArrayList<Flower> flowers) {
        ArrayList<Flower> filteredFlowers = new ArrayList<>();
        for(Flower flower: flowers) {
            if (flower.getSepalLength() == sepalLength) {
                filteredFlowers.add(flower);
            }
        }
        return filteredFlowers;
    }
}
