package by.it.samatokhin.calc;

import java.util.StringJoiner;

class Vector extends Var {

    private final double[] values;

    Vector(double[] values) {
        this.values = values;
    }

    Vector(Vector vector) {
        this.values = vector.values.clone();
    }

    public Vector(String strings) {
        String[] array = strings
                .replaceAll("[{}\\s]+", "")
                .split(",");
        values = new double[array.length];
        for (int i = 0; i < values.length; i++) {
            values[i] = Double.parseDouble(array[i]);
        }
    }

    @Override
    public Var add(Var other) {

        if (other instanceof Vector second) {
            return calcVector(second, null, "+");
        } else if (other instanceof Scalar second) {
            return calcVector(null, second, "+");
        }
        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        if (other instanceof Vector second) {
            return calcVector(second, null, "-");
        } else if (other instanceof Scalar second) {
            return calcVector(null, second, "-");
        }
        return other.sub(this);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Vector second) {
            Vector result = calcVector(second, null, "*");
            double mulResult = 0;
            for (int i = 0; i < result.values.length; i++) {
                mulResult += result.values[i];
            }
            return new Scalar(mulResult);
        } else if (other instanceof Scalar second) {
            return calcVector(null, second, "*");
        }
        return other.mul(this);
    }

    @Override
    public Var div(Var other) {
        if (other instanceof Vector second) {
            return calcVector(second, null, "/");
        } else if (other instanceof Scalar second) {
            return calcVector(null, second, "/");
        }
        return other.div(this);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(", ", "{", "}");
        for (double value : values) {
            out.add(String.valueOf(value));
        }
        return out.toString();
    }

    private Vector calcVector(Vector second, Scalar scalarSecond, String operation) {
        double[] newVector = new double[this.values.length];
        double rightScalar = 0;
        if (second == null) rightScalar = Double.parseDouble(scalarSecond.toString());

        for (int i = 0; i < this.values.length; i++) {

            double left = this.values[i];
            double right = second == null ? rightScalar : second.values[i];

            if (operation == "/" && right == 0) {
                System.err.println("На нуль делить нельзя");
            } else {
                double result = operation(left, right, operation);
                newVector[i] = result;
            }
        }
        return new Vector(newVector);
    }

    private double operation(double left, double right, String operation) {
        switch (operation) {
            case "+":
                return left + right;
            case "*":
                return left * right;
            case "-":
                return left - right;
            case "/":
                return left / right;
        }
        return 0;
    }
}
