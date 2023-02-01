package by.it.bolshakov.jd01_06;

public class TaskC2 {

    public static void main(String[] args) {

        String test = getRandomWords(Poem.text);

        long startTimeSlow = System.nanoTime();
        String str1 = slow(test);
        long endTimeSlow = System.nanoTime() - startTimeSlow;
        System.out.println("slow "+endTimeSlow/1000000);

        long startTimeFast = System.nanoTime();
        String str2 = fast(test);
        long endTimeFast = System.nanoTime() - startTimeFast;
        System.out.println("fast "+endTimeFast/1000000);

        System.out.println("Отличие в скорости в "+ (endTimeSlow/endTimeFast) + " раза");
    }

    private static String getRandomWords(String text) {
        String[] words = text.split("[^а-яА-ЯёЁ]+");
        StringBuilder randomText = new StringBuilder("");
        for (int i = 0; i < 100000; i++) {
            int randomWord = (int)Math.floor(Math.random() * words.length);
            randomText.append(words[randomWord]);
            randomText.append(" ");
        }
        return randomText.toString();
    }
    private static String slow (String text) {
        String[] words = text.split(" ");
        String veryLongStr = "";
        for (int i = 0; i < words.length; i++) {
            veryLongStr+=words[i]+" ";
        }
        return veryLongStr;
    }
    private static String fast(String text){
        String[] words = text.split(" ");
        StringBuilder veryLongStr = new StringBuilder("");
        for (int i = 0; i < words.length; i++) {
            veryLongStr.append(words[i]);
            veryLongStr.append(" ");
        }
        return String.valueOf(veryLongStr);
    };
}
