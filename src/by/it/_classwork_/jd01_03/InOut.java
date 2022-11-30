package by.it._classwork_.jd01_03;

class InOut {

    public static final String SPACE = " ";

    public static double[] getArray(String line) {
        line = line.trim();
        String[] stringArray = line.split(SPACE);
        double[] array = new double[stringArray.length];
        for (int i = 0; i < array.length; i++) {
            array[i]=Double.parseDouble(stringArray[i]);
        }
        return array;
    }

    public static void printArray(double[] array) {
        for (double v : array) {
            System.out.print(v + " ");
        }
        System.out.println();
    }

    public static void printArray(double[] array, String name, int columnCount) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[% -3d]=%-9.3f",name,i,array[i]);
            if (i==array.length-1 || (i+1)%columnCount==0){
                System.out.println();
            }
        }
    }
}
