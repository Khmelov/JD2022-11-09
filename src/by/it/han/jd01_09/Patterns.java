package by.it.han.jd01_09;

class Patterns {

    private Patterns() {
    }

    static String OPERATION = "[-+*/]";
    static String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    static String VECTOR = "\\{" + SCALAR + "(," + SCALAR + ")*}";
    static String MATRIX = "\\{" + VECTOR + "(," + VECTOR + ")*}";

}