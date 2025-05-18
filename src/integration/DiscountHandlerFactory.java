package integration;

public class DiscountHandlerFactory {
    //not sure if static or not
    public static DiscountHandler getDiscountHandler(CustomerID customerID){
        if(customerID.getAge() >= 65){
            return new SeniorDiscountHandler();
        }
        if(customerID.getIsStudent()){
            return new StudentDiscountHandler();
        }
        return new NoDIscountHandler();
    }
}
