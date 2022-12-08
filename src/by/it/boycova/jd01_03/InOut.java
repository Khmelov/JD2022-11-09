
package by.it.boycova.jd01_03;

public class InOut {

    public static final String GAPE = " ";

    public static double[] getArray(String line) {
        line= line.trim();
        String [] stringArray=line.split(GAPE);
        double [] array = new double[stringArray.length];
        for (int i = 0; i < array.length; i++) {
            array[i]=Double.parseDouble(stringArray[i]);
        }
        return array ;
    }


    public static void printArray(double[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

    public static void printArray(double[] array, String name, int columnCount) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[% -3d]=%-9.3f",name,i,array[i]);
            if(i== array.length-1 || (i+1)%columnCount==0){
                System.out.println();
            }
        }

    }
}

