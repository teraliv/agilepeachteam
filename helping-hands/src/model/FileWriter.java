/**
 * @author Alex Terikov (teraliv@uw.edu)
 */

package model;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class FileWriter {

    public FileWriter() {
        // empty constructor
    }


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


    public void writeNewDonation(Donor donor, Item item) {

        PrintWriter writer = null;
        boolean     append = true;

        try {
            writer = new PrintWriter(new FileOutputStream("./src/files/donated-data1.csv", append));

            StringBuilder sb = new StringBuilder();

            sb.append(donor.username + ",");
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

}
