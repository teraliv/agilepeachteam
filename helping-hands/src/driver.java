import model.*;

public class driver {

    public static void main(String[] args) {

        FileReader fr = new FileReader();
        fr.readDonorsFile();
        fr.readRecipientsFile();

        DonorContainer dc = DonorContainer.getInstance();
        RecipientContainer rc = RecipientContainer.getInstance();

        for (Recipient current : rc.recipients.values()) {
            System.out.println(current.firstName);
        }
    }

}
