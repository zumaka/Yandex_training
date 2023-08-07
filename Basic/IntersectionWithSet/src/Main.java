import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            String[] newS = scanner.nextLine().split(" ");
            String[] newS2 = scanner.nextLine().split(" ");
            Set list1 = new HashSet();
            Set list2 = new HashSet();

            for (int i = 0; i < newS.length; i++) {
                list1.add(Integer.parseInt(newS[i]));
            }
            for (int i = 0; i < newS2.length; i++) {
                list2.add(Integer.parseInt(newS2[i]));
            }

            Set<Integer> intersection = new HashSet<>(list1);
            intersection.retainAll(list2);

            scanner.close();
            Iterator value = intersection.iterator();

            while (value.hasNext()) {
                System.out.print(value.next() + " ");
            }
        } catch (
                FileNotFoundException e) {
            System.out.println("No file");
        }
    }
}