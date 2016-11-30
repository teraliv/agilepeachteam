package model;


import java.util.HashMap;
import java.util.Map;

public class RecipientContainer {

    public final Map<String, Recipient>     recipients;
    public int                              totalRecipients;


    public RecipientContainer() {
        this.recipients         = new HashMap<>();
        this.totalRecipients    = 0;
    }


    public void addRecipient(Recipient recipient) {
        recipients.put(recipient.name, recipient);
        totalRecipients++;
    }


    public boolean isRecipient(String name) {
        return recipients.containsKey(name);
    }
}
