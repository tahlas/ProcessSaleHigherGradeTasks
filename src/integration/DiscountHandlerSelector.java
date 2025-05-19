package integration;

public class DiscountHandlerSelector {
    public static DiscountHandler getDiscountHandler(CustomerID customerID){
        if(customerID.getAge() >= 65){
            return new SeniorDiscountHandler();
        }
        if(customerID.getIsStudent()){
            return new StudentDiscountHandler();
        }
        return new NoDiscountHandler();
    }
}
