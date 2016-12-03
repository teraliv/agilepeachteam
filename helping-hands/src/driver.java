import model.*;

public class driver {

    public static void main(String[] args) {

        DonorContainer      donors      = DonorContainer.GetInstance();
        RecipientContainer  recipients  = RecipientContainer.GetInstance();
        Inventory           inventory   = Inventory.GetInstance();
        Item            pants       = new Item("pants", "Clothes", 5, 19.50);
    }

}
