package cc.openhome;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhuxinquan on 16-3-5.
 */
public class HelloModel {
    private Map<String, String> messages = new HashMap<>();

    public HelloModel(){
        messages.put("caterpillar", "Hello");
        messages.put("Justin", "Welcome");
        messages.put("momor", "Hi");
    }

    public String doHello(String user) {
        String message = messages.get(user);
        return message + ", " + user + "!";
    }
}
