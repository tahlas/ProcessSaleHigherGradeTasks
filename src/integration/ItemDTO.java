package integration;

import model.Amount;

public class ItemDTO {
    private final String ID;
    private final String name;
    private final Amount price;
    private final double VAT; //int?
    private final String description;

    public ItemDTO(String ID, String name, Amount price, double VAT, String description) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.VAT = VAT;
        this.description = description;
    }

    /**
     * This is used to get the item ID.
     * @return The item's ID.
     */
    public String getID() {
        return ID;
    }

    /**
     * This is used to get the price of the item.
     * @return The item's price.
     */
    public Amount getPrice() {
        return this.price;
    }





}
