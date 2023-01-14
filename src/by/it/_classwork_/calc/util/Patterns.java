package by.it._classwork_.calc.util;

public class Patterns {

    private Patterns() {
    }

    public static String OPERATION="[-+*/=]";
    public static String SCALAR="-?[0-9]+(\\.[0-9]+)?";
    public static String VECTOR="\\{"+SCALAR+"(,"+SCALAR+")*}";
    public static String MATRIX="\\{"+VECTOR+"(,"+VECTOR+")*}";

}
