package by.it.samatokhin.jd01_06;

import java.util.ArrayList;
import java.util.Collections;

public class TaskB2 {

    private static final String text =
            """
                    У лукоморья дуб зелёный,
                    Златая цепь на дубе том.
                    Идёт направо - песнь заводит,
                    Налево - сказку говорит.
                    И днём и ночью кот учёный
                    Всё ходит по цепи кругом.
                    Там на неведомых дорожках
                    Следы невиданных зверей.
                    Там чудеса: там леший бродит,
                    Русалка на ветвях сидит.
                    Избушка там на курьих ножках
                    Стоит без окон, без дверей.
                    В темнице там царевна тужит,
                    А бурый волк ей верно служит.
                    """;

    public static void main(String[] args) {

        ArrayList<String> sentencesLst = new ArrayList<>();
        int previousDot = 0;

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch == '.') {
                String sentence = text.substring(previousDot, i + 1);

                sentence = sentence.replaceAll("[^а-яёА-ЯЁ0-9]+", " ");
                sentence = sentence.trim();
                sentencesLst.add(sentence);

                previousDot = i + 1;
            }
        }

        Collections.sort(sentencesLst, (a, b) -> Integer.compare(a.length(), b.length()));

        for (String s : sentencesLst) {
            System.out.println(s);
        }
    }
}
