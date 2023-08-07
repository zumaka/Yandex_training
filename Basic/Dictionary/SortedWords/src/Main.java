import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String word;
        String key;
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            word = scanner.nextLine();
            key = sortWord(word);
            if (!map.containsKey(key)) map.put(key, new ArrayList<String>());
            map.get(key).add(word);
        }
        System.out.println(map);
    }

    static String sortWord(String s) {
        // Converting input string to character array
        char tempArray[] = s.toCharArray();

        // Sorting temp array using
        Arrays.sort(tempArray);

        // Returning new sorted string
        return new String(tempArray);
    }
}
