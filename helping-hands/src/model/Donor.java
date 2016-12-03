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
    public final String     username;
    public final String     password;

	public String userName;

    /**
     * Creates new Donor.
     * @param name - donor's firstName.
     */
    public Donor(String firstName, String lastName, String DOBMonth, String DOBDay, String DOBYear, String gender, String street,
            String city, String state, String zip, String email, String username, String password) {

		this.firstName  = firstName;
		this.lastName   = lastName;
		this.DOBMonth   = DOBMonth;
		this.DOBDay     = DOBDay;
		this.DOBYear    = DOBYear;
		this.gender     = gender;
		this.street     = street;
		this.city       = city;
		this.state      = state;
		this.zip        = zip;
		this.email      = email;
		this.username   = username;
		this.password   = password;
		this.donatedItems  = new ArrayList<>();
		}


    public void addDonatedItem(Item item) {
    	donatedItems.add(item);
    }
    
    public Item getDonatedItem(int pos)
    {
    	if(donatedItems.size() > pos)
    	{
    		return donatedItems.get(pos);
    	}
    	
    	return null;
    }
}