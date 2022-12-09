package by.it.yaroshevich.jd01_09;

class Paterns {
    private Paterns(){

    }
    static String OPERATION= "[-+*/]";
    static String SCALAR= "-?[0-9]+(\\.[0-9]+)?";
    static String VECTOR= "\\{"+SCALAR+"(,"+SCALAR+")*}";
    static String MATRIX= "\\{"+VECTOR+"(,"+VECTOR+")*}";
}
