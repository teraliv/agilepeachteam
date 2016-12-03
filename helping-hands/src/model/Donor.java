package model;

import java.util.ArrayList;
import java.util.List;

public class Donor {


    public final String       name;           // Donor's firstName. It could be personal or business firstName.
    public final List<Item>   donatedItems;   // List of donated availableItems by this donor.
    public final Inventory    inventory;
    public final String userName;

    /**
     * Creates new Donor.
     * @param name - donor's firstName.
     */
    public Donor(String name, Inventory inventory,String userName) {
        this.name           = name;
        this.donatedItems   = new ArrayList<>();
        this.inventory      = inventory;
        this.userName       = userName;
    }

    public void donate(Item item) {
        inventory.addItem(item);
    }
}