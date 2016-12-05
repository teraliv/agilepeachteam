import model.*;

public class driver {

    public static void main(String[] args) {

        FileReader fr = new FileReader();
        fr.readDonorsFile();
        fr.readRecipientsFile();
        fr.readDonatedItemsFile();

        DonorContainer dc = DonorContainer.getInstance();
        Donor donor = dc.getDonorByLogin("jevans0");

        //for (Item current : donor.donatedItems) {
        //    System.out.println(current.name);
        //}

    }

}
