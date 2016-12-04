package model;

import java.util.ArrayList;
import java.util.List;

public class Recipient {

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
    public boolean          activeUser;


    public final List<Item> received;
    //public final Inventory  inventory;


    public Recipient(String firstName, String lastName, String DOBMonth, String DOBDay, String DOBYear, String gender, String street,
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
        this.received   = new ArrayList<>();
        this.activeUser = false;
        //this.inventory  = inventory;
    }


    public boolean getDonation(String yourNeed, int desiredQuantity, Inventory inventory) {
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