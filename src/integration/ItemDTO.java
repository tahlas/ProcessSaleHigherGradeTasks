package integration;

import model.Amount;

public class ItemDTO {
    //kanske borde ha quantity
    private final String ID;
    private final String name;
    private final int price; //osäker om int eller Amount
    private final double VAT; //int?
    private final String description;
    private int quantity; //osäker om den behövs

    public ItemDTO(String ID, String name, int price, double VAT, String description, int quantity) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.VAT = VAT;
        this.description = description;
        this.quantity = quantity;
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
     * This is used to get the name of the item.
     * @return The item's name.
     */
    public String getName() {
        return this.name;
    }

    public int getQuantity(){
        return this.quantity;
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
        return builder.toString();
    }

    /**
     * Appends a String and creates a new line at the end.
     * @param builder The StringBuilder to append the line to.
     * @param line The line to append.
     */
    private void appendLine(StringBuilder builder, String line){
        builder.append(line);
        builder.append("\n");
    }

    /**
     * Calculates the total price for buying a certain amount of the same item.
     * @return the total price for buying a certain amount of the same item.
     */
    public int getTotalItemPrice(){
        return price * quantity;
    }

    /**
     * Calculates the total VAT for the item.
     * @return The total VAt for the item.
     */
    public double getTotalItemVAT(){
        return VAT * getTotalItemPrice();
    }





}
