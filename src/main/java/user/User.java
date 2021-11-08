package user;

import lombok.Getter;
import lombok.ToString;

@Getter @ToString
public abstract class User {
    private int id = IdCounter.createId();
    abstract public int update(String status);
}
