package by.it.bogumil.jd01_02;
/* step1 один раз введите с консоли n
        через объект типа Scanner - размерность матрицы arr [n] [n] и вызовите из
        метода main статические методы step1 step2 step3 с указанной сигнатурой:
         Задать значения элементов матрицы в интервале значений от -n до n с
помощью генератора случайных чисел. Числа целые. Тип int.
Пока в матрице нет чисел n и -n генерацию следует повторять, иначе
вывести матрицу в консоль, а затем, вернуть полученную матрицу.
Сигнатура int[ ][ ] step1(int n).*/
/* step 2 Найти, вывести и вернуть сумму элементов исходной матрицы arr,
расположенных между первым и вторым положительными элементами
каждой строки. Сигнатура int step2(int[ ][ ] arr).
step 3 Найти максимальный элемент(ы) в матрице и удалить из исходной
матрицы все строки и столбцы, его содержащие. Вывести в консоль и
вернуть полученную матрицу. Сигнатура int[ ][ ] step3(int[ ][ ] arr).*/


import java.util.*;

class TaskC {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] arr = step1(n);


        step2(arr);
        step3(arr);
    }

    private static int[][] step1(int n) {
        Random random = new Random();

        int[][] array = new int[n][n];
        boolean maxFound = true;
        boolean minFound = true;


        while (maxFound || minFound) {
            maxFound = true;
            minFound = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    array[i][j] = random.ints(-n, n + 1)
                            .findFirst()
                            .getAsInt();
                    if (array[i][j] == n) {
                        maxFound = false;
                    }
                    if (array[i][j] == -n) {
                        minFound = false;
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(array));
        return array;
    }

    private static int step2(int[][] arr) {
        int sum = 0;
        int k = Integer.MIN_VALUE;
        boolean isSum;
        for (int i = 0; i < arr.length; i++) {
            int[] range = getRange(arr[i]);
            isSum = false;
            for (int j = 0; j < arr[i].length - 1; j++) {
                if (range[1] == 0 || range[0] == 0) {
                    break;
                }
                if (range[0] == arr[i][j]) {
                    k = j;
                    isSum = true;
                    continue;
                }
                if (range[1] == arr[i][j] && k != j) {
                    isSum = false;
                }
                if (isSum) {
                    sum += arr[i][j];
                }
            }
        }
        System.out.println(sum);
        return sum;
    }

    private static int[][] step3(int[][] arr) {
        Set<Integer> indexesRow = new HashSet<>();
        Set<Integer> indexesCol = new HashSet<>();
        int max = getMax(arr);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (max == arr[i][j]) {
                    indexesRow.add(i);
                    indexesCol.add(j);
                }
            }
        }
        int[][] arrays = new int[arr.length - indexesRow.size()][arr.length - indexesCol.size()];

        for (int i = 0, i1 = 0; i < arr.length; i++) {
            boolean isRowWithoutMax = true;
            for (int rowIndex : indexesRow) {
                if (rowIndex == i) {
                    isRowWithoutMax = false;
                    break;
                }
            }
            for (int j = 0, j1 = 0; j < arr[i].length; j++) {
                boolean colWithoutMax = true;
                for (int OlIndex : indexesCol) {
                    if (OlIndex == j && isRowWithoutMax) {
                        colWithoutMax = false;
                        break;
                    }
                }
                if (isRowWithoutMax && colWithoutMax) {
                    arrays[i1][j1] = arrays[i][j];
                    if (j1 < arrays[i1].length - 1) {
                        j1++;
                    }
                }
            }
            if (i1 < arrays.length - 1 && isRowWithoutMax) {
                i1++;
            }
        }
        System.out.println(Arrays.deepToString(arrays));
        return arrays;
    }

    private static int getMax(int[][] arr) {
        int max = arr[0][0];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (max < arr[i][j]) {
                    max = arr[i][j];
                }
            }
        }
        return max;
    }

    private static int[] getRange(int[] arr) {
        int[] resultArray = new int[2];
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (arr[i] > 0 && resultArray[1] == 0) {
                resultArray[j] = arr[i];
                j++;
            }
        }
        return resultArray;
    }
}