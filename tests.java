
package junittests;

import static org.junit.Assert.*;


import java.sql.Array;
import java.util.ArrayList;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import model.Donor;
import model.Inventory;
import model.Item;
import model.Recipient;
import view.DonorHomePage;

/**
 * Author Artem Davtyan - era99@uw.edu
 */

public class tests {
	//Donor tests
	public int postest = 1;
	//bad values
	public Donor badDonerinstace = new Donor("Good", "lastName", "DOBMonth", "DOBDay", "DOBYear", 
			"gender", "street", "city", "state", "zip", "email", "username", "password");
	public Donor goodDonerinstace = new Donor("Bad", "lastName", "DOBMonth", "DOBDay", "DOBYear", 
			"gender", "street", "city", "state", "zip", "email", "username", "password");
	//Item Tests
	public Item donorBasicItem = new Item("Ham", "Food", 3, 7.00);
	//Item Array#1
	public ArrayList<Item> myItemArray = new ArrayList<>();
	//Item Array#2
	public ArrayList<Item> mySecondItemArray = new ArrayList<>();
	//Recipient Tests
	public Recipient goodrecipientTest = new Recipient("Good", "lastName", "DOBMonth", "DOBDay", "DOBYear", 
			"gender", "street", "city", "state", "zip", "email", "username", "password");
	public Recipient badRecipientTest = new Recipient("Bad", "lastName", "DOBMonth", "DOBDay", "DOBYear", 
			"gender", "street", "city", "state", "zip", "email", "username", "password");
	@Before
	public void setUp() throws Exception {

	}
	//Objects
	@Test
	public final void testDonorObjectsEquality() {
		//equality with a new doner
		assertNotEquals(badDonerinstace, new Donor("Tester", "lastName", "DOBMonth", "DOBDay", "DOBYear", 
			"gender", "street", "city", "state", "zip", "email", "username", "password"));
		//object with changed strings
		assertNotEquals(badDonerinstace, goodDonerinstace);
	}
	//Donor
	@Test
	public final void testAddDonatedItem() {
		//is donor size more than 3 now?
		donorBasicItem.quantity++;
		myItemArray.add(donorBasicItem);
		myItemArray.add(donorBasicItem);
		myItemArray.add(donorBasicItem);
		assertEquals(myItemArray.size(), 3);
		
	}
	//Item
	@Test
	public final void testQuantitySuccess() {
		int pos = 1;
		if(donorBasicItem.quantity > pos )
		{
			assertTrue(true);
		}	
	}
	//Donor
	@Test
	public final void testQuantityFalirures() {
		//Test positions and quality of objects
		int pos = 1;
		if(donorBasicItem.quantity < pos )
		{
			assertTrue(false);
		}	
	}
	//Recipient
	@Test
	public void testRecipient() {
		//Check if recipients and Donors are the same
		assertNotSame(goodDonerinstace, goodrecipientTest);
		//They are not of the same type or instance, so
		//they shouldn't be the same, even when the strings are. 
		assertNotSame(badDonerinstace, badRecipientTest);
		//Test our objects
		assertNotSame(badDonerinstace, goodDonerinstace);
	}

	@Test
	public void testEquals() {
		//Check against two way errors for the instances
		assertNotEquals(badDonerinstace, goodDonerinstace);
		assertNotEquals(badDonerinstace, badRecipientTest);
		assertNotEquals(goodDonerinstace, goodrecipientTest);
	}
	//Donor, Item, Recipient
	@Test
	public void testToString() {
		assertNotEquals(goodrecipientTest.toString(), goodDonerinstace.toString());
	}

	


}
