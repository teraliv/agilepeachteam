package model;

import java.util.List;

public class Donor {


    public String       name;           // Donor's name. It could be personal or business name.
    public List<Item>   donatedItems;   // List of donated availableItems by this donor.

    /**
     * Creates new Donor.
     * @param name - donor's name.
     */
    public Donor(String name) {
        this.name   = name;
    }
}
