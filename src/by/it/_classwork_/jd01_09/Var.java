package by.it._classwork_.jd01_09;

abstract class Var implements Operation {

    public static Var create(String stringValue) {
        if(stringValue.matches(Patterns.SCALAR)){
            return new Scalar(stringValue);
        }
        if(stringValue.matches(Patterns.VECTOR)){
            return new Vector(stringValue);
        }        if(stringValue.matches(Patterns.MATRIX)){
            return new Matrix(stringValue);
        }
        return null;
    }

    @Override
    public Var add(Var other) {
        System.out.printf("Operation %s + %s is impossible%n", this, other);
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.printf("Operation %s - %s is impossible%n", this, other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf("Operation %s * %s is impossible%n", this, other);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf("Operation %s / %s is impossible%n", this, other);
        return null;
    }

    @Override
    public String toString() {
        return "unknown variable";
    }

}
