package by.it.han.jd01_06;

public class TaskB1 {
    public static void main(String[] args) {
        printWords();
    }

    private static void printWords() {
        String[] words = Poem.text.split("[^А-Яа-яЁё]+");
        for (String word : words) {
            checkWord(word);
        }
    }

    private static void checkWord(String word) {
        char[] vowels = new char[]{'а', 'е', 'ё', 'и', 'о', 'у', 'ы', 'э', 'ю', 'я'};
        boolean isFirstConsonant = true;
        for (char c : vowels) {
            if (word.toLowerCase().charAt(0) == c) {
                isFirstConsonant = false;
                break;
            }
        }

        if (isFirstConsonant) {
            for (char vowel : vowels) {
                if (word.charAt(word.length() - 1) == vowel) {
                    System.out.println(word);
                    break;
                }
            }
        }
    }
}
