import model.*;

public class driver {

    public static void main(String[] args) {

        DonorContainer      donors      = new DonorContainer();
        RecipientContainer  recipients  = new RecipientContainer();
        Inventory           inventory   = new Inventory();

        Item            pants       = new Item("pants", "Clothes", 5, 19.50);
        Donor           safeway     = new Donor("Safeway", inventory);
        //Recipient       vasia       = new Recipient("Vasia", inventory);

        donors.addDonor(safeway);
        //recipients.addRecipient(vasia);
        safeway.donate(pants);


        //vasia.getDonation("pants", 5);
        //vasia.getDonation("Mens shirt", 3);
        //System.out.println(inventory.getQuantity("pants"));
    }

}
