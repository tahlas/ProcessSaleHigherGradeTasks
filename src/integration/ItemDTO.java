package integration;

import model.Amount;

/**
 * This is a data transfer object that stores information about an item.
 */
public class ItemDTO {
    private final String ID;
    private final String name;
    private final double VATRatePercentage;
    private final String description;
    private final Amount price;

    public ItemDTO(String ID, String name, Amount price, double VATRatePercentage, String description) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.VATRatePercentage = VATRatePercentage;
        this.description = description;
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
        appendLine(builder, price.toString());
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
        return this.price;
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
        return VATRatePercentage;
    }
}
