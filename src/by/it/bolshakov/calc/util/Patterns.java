package by.it.bolshakov.calc.util;

public class Patterns {

    private Patterns() {
    }

    //  A=-3+-5+{-1,-3}+{{1,2},{-3,-4}}



    public static String OPERATION="(?<=[^-+=*/{,])[=*/+-]";
    public static String SCALAR="-?[0-9]+(\\.[0-9]+)?";
    public static String VECTOR="\\{"+SCALAR+"(,"+SCALAR+")*}";
    public static String MATRIX="\\{"+VECTOR+"(,"+VECTOR+")*}";

}
