package by.it.yaroshevich.jd01_08;

public class Scalar extends Var {
    private final double value;

    public Scalar(double value) {
        this.value = value;

    }
    public Scalar(String stringValue) {
        this.value = Double.parseDouble(stringValue);

    }

    public Scalar(Scalar otherScalar) {
        this.value=otherScalar.value;
    }

    public double getValue(){
        return value;
    }

    @Override
    public Var add(Var other) {
        if (other instanceof Scalar){
            Scalar second = (Scalar) other;
            double result = this.value +second.value;
            Scalar resultVar = new Scalar(result);
            return resultVar;
        }
        Var resultVar = other.add(this);
        return resultVar;
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Scalar){
            Scalar second = (Scalar) other;
            double result = this.value - second.value;
            Scalar resultVar = new Scalar(result);
            return resultVar;
        }
        Scalar minus = new Scalar(-1);
        return minus.mul(other.add(this));
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Scalar){
            Scalar second = (Scalar) other;
            double result = this.value / second.value;
            Scalar resultVar = new Scalar(result);
            return resultVar;
        }
        Var resultVar = other.add(this);
        return resultVar;
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Scalar){
            Scalar second = (Scalar) other;
            double result = this.value * second.value;
            Scalar resultVar = new Scalar(result);
            return resultVar;
        }
        Var resultVar = other.add(this);
        return resultVar;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
