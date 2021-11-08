package user;

public class Receiver extends User {
    public int update(String status) {
        System.out.println("Receiver updated with message: " + status);
        return 0;
    }
}
