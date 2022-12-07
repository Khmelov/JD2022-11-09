package by.it.bogumil.jd01_06;

public class TaskB1 {
    public static void main(String[] args) {
        printWords();
    }

    private static void printWords() {
        String[] words = Poem.text.split("[^А-Яа-яЁё]+");
        for (String console : words) {
            checkWord(console);
        }
    }

    private static void checkWord(String word) {
        char[] slow = new char[]{'а', 'е', 'ё', 'и', 'о', 'у', 'ы', 'э', 'ю', 'я'};
        boolean Cons = true;
        for (char c : slow) {
            if (word.toLowerCase().charAt(0) == c) {
                Cons = false;
                break;
            }
        }

        if (Cons) {
            for (char vowel : slow) {
                if (word.charAt(word.length() - 1) == vowel) {
                    System.out.println(word);
                    break;
                }
            }
        }
    }
}

