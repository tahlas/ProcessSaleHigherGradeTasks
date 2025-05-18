package integration;

public class CustomerID {
    private final int age;
    private final boolean isStudent;

    public CustomerID(int age, boolean isStudent){
        this.age = age;
        this.isStudent = isStudent;
    }

    public int getAge(){
        return age;
    }

    public boolean getIsStudent() {
        return isStudent;
    }
}

