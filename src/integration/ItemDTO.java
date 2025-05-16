package integration;

import model.Amount;

/**
 * This is a data transfer object that stores information about an item..
 */
public class ItemDTO {
    private final String ID;
    private final String name;
    private final Amount priceIncludingVAT;
    private final double VATRatePercentage; //ändra till Amount?
    private final String description;
    private int quantity;

    /**
     * Creates a new instance.
     * @param ID The ID of the item.
     * @param name The name of the item.
     * @param priceIncludingVAT The price of the item including VAT.
     * @param VATRatePercentage The VAT rate percentage for the item.
     * @param description The description of the item.
     */
    public ItemDTO(String ID, String name, Amount priceIncludingVAT, double VATRatePercentage, String description) {
        this.ID = ID;
        this.name = name;
        this.priceIncludingVAT = priceIncludingVAT;
        this.VATRatePercentage = VATRatePercentage;
        this.description = description;
        this.quantity = 1;
    }

    /**
     * Creates a copy of an ItemDTO.
     * @param itemDTOToCopy The ItemDTO to copy.
     */
    public ItemDTO(ItemDTO itemDTOToCopy){
        this.ID = itemDTOToCopy.getID();
        this.name = itemDTOToCopy.getName();
        this.priceIncludingVAT = itemDTOToCopy.getPrice();
        this.VATRatePercentage = itemDTOToCopy.getVATRatePercentage();
        this.description = itemDTOToCopy.getDescription();
        this.quantity = itemDTOToCopy.getQuantity();
    }

    public void increaseQuantity(){
        quantity++;
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
        appendLine(builder, priceIncludingVAT.toString());
        builder.append("VAT: ");
        builder.append(VATRatePercentage);
        appendLine(builder, "%");
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

    public int getQuantity() {
        return quantity;
    }

    /**
     * This is used to get the item ID.
     * @return The item's ID.
     */
    public String getID() {
        return this.ID;
    }

    /**
     * This is used to get the price of the item including VAT.
     * @return The item's price.
     */
    public Amount getPrice() {
        return this.priceIncludingVAT;
    }

    /**
     * This is used to get the name of the item.
     * @return The item's name.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the VAT rate percentage.
     * @return The VAT rate percentage.
     */
    public double getVATRatePercentage() {
        return this.VATRatePercentage;
    }

    /**
     * Gets the description of the item.
     * @return The description of the item.
     */
    public String getDescription() {
        return this.description;
    }
}
