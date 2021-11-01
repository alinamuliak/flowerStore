package user;

public class Sender implements User {
    public void update(String status) {
        System.out.println("Sender updated with message: " + status);
    }
}
