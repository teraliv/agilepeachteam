package model;

import java.util.ArrayList;
import java.util.List;

public class Donor {


    public final String       name;           // Donor's name. It could be personal or business name.
    public final List<Item>   donatedItems;   // List of donated availableItems by this donor.
    public final Inventory    inventory;

    /**
     * Creates new Donor.
     * @param name - donor's name.
     */
    public Donor(String name, Inventory inventory) {
        this.name           = name;
        this.donatedItems   = new ArrayList<>();
        this.inventory      = inventory;
    }

    public void donate(Item item) {
        inventory.addItem(item);
    }
}
