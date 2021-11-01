package user;


public interface User {
    int id = IdCounter.createId();
    void update(String status);
}
