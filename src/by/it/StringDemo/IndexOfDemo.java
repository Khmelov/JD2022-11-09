package by.it.StringDemo;

public class IndexOfDemo {
    public static void main(String[] args) {
        String strok = "Для работы со строками, в Java используються классы StringBuffer, StringBilder, String";
        int index = -1;
        do {
            index = strok.indexOf("S", index == -1 ? 0 : index + 1);
            if (index != -1) {
                System.out.println(index);
            }
        } while (index != -1);
        System.out.println(strok);
    }
}

