package by.it.bolshakov.jd01_06;

public class TaskC2 {

    public static void main(String[] args) {

        String test = getRandomWords(Poem.text);


        long startTime1 = System.nanoTime();
        String str1 = slow(test);
        long elapsedTime1 = System.nanoTime() - startTime1;
        System.out.println("slow "+elapsedTime1/1000000);

        long startTime2 = System.nanoTime();
        String str2 = fast(test);
        long elapsedTime2 = System.nanoTime() - startTime2;
        System.out.println("fast "+elapsedTime2/1000000);

        System.out.println("Отличие в скорости "+(elapsedTime1/elapsedTime2));
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
