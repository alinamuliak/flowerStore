package user;

public class Sender extends User {
    public int update(String status) {
        System.out.println("Sender updated with message: " + status);
        return 0;
    }
}

