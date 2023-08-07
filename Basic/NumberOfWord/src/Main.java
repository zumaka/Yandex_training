import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for (String word : readText()) { //iterate all words
            if (!map.containsKey(word)) map.put(word, 0); //create a key
            System.out.print(Integer.toString(map.get(word)) + " "); //print count
            map.put(word, map.get(word) + 1); //update count
        }
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