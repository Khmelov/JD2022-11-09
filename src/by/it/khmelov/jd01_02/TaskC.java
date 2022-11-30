package by.it.khmelov.jd01_02;

public class TaskC {
    static int[][] step3(int[][] array){
        int max = getMax(array);
        boolean[] delRow=new boolean[array.length];
        boolean[] delCol=new boolean[array[0].length];
        fillDelArrays(array, max, delRow, delCol);
        int rows = getFalseCount(delRow);
        int cols = getFalseCount(delCol);
        return createResult(array, delRow, delCol, rows, cols);
    }

    private static int[][] createResult(int[][] array, boolean[] delRow, boolean[] delCol, int rows, int cols) {
        int[][] result=new int[rows][cols];
        for (int i = 0, ir = 0; i < array.length; i++) {
            if (!delRow[i]){
                for (int j = 0, jr = 0; j < array[i].length; j++) {
                    if (!delCol[j]){
                        result[ir][jr++]= array[i][j];
                    }
                }
                ir++;
            }
        }
        return result;
    }

    private static int getFalseCount(boolean[] delRow) {
        int rows=0;
        for (boolean del : delRow) {
            if (!del){
                rows++;
            }
        }
        return rows;
    }

    private static void fillDelArrays(int[][] array, int max, boolean[] delRow, boolean[] delCol) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j]== max){
                    delRow[i]=true;
                    delCol[j]=true;
                }
            }
        }
    }

    private static int getMax(int[][] array) {
        int max=Integer.MIN_VALUE;
        for (int[] row : array) {
            for (int element : row) {
                if (max<element){
                    max=element;
                }
            }
        }
        return max;
    }
}
