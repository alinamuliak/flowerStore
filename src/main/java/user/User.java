package user;

import lombok.Getter;

@Getter
public abstract class User {
    private int id = IdCounter.createId();
    abstract public void update(String status);
}
