package by.it.cherny.calc;

public class Patterns {
    private Patterns(){
        // class nelzya sozd po new, tolko cherez .
    }
    static String OPERATION="[-+*/=]";
    static String SCALAR = "-?[0-9]+(\\.[0-9]+)?";
    static String VECTOR = "\\{"+SCALAR+"(,"+SCALAR+")*}";
    static String MATRIX = "\\{"+VECTOR+"(,"+VECTOR+")*}";
}
