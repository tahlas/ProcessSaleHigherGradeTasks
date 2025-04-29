package model;

/**
 * This represents an amount of money.
 */
public final class Amount {
    private final int amount;

    public Amount() {
        this(0);
    }

    public Amount(int amount){
        this.amount = amount;
    }

    public Amount add(Amount other){
        return new Amount(this.amount + other.amount);
    }

}
