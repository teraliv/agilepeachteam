package model;

public class Item {

    public final String     name;       // The firstName of this donated item.
    public final String     category;   // The firstName of the category this item belongs.
    public int              quantity;   // The amount of units of current item to be donated.
    public double           price;      // The price per unit.


    public Item (String name, String category, int quantity, double price) {
        this.name       = name;
        this.category   = category;
        this.quantity   = quantity;
        this.price      = price;
    }
}
