package learn.solar.domain;
import learn.solar.models.Panel;
import java.util.ArrayList;
import java.util.List;

public class PanelResult {
    private ArrayList<String> messages = new ArrayList<>();
    private Panel payload;

    public void addErrorMessage(String message){
        messages.add(message);
    }

    public boolean isSuccess(){
        return messages.size() == 0;
    }

    public List<String> getMessages() {
        return new ArrayList<>(messages);
    }

    public void setMessages(ArrayList<String> messages) {
        this.messages = messages;
    }

    public Panel getPayload() {
        return payload;
    }

    public void setPayload(Panel payload) {
        this.payload = payload;
    }
}
