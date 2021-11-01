package user;

public class Sender extends User {
    public void update(String status) {
        System.out.println("Sender updated with message: " + status);
    }
}
