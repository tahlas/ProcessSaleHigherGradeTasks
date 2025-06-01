package integration;

/**
 * Selects the correct strategy for discount calculation.
 */
public class DiscountHandlerSelector {
    public static DiscountHandler getDiscountHandler(CustomerID customerID){
        if(customerID != null && customerID.getAge() >= 65){
            return new SeniorDiscountHandler();
        }
        if(customerID != null && customerID.getIsStudent()){
            return new StudentDiscountHandler();
        }
        return new NoDiscountHandler();
    }
}
