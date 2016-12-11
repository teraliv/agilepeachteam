/**
 * @author Alex Terikov (teraliv@uw.edu)
 */

package model;

import java.util.ArrayList;
import java.util.List;

public class Donor {

    public final List<Item>   donatedItems;  
    
    public final String     firstName;
    public final String     lastName;
    public final String     DOBMonth;
    public final String     DOBDay;
    public final String     DOBYear;
    public final String     gender;
    public final String     street;
    public final String     city;
    public final String     state;
    public final String     zip;
    public final String     email;
    public final String     business;
    public final String     username;
    public final String     password;
    public boolean          activeUser;


    /**
     * Creates new Donor.
     */
    public Donor(String firstName, String lastName, String DOBMonth, String DOBDay, String DOBYear, String gender, String street,
            String city, String state, String zip, String email, String business, String username, String password) {

		this.firstName      = firstName;
		this.lastName       = lastName;
		this.DOBMonth       = DOBMonth;
		this.DOBDay         = DOBDay;
		this.DOBYear        = DOBYear;
		this.gender         = gender;
		this.street         = street;
		this.city           = city;
		this.state          = state;
		this.zip            = zip;
		this.email          = email;
		this.business       = business;
		this.username       = username;
		this.password       = password;
		this.activeUser     = false;
		this.donatedItems   = new ArrayList<>();
    }

    public void donate(Item item) {
        Inventory inventory = Inventory.getInstance();
        inventory.addItem(item);
        donatedItems.add(0, item);
    }

    public void addDonatedItem(Item item) {
    	donatedItems.add(0, item);
    }
    
    public Item getDonatedItem(int pos) {

        if(donatedItems.size() > pos) {
    		return donatedItems.get(pos);
    	}
    	
    	return null;
    }

    public void activateCurrentDonor() {
        this.activeUser = true;
    }

    public void deactivateCurrentDonor() {
        this.activeUser = false;
    }
}