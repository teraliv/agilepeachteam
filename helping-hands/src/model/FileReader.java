/**
 * @author Aygun Avazova
 */

package model;

import java.io.*;
import java.util.Scanner;

public class FileReader {

    private DonorContainer      dc;
    private RecipientContainer  rc;
    private Inventory           inventory;

    private String firstName;
    private String lastName;
    private String month ;
    private String day;
    private String year;
    private String gender;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String email;
    private String businessName;
    private String username;
    private String password;

    private String itemName;
    private String itemCategory;
    private int    itemQuantity;
    private Double itemPrice;

    public FileReader() {
        // empty constructor
    }

    /**
     * Reads donors data from file.
     */
    public void readDonorsFile() throws IOException {

        InputStream         is  = this.getClass().getResourceAsStream("donors-data.csv");
        InputStreamReader   isr = new InputStreamReader(is);
        BufferedReader      br  = new BufferedReader(isr);

        dc = DonorContainer.getInstance();

        String line;

        while ((line = br.readLine()) != null) {

            String[] split = line.split(",");

            firstName       = split[0];
            lastName        = split[1];
            month           = split[2];
            day             = split[3];
            year            = split[4];
            gender          = split[5];
            street          = split[6];
            city            = split[7];
            state           = split[8];
            zip             = split[9];
            email           = split[10];
            businessName    = split[11];
            username        = split[12];
            password        = split[13];

            Donor donor = new Donor(firstName, lastName, month, day, year, gender, street, city, state, zip,
                    email, businessName, username, password);
            dc.addDonor(donor);
        }

        is.close();
        isr.close();
        br.close();
    }
    //public void readDonorsFile() {
    //
    //    Scanner fileScanner = null;
    //    dc = DonorContainer.getInstance();
    //
    //    try {
    //        fileScanner = new Scanner(new FileInputStream("./src/files/donors-data.csv"));
    //
    //        while (fileScanner.hasNextLine()) {
    //            String line = fileScanner.nextLine();
    //            //System.out.println(line);
    //
    //            String[] split = line.split(",");
    //
    //            firstName       = split[0];
    //            lastName        = split[1];
    //            month           = split[2];
    //            day             = split[3];
    //            year            = split[4];
    //            gender          = split[5];
    //            street          = split[6];
    //            city            = split[7];
    //            state           = split[8];
    //            zip             = split[9];
    //            email           = split[10];
    //            businessName    = split[11];
    //            username        = split[12];
    //            password        = split[13];
    //
    //            Donor donor = new Donor(firstName, lastName, month, day, year, gender, street, city, state, zip,
    //                    email, businessName, username, password);
    //            dc.addDonor(donor);
    //        }
    //    }
    //    catch (FileNotFoundException e) {
    //        System.out.println("Error reading file: " + e.getMessage());
    //    }
    //    finally {
    //        if (fileScanner != null) {
    //            fileScanner.close();
    //        }
    //    }
    //}


    /**
     * Reads recipients data from file.
     */
    public void readRecipientsFile() throws IOException {

        InputStream         is  = this.getClass().getResourceAsStream("recipients-data.csv");
        InputStreamReader   isr = new InputStreamReader(is);
        BufferedReader      br  = new BufferedReader(isr);

        rc = RecipientContainer.getInstance();

        String line;

        while ((line = br.readLine()) != null) {

            String[] split = line.split(",");

            firstName   = split[0];
            lastName    = split[1];
            month       = split[2];
            day         = split[3];
            year        = split[4];
            gender      = split[5];
            street      = split[6];
            city        = split[7];
            state       = split[8];
            zip         = split[9];
            email       = split[10];
            username    = split[11];
            password    = split[12];

            Recipient recipient = new Recipient(firstName, lastName, month, day, year, gender, street,
                    city, state, zip, email, username, password);

            rc.addRecipient(recipient);
        }

        is.close();
        isr.close();
        br.close();
    }
    //public void readRecipientsFile() {
    //
    //    Scanner fileScanner = null;
    //    rc = RecipientContainer.getInstance();
    //
    //    try {
    //        fileScanner = new Scanner(new FileInputStream("./src/files/recipients-data.csv"));
    //
    //        while (fileScanner.hasNextLine()) {
    //            String      line  = fileScanner.nextLine();
    //            String[]    split = line.split(",");
    //
    //            firstName       = split[0];
    //            lastName        = split[1];
    //            month           = split[2];
    //            day             = split[3];
    //            year            = split[4];
    //            gender          = split[5];
    //            street          = split[6];
    //            city            = split[7];
    //            state           = split[8];
    //            zip             = split[9];
    //            email           = split[10];
    //            username        = split[11];
    //            password        = split[12];
    //
    //            Recipient recipient = new Recipient(firstName, lastName, month, day, year, gender, street,
    //                                                city, state, zip, email, username, password);
    //            rc.addRecipient(recipient);
    //
    //        }
    //    }
    //    catch (FileNotFoundException e) {
    //        System.out.println("Error reading file: " + e.getMessage());
    //    }
    //    finally {
    //        if (fileScanner != null) {
    //            fileScanner.close();
    //        }
    //    }
    //}



    public void readDonatedItemsFile() throws IOException {

        InputStream         is  = this.getClass().getResourceAsStream("donated-data.csv");
        InputStreamReader   isr = new InputStreamReader(is);
        BufferedReader      br  = new BufferedReader(isr);

        dc          = DonorContainer.getInstance();
        inventory   = Inventory.getInstance();

        String line;

        while ((line = br.readLine()) != null) {
            String[]    split = line.split(",");

            username        = split[0];
            itemName        = split[1];
            itemCategory    = split[2];
            itemQuantity    = Integer.parseInt(split[3]);
            itemPrice       = Double.parseDouble(split[4]);

            Item    item = new Item(itemName, itemCategory, itemQuantity, itemPrice);
            Donor   donor = dc.getDonorByLogin(username);

            donor.addDonatedItem(item);
        }

        is.close();
        isr.close();
        br.close();
    }
    //public void readDonatedItemsFile() {
    //    Scanner fileScanner = null;
    //    dc          = DonorContainer.getInstance();
    //    inventory   = Inventory.getInstance();
    //
    //    try {
    //        fileScanner = new Scanner(new FileInputStream("./src/files/donated-data.csv"));
    //
    //        while (fileScanner.hasNextLine()) {
    //            String      line  = fileScanner.nextLine();
    //            String[]    split = line.split(",");
    //
    //            username        = split[0];
    //            itemName        = split[1];
    //            itemCategory    = split[2];
    //            itemQuantity    = Integer.parseInt(split[3]);
    //            itemPrice       = Double.parseDouble(split[4]);
    //
    //            Item    item = new Item(itemName, itemCategory, itemQuantity, itemPrice);
    //            Donor   donor = dc.getDonorByLogin(username);
    //
    //            donor.addDonatedItem(item);
    //        }
    //    }
    //    catch (FileNotFoundException e) {
    //        System.out.println("Error reading file: " + e.getMessage());
    //    }
    //    finally {
    //        if (fileScanner != null) {
    //            fileScanner.close();
    //        }
    //    }
    //}



    public void readInventoryFile() throws IOException{

        InputStream         is  = this.getClass().getResourceAsStream("inventory-data.csv");
        InputStreamReader   isr = new InputStreamReader(is);
        BufferedReader      br  = new BufferedReader(isr);

        inventory   = Inventory.getInstance();

        String line;

        while ((line = br.readLine()) != null) {
            String[]    split = line.split(",");

            itemName        = split[0];
            itemCategory    = split[1];
            itemQuantity    = Integer.parseInt(split[2]);
            itemPrice       = Double.parseDouble(split[3]);

            Item item = new Item(itemName, itemCategory, itemQuantity, itemPrice);

            inventory.addItem(item);
        }

        is.close();
        isr.close();
        br.close();
    }
    //public void readInventoryFile() {
    //    Scanner fileScanner = null;
    //    inventory   = Inventory.getInstance();
    //
    //    try {
    //        fileScanner = new Scanner(new FileInputStream("./src/files/inventory-data.csv"));
    //
    //        while (fileScanner.hasNextLine()) {
    //            String      line  = fileScanner.nextLine();
    //            String[]    split = line.split(",");
    //
    //            itemName        = split[0];
    //            itemCategory    = split[1];
    //            itemQuantity    = Integer.parseInt(split[2]);
    //            itemPrice       = Double.parseDouble(split[3]);
    //
    //            Item item = new Item(itemName, itemCategory, itemQuantity, itemPrice);
    //
    //            inventory.addItem(item);
    //        }
    //    }
    //    catch (FileNotFoundException e) {
    //        System.out.println("Error reading file: " + e.getMessage());
    //    }
    //    finally {
    //        if (fileScanner != null) {
    //            fileScanner.close();
    //        }
    //    }
    //}

}
