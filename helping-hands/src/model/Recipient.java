package model;

import java.util.ArrayList;
import java.util.List;

public class Recipient {

    public final String     name;
    public final List<Item> received;
    public final Inventory  inventory;


    public Recipient(String name, Inventory inventory) {
        this.name       = name;
        this.received   = new ArrayList<>();
        this.inventory  = inventory;
    }


    public boolean getDonation(String yourNeed, int desiredQuantity) {
        if (inventory.isItemExist(yourNeed) && inventory.getQuantity(yourNeed) >= desiredQuantity) {
            String  category    = inventory.getItem(yourNeed).category;
            int     quantity    = inventory.getItem(yourNeed).quantity;
            double  price       = inventory.getItem(yourNeed).price;

            Item donation = new Item(yourNeed, category, quantity, price);

            received.add(donation);
            inventory.updateInventory(yourNeed, desiredQuantity);

            return true;
        }
        return false;
    }


}
