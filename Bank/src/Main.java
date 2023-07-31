import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            Map<String, Integer> map = new HashMap<String, Integer>();
            while (scanner.hasNextLine()) {
                String[] s = scanner.nextLine().split(" ");
                if (s[0].equals("DEPOSIT")) {
                    if (!map.containsKey(s[1])) map.put(s[1], 0);
                    int value = map.get(s[1]) + Integer.parseInt(s[2]);
                    map.put(s[1], value);
                }
                if (s[0].equals("INCOME")) {
                    for (String s1 : map.keySet()) {
                        if (map.get(s1) > 0){
                            int value = map.get(s1) + map.get(s1) / 100 * (Integer.parseInt(s[1]));
                            map.put(s1, value);
                        }
                    }
                }
                if (s[0].equals("BALANCE")) {
                    if (!map.containsKey(s[1])) System.out.println("ERROR");
                    else System.out.println(map.get(s[1]));
                }
                if (s[0].equals("TRANSFER")) {
                    if (!map.containsKey(s[1])) map.put(s[1], 0);
                    if (!map.containsKey(s[2])) map.put(s[2], 0);
                    int value = map.get(s[1]) - Integer.parseInt(s[3]);
                    map.put(s[1], value);
                    value = map.get(s[2]) + Integer.parseInt(s[3]);
                    map.put(s[2], value);
                }
                if (s[0].equals("WITHDRAW")) {
                    if (!map.containsKey(s[1])) map.put(s[1], 0);
                    int value = map.get(s[1]) - Integer.parseInt(s[2]);
                    map.put(s[1], value);
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("No file");
        }
    }
}