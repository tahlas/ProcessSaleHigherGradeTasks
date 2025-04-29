package integration;

import model.Amount;

public class ItemDTO {
    //kanske borde ha quantity
    private final String ID;
    private final String name;
    private final int price; //osäker om int eller Amount
    private final double VAT; //int?
    private final String description;

    public ItemDTO(String ID, String name, int price, double VAT, String description) {
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
    public int getPrice() {
        return this.price;
    }

    /**
     * Creates a string with information about the item.
     * @return A string with information about the item.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Item ID: ");
        appendLine(builder, ID);
        builder.append("Item name: ");
        appendLine(builder, name);
        builder.append("Item cost: ");
        appendLine(builder, Integer.toString(price));
        builder.append("VAT: ");
        appendLine(builder, String.valueOf(VAT));
        builder.append("Item description: ");
        appendLine(builder, description);
        //builder.append("Item ID: " + ID + "\n");
        //builder.append("Item name: " + name + "\n");
        //builder.append("Item cost: " + price + "\n");
        //builder.append("VAT: " + VAT + "\n");
        //builder.append("Item description: " + description + "\n");
        return builder.toString();
    }

    private void appendLine(StringBuilder builder, String line){
        builder.append(line);
        builder.append("\n");
    }



}
