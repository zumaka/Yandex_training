import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Map<String, String> map1 = new HashMap<String, String>();
        Map<String, String> map2 = new HashMap<String, String>();
        String[] words = {};
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            words = scanner.nextLine().split(" ");
            map1.put(words[0], words[1]);
            map2.put(words[1], words[0]);
        }
        String word = scanner.nextLine();
        if (map1.containsKey(word)) System.out.println(map1.get(word));
        else System.out.println(map2.get(word));
    }
}