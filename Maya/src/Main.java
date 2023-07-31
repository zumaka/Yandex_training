import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        //идея в том, чтобы посчитать количество вхождений каждой буквы в слово,
        //затем взять слово той же длины из второго слова, посчитать для него тоже количество вхождений и,
        //если они равны, прибавить сумму.
        //Затем просто сдвигаем рамку на втором слове: удаляем из словаря первую букву, которая больше не входит,
        //и меняем счетчик для новой буквы на правой границе, если она встречалась, или добавляем новое значение,
        //если ранее ее не было.
        Scanner scanner = new Scanner(System.in);
        int len1 = scanner.nextInt();
        int len2 = scanner.nextInt();
        TreeMap<Character, Integer> word = new TreeMap<Character, Integer>();
        TreeMap<Character, Integer> res = new TreeMap<Character, Integer>();
        scanner.nextLine();
        String voc = scanner.nextLine();
        String ex = scanner.nextLine();
        int sum = 0;

        mapCount(voc, word); //count values for the word
        mapCount(ex.substring(0, voc.length()), res); //count 1st iteration values for 2nd word
        if (res.equals(word)) sum++;

        for (int i = 1; i < ex.length() - voc.length(); i++) { //if lists are equals, sum++
            changeLetters(ex.charAt(i - 1), ex.charAt(i - 1 + voc.length()), res);
            if (res.equals(word)) sum++;
        }
        System.out.println(sum);

    }
    static void mapCount(String s, TreeMap<Character, Integer> map) { //how much times letter exists in word
        char[] res = s.toCharArray();
        for (char re : res) {
            if (!map.containsKey(re)) map.put(re, 0);
            int value = map.get(re) + 1;
            map.put(re, value);
        }
    }

    static void changeLetters(char letDel, char letAdd, TreeMap<Character, Integer> map) {
        if (map.get(letDel) != 1) { //delete of change value for first letter
            int value = map.get(letDel) - 1;
            map.put(letDel, value);
        }
        else map.remove(letDel);

        if (map.containsKey(letAdd)) { //add new letter
            int value = map.get(letAdd) + 1;
            map.put(letAdd, value);
        }
        else map.put(letAdd, 1);
    }
}