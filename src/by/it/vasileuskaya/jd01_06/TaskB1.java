package by.it.vasileuskaya.jd01_06;

public class TaskB1 {
    public static void main(String[] args) {
        String text = Poem.text;
        String[] words = text.split("[^А-ЯЁа-яё]+");
        checkLetters(words);
    }

    private static void checkLetters(String[] words) {
        char[] vowels = {'а', 'е', 'ё', 'и', 'о', 'у', 'ы', 'э', 'ю', 'я'};

        for (int i = 0; i < words.length; i++) {
            boolean isFirstLetterNotVowel = true;
            for (int j = 0; j < vowels.length; j++) {
                if (words[i].toLowerCase().charAt(0) == vowels[j]) {
                    isFirstLetterNotVowel = false;
                    break;
                }
            }
            if (isFirstLetterNotVowel) {
                for (int j = 0; j < vowels.length; j++) {
                    if (words[i].charAt(words[i].length() - 1) == vowels[j]) {
                        System.out.println(words[i]);
                        break;
                    }
                }
            }
        }
    }
}

