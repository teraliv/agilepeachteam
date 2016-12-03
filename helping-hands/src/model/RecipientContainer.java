package model;


import java.util.HashMap;
import java.util.Map;

public class RecipientContainer {

	private static RecipientContainer instance = null;
    public final Map<String, Recipient>     recipients;
    public int                              totalRecipients;
    

    static public RecipientContainer GetInstance()
    {
    	if(instance == null) {
            instance = new RecipientContainer();
         }
         return instance;
    }
    
    protected RecipientContainer() {
        this.recipients         = new HashMap<>();
        this.totalRecipients    = 0;
    }

    public void addRecipient(Recipient recipient) {
        recipients.put(recipient.username, recipient);
        totalRecipients++;
    }

    public Recipient getRecipient(String userName) {
    	return recipients.get(userName);
    }

    public boolean isRecipient(String userName) {
        return recipients.containsKey(userName);
    }
}
