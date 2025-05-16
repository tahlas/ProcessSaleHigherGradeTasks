package integration;

/**
 * This is used to represent a sale item so the quantity does not need to be stored in ItemDTO.
 */
public class SaleItem {
    private final ItemDTO item;
    private int quantity;

    public SaleItem(ItemDTO item) {
        this.item = item;
        this.quantity = 1;
    }

    public ItemDTO getItemDTO() {
        return this.item;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public void increaseQuantity(){
        quantity++;
    }

}
