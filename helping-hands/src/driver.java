import model.*;

public class driver {

    public static void main(String[] args) {

        DonorContainer      donors      = DonorContainer.GetInstance();
        RecipientContainer  recipients  = RecipientContainer.GetInstance();
        Inventory           inventory   = Inventory.getInstance();
        Item            pants       = new Item("pants", "Clothes", 5, 19.50);
    }

}
