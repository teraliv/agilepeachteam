package model;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    public List<Item>   availableItems; // List of all available availableItems.
    public List<Item>   donatedItems;   // List of all items that have been donated.
    public int          totalItems;     // Total number of all available availableItems
    public double       totalCost;      // Total cost of all availableItems.


    public Inventory() {
        this.availableItems = new ArrayList<>();
        this.donatedItems   = new ArrayList<>();
        this.totalItems     = 0;
        this.totalCost      = 0.00;
    }

    public void addItem(Item donatedItem) {
        availableItems.add(donatedItem);        // add item to the list
        totalItems  += donatedItem.quantity;    // update total number of items
        totalCost   += (donatedItem.quantity * donatedItem.price);  // update total cost of all items
    }

    /**
     * Check if the desired item exists in the list of all available availableItems.
     * @param itemName
     * @return
     */
    public boolean isItemExist(String itemName) {

        for (Item currentItem : availableItems) {
            if (currentItem.name == itemName)
                return true;
        }
        return false;
    }

}
