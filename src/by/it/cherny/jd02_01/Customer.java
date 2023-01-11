package by.it.cherny.jd02_01;

public class Customer {

    private final String name;

    public Customer(int number) {
        if (number%4==0){
            this.name = "Pensioner #"+number;
        } else if (number%2==0) {
            this.name = "Student #"+number;
        } else {
            this.name = "Customer #"+number;
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
