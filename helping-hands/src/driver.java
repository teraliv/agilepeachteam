import model.Inventory;
import model.Item;

public class driver {

    public static void main(String[] args) {

        Inventory   inventory = new Inventory();
        Item shirts = new Item("Mens shirt", "Closes", 5, 19.50);

        inventory.addItem(shirts);

        System.out.println(inventory.isItemExist("Mens shirt"));
    }

}
