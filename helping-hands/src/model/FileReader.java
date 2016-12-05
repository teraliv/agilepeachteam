/**
 * @author Alex Terikov (teraliv@uw.edu)
 */

package model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReader {

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

    public FileReader() {
        // empty constructor
    }

    /**
     * Reads donors data from file.
     */
    public void readDonorsFile() {

        Scanner fileScanner = null;
        DonorContainer dc = DonorContainer.getInstance();

        try {
            fileScanner = new Scanner(new FileInputStream("./src/files/donors-data.csv"));

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                //System.out.println(line);

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

                Donor donor = new Donor(firstName,lastName,month,day,year,gender,street,city,state,zip,email,businessName,username,password);
                dc.addDonor(donor);
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        finally {
            if (fileScanner != null) {
                fileScanner.close();
            }
        }
    }


    /**
     * Reads recipients data from file.
     */
    public void readRecipientsFile() {

        Scanner fileScanner = null;
        RecipientContainer rc = RecipientContainer.getInstance();

        try {
            fileScanner = new Scanner(new FileInputStream("./src/files/recipients-data.csv"));

            while (fileScanner.hasNextLine()) {
                String      line  = fileScanner.nextLine();
                String[]    split = line.split(",");

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
                username        = split[11];
                password        = split[12];

                Recipient recipient = new Recipient(firstName,lastName,month,day,year,gender,street,city,state,zip,email,username,password);
                rc.addRecipient(recipient);

            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        finally {
            if (fileScanner != null) {
                fileScanner.close();
            }
        }
    }

}
