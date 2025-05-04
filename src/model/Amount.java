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
     * Calculates the sum of two terms.
     * @param other The other term to add.
     * @return The sum of the two terms.
     */
    public Amount add(Amount other){
        return new Amount(this.amount + other.amount);
    }

    /**
     * Mulltiplies two factors.
     * @param other The other factor.
     * @return The product from the multiplication.
     */
    public Amount multiply(Amount other){
        return new Amount(this.amount * other.amount);
    }

    /**
     * Divides an amount by another amount.
     * @param other The amount to divide by.
     * @return The quotient of the division.
     */
    public Amount divide(Amount other){
        return new Amount(this.amount / other.amount);
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

    /**
     * Checks if the amount is equal to another object.
     * @param other The other object to compare to.
     * @return True if the amounts are equal, false if they are not.
     */
    @Override
    public boolean equals(Object other){
        if(!(other instanceof Amount)){
            return false;
        }
        Amount otherAmount = (Amount) other;
        return amount == otherAmount.amount;
    }
}
