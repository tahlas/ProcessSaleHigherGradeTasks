package integration;

/**
 * Used to store information on the customer's ID.
 */
public class CustomerID {
    private final int age;
    private final boolean isStudent;

    /**
     * Creates a new instance.
     * @param age The customer's age.
     * @param isStudent True if the customer is a student, otherwise false.
     */
    public CustomerID(int age, boolean isStudent){
        this.age = age;
        this.isStudent = isStudent;
    }

    /**
     * Gets the customer's age.
     * @return The customer's age.
     */
    public int getAge(){
        return age;
    }

    /**
     * Gets the customer's student status.
     * @return True if the customer is a student, otherwise false.
     */
    public boolean getIsStudent() {
        return isStudent;
    }
}

