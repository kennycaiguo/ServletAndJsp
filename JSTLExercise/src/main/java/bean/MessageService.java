package bean;


/**
 * Created by zhuxinquan on 16-8-14.
 */
public class MessageService {
    private Message[]  fakeMessage;

    public MessageService(){
        fakeMessage = new Message[3];
        fakeMessage[0] = new Message("caterpillar", "caterpillar's message");
        fakeMessage[1] = new Message("momor", "momor's message");
        fakeMessage[2] = new Message("hamimi", "hamimi's message");
    }

    public Message[] getMessage(){
        return fakeMessage;
    }
}
