package flowerstore;


public abstract class Item {
    public abstract double getPrice();
    public String getDescription(){
        return this.toString();
    }
}
