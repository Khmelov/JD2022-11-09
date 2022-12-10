package by.it.boycova.jd01_08;

public abstract class Var implements Operation {
    
    @Override
    public String toString() {
        return "unknown variable";
    }

    @Override
    public Var add(Var other) {
        System.out.printf("Operation %s + %s is impossible%n", this,other);
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.printf("Operation %s - %s is impossible%n", this,other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf("Operation %s * %s is impossible%n", this,other);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf("Operation %s / %s is impossible%n", this,other);
        return null;
    }
}
