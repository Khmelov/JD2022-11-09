package by.it.boycova.jd01_07;

public class Scalar extends Var {

    private final double value;

    public Scalar(double doubleValue) {

        this.value=doubleValue;
    }

    public Scalar(String stringValue) {

        this.value=Double.parseDouble(stringValue);
    }

    public Scalar(Scalar var1) {
         this.value=var1.value;
    }



    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

