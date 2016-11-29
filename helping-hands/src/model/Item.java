package model;

public class Item {

    public String   name;       // The name of this donated item.
    public String   category;   // The name of the category this item belongs.
    public int      quantity;   // The amount of units of current item to be donated.
    public double   price;      // The price per unit.


    public Item (String name, String category, int quantity, double price) {
        this.name       = name;
        this.category   = category;
        this.quantity   = quantity;
        this.price      = price;
    }
}
