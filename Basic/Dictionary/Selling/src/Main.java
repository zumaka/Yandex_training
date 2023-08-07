import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Map<String,Integer>> map = new TreeMap<String, Map<String,Integer>>();
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            while (scanner.hasNextLine()) {
                String[] s = scanner.nextLine().split(" ");
                if (!map.containsKey(s[0])) map.put(s[0], new TreeMap<String, Integer>());
                if (!map.get(s[0]).containsKey(s[1])) map.get(s[0]).put(s[1], 0);
                int value = map.get(s[0]).get(s[1]);;
                map.get(s[0]).put(s[1], value + Integer.parseInt(s[2]));
            }
            scanner.close();
        } catch (
                FileNotFoundException e) {
            System.out.println("No file");
        }
        for (String s : map.keySet()) {
            System.out.println(s + ":");
            for (String s1 : map.get(s).keySet()) {
                System.out.print(s1 + " ");
                System.out.println(map.get(s).get(s1));
            }
        }
    }
}