import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine(); //строка на вход (Hello, world!)
        Map<Character, Integer> list = new TreeMap<Character, Integer>();
        int max = -1;

        for (int i = 0; i < s.length(); i++) { //заполняем словарь количеством символов
            if (!list.containsKey(s.charAt(i))) list.put(s.charAt(i), 0);
            Integer value = list.get(s.charAt(i)) + 1;
            list.put(s.charAt(i), value);
        }
        for (Integer v : list.values()) {//поиск максимума
            if (max < v) max = v;
        }
        while (max > 0) {
            for (Integer v : list.values()) {//если значение больше или равно максимума, рисуем #
                if (v >= max) System.out.print("#");
                else System.out.print(" ");
            }
            System.out.println();
            max--;
        }
        for (Character ch : list.keySet()) {//выводим символы
            System.out.print(ch);
        }
    }
}