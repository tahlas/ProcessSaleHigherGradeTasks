package model;

/**
 * This represents an amount of money.
 */
public final class Amount {
    private final double amount;

    /**
     * Creates a new instance.
     * @param amount The amount of money.
     */
    public Amount(double amount){
        this.amount = amount;
    }

    /**
     * Calculates the sum of two amounts.
     * @param other The amount to add.
     * @return The sum of the two amounts.
     */
    public Amount add(Amount other){
        return new Amount(this.amount + other.amount);
    }

    public Amount multiply(Amount other){
        return new Amount(this.amount * other.amount);
    }

    /**
     * Calculates the difference between two amounts.
     * @param other The amount to subtract.
     * @return The difference between the two amounts.
     */
    public Amount minus(Amount other){
        return new Amount(this.amount - other.amount);
    }

    /**
     * Gets the amount as a String.
     * @return The String as an amount.
     */
    @Override
    public String toString(){
        double roundedAmount = roundToTwoDecimals(amount);
        return String.valueOf(roundedAmount);
    }

    /**
     * Rounds a number to two decimals.
     * @param value The value to round.
     * @return The rounded number.
     */
    private double roundToTwoDecimals(double value){
        double scale = Math.pow(10, 2);
        return Math.round(value * scale) / scale;
    }
}
