package bean;

import java.io.Serializable;

/**
 * Created by zhuxinquan on 16-8-11.
 */
public class User implements Serializable{
    private String name;
    private String valid;

    public String getValid() {
        return valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    public User(String name) {
        this.name = name;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
