package user;

public class Receiver implements User {
    public void update(String status) {
        System.out.println("Receiver updated with message: " + status);
    }
}
