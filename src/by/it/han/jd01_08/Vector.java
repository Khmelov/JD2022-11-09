package by.it.han.jd01_08;

import static by.it.han.jd01_07.Vector.convertToVector;
import static by.it.han.jd01_07.Vector.getString;

public class Vector extends Var {

    private final double[] value;

    public Vector(double[] value) {
        this.value = value;
    }

    public Vector(Vector vector) {
        this.value = vector.value;
    }

    public Vector(String strVector) {
        this.value = convertToVector(strVector);
    }


    @Override
    public String toString() {
        return getString(value);
    }
}
