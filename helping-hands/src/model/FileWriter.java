/**
 * @author Aygun Avazova
 */

package model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class FileWriter {

    public FileWriter() {
        // empty constructor
    }


    /**
     * A method to write a new Donor to the CSV file. The next time the program runs this Donor will be available
     * to use its username and password to login to the system.
     * @param donor
     */
    public void writeNewDonor(Donor donor) {

        PrintWriter writer = null;
        boolean     append = true;

        try {
            writer = new PrintWriter(new FileOutputStream("./src/files/donors-data.csv", append));

            StringBuilder sb = new StringBuilder();

            sb.append(donor.firstName + ",");
            sb.append(donor.lastName + ",");
            sb.append(donor.DOBMonth + ",");
            sb.append(donor.DOBDay + ",");
            sb.append(donor.DOBYear + ",");
            sb.append(donor.gender + ",");
            sb.append(donor.street + ",");
            sb.append(donor.city + ",");
            sb.append(donor.state + ",");
            sb.append(donor.zip + ",");
            sb.append(donor.email + ",");
            sb.append(donor.business + ",");
            sb.append(donor.username + ",");
            sb.append(donor.password);

            writer.println(sb.toString());
        }
        catch (FileNotFoundException e) {
            System.out.println("There was a problem writing to the file: " + e.getMessage());
        }
        finally {
            if (writer != null) {
                writer.close();
            }
        }
    }


    /**
     * A method to write a new Recipient to the CSV file. The next time the program runs this Recipient will be available
     * to use its username and password to login to the system.
     * @param recipient
     */
    public void writeNewRecipient(Recipient recipient) {

        PrintWriter writer = null;
        boolean     append = true;

        try {
            writer = new PrintWriter(new FileOutputStream("./src/files/recipients-data.csv", append));

            StringBuilder sb = new StringBuilder();

            sb.append(recipient.firstName + ",");
            sb.append(recipient.lastName + ",");
            sb.append(recipient.DOBMonth + ",");
            sb.append(recipient.DOBDay + ",");
            sb.append(recipient.DOBYear + ",");
            sb.append(recipient.gender + ",");
            sb.append(recipient.street + ",");
            sb.append(recipient.city + ",");
            sb.append(recipient.state + ",");
            sb.append(recipient.zip + ",");
            sb.append(recipient.email + ",");
            sb.append(recipient.username + ",");
            sb.append(recipient.password);

            writer.println(sb.toString());
        }
        catch (FileNotFoundException e) {
            System.out.println("There was a problem writing to the file: " + e.getMessage());
        }
        finally {
            if (writer != null) {
                writer.close();
            }
        }
    }


    /**
     * A method to write donated items to the CSV file. The first field in the file is username. Usernames are
     * unique across all users, so it works as identifier for a donation.
     * @param donor
     * @param item
     */
    public void writeNewDonation(Donor donor, Item item) {

        PrintWriter writer = null;
        boolean     append = true;

        try {
            writer = new PrintWriter(new FileOutputStream("./src/files/donated-data.csv", append));

            StringBuilder sb = new StringBuilder();

            sb.append(donor.username + ",");    // Username is the identifier of the donated item.
            sb.append(item.name + ",");
            sb.append(item.category + ",");
            sb.append(item.quantity + ",");
            sb.append(item.price);

            writer.println(sb.toString());
        }
        catch (FileNotFoundException e) {
            System.out.println("There was a problem writing to the file: " + e.getMessage());
        }
        finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    public void writeInventoryData() {

        Inventory inventory = Inventory.getInstance();

        PrintWriter writer = null;

        try {
            writer = new PrintWriter(new FileOutputStream("./src/files/inventory-data.csv"));

            String line = null;

            for (Item current : inventory.availableItems) {
                line = (current.name + "," + current.category + "," + current.quantity + "," +current.price);
                writer.println(line);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("There was a problem writing to the file: " + e.getMessage());
        }
        finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

}
