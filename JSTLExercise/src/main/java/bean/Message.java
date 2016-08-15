package bean;

/**
 * Created by zhuxinquan on 16-8-14.
 */
public class Message {
    private String name;
    private String desc;

    public Message() {
    }

    public Message(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
