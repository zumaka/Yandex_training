import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<String, Integer>();
        for (String word : readText()) { //iterate all words
            if (!map.containsKey(word)) map.put(word, 0); //create a key
            map.put(word, map.get(word) + 1); //update count
        }
        String key = "";
        int max = -1;
        for (String s : map.keySet()) {
            if (map.get(s) > max) { //find max value and save a key
                max = map.get(s);
                key = s;
            }
        }

        System.out.printf(key.substring(1, key.length() - 1)); //print without []
    }

    static ArrayList<String> readText() { //read list of words and add to list
        ArrayList<String> words = new ArrayList<String>();
        try {
            Scanner scanner = new Scanner(new File("input.txt"));

            while (scanner.hasNext()) {
                words.add(Arrays.toString(scanner.next().split(" ")));
            }
            scanner.close();
        } catch (
                FileNotFoundException e) {
            System.out.println("No file");
        }
        return words;
    }
}