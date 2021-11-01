package user;

public class Receiver extends User {
    public void update(String status) {
        System.out.println("Receiver updated with message: " + status);
    }
}
