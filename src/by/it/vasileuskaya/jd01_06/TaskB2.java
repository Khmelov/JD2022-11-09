package by.it.vasileuskaya.jd01_06;

public class TaskB2 {
    public static void main(String[] args) {
        String text = Poem.text;
        String textAfterCorrect = text
                .replaceAll("[^А-ЯЁа-яё]", " ")
                .replaceAll("\\s+", " ")
                .replace("...", ".");
        String[] arrayFromText = textAfterCorrect.split("\\.");
    }
}
