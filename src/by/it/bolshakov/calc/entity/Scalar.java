package by.it.bolshakov.calc.entity;

import by.it.bolshakov.calc.exception.CalcException;

public class Scalar extends Var {

    private final double value;

    public Scalar(double value) {
        this.value = value;
    }

    public Scalar(String stringValue) {
        this.value = Double.parseDouble(stringValue);
    }

    public Scalar(Scalar otherScalar) {
        this.value = otherScalar.value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public Var add(Var other) throws CalcException {
        //1 operand == this 2 operand == ????
        if (other instanceof Scalar second) {
            return new Scalar(this.value + second.value);
        } else {
            return other.add(this);
        }
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar second) {
            return new Scalar(this.value - second.value);
        }
        Scalar minus = new Scalar(-1);
        return minus.mul(other.sub(this));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar second) {
            return new Scalar(this.value * second.value);
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar second) {
            if (second.value==0){
                throw new CalcException("division by zero");
            }
            return new Scalar(this.value / second.value);
        }
        return super.div(other);
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}
