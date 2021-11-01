package user;

public class IdCounter {
    static int id;
    public static int createId() {
        id++;
        return id;
    }
}
