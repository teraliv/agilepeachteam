package junittests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import model.*;

public class testclass {
	
	public int postest = 1;
	//bad values
	public Donor badDonerinstace = new Donor("Tester", "lastName", "DOBMonth", "DOBDay", "DOBYear", 
			"gender", "street", "city", "state", "zip", "email", "username", "password", null);
	public Donor goodDonerinstace = new Donor("Eater", "lastName", "DOBMonth", "DOBDay", "DOBYear", 
			"gender", "street", "city", "state", "zip", "email", "username", "password", null);
	public Item donorBasicItem = new Item("Ham", "Food", 3, 7.00);
	//Container self serving objects
	public Inventory ivInventory = Inventory.getInstance();
	public RecipientContainer myRecipentContainer = RecipientContainer.getInstance();
	//Sample Arrays
	public ArrayList<Item> myItemArray = new ArrayList<>();
	ArrayList<Item> mySecondItemArray = new ArrayList<>();
	//
	@Before
	public void setUp() throws Exception {

	}
	@Test
	public final void testDonorObjectsEquality() {
		//equality with a new doner
		assertNotEquals(badDonerinstace, new Donor("Tester", "lastName", "DOBMonth", "DOBDay", "DOBYear", 
			"gender", "street", "city", "state", "zip", "email", "username", "password", null));
		//object with changed strings
		assertNotEquals(badDonerinstace, goodDonerinstace);
	}

	@Test
	public final void testAddDonatedItem() {
		
		//is donor size more than 3 now?
		donorBasicItem.quantity++;
		myItemArray.add(donorBasicItem);
	}

	@Test
	public final void testQuantitySuccess() {
		int pos = 1;
		if(donorBasicItem.quantity > pos )
		{
			assertTrue(true);
		}	
	}
	
	@Test
	public final void testQuantityFalirures() {
		//Test positions and quality of objects
		int pos = 1;
		if(donorBasicItem.quantity < pos )
		{
			assertTrue(false);
		}	
	}
	
	@Test
	public final void testQuantityKill() {
		//Test positions and quality of objects
		int pos = 1;
		if(donorBasicItem.quantity > pos )
		{
			assertTrue(true);
		}	
	}
	
	//View 
	@Test
	public final void InventoryTests() {
		//Test positions and quality of objects
		if(Inventory.getInstance().isItemExist("socks")) {
			assertTrue(true);
			
		}
	}
	
	@Test
	public final void InventoryArrayHoldTest() {
		//Test positions and quality of objects
		myItemArray.add(donorBasicItem); 
		if(Inventory.getInstance().isItemExist("hat") && myItemArray.isEmpty()) {
			assertTrue(true);
			
		}
	}
	@Test
	public final void InventoryKillTest() {
		//Test positions and quality of objects
		myItemArray.add(donorBasicItem);
		if(Inventory.getInstance().isItemExist("Ham") && myItemArray.isEmpty()) {
			assertTrue(true);
			
		}
	}
	//Recipents Correct?
	@Test
	public final void RecpientControlTest() {
		//Test positions and quality of objects
		if(myRecipentContainer.equals(goodDonerinstace)) { //example amount vs set amount
			assertEquals("We are good", myRecipentContainer.totalRecipients, 20);
			
		}
	}
}