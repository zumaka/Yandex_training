import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list = input(list);
        ArrayList<ArrayList<Integer>> external = new ArrayList<>();
        int rem = 10;
        int sum = 0;

        for (int i = 0; i < 10; i++) { //create smallest hashtab
            ArrayList<Integer> internal = new ArrayList<>();
            external.add(internal);
        }
        for (Integer n : list) {
            if (external.get(n % rem).size() == external.size()) {//recalculate tab if column.size>list.size
                rem *= 10;
                external = extendHashTable(external, rem);
                external = recalculation(external, rem);
            }
            if (!external.get(n % rem).contains(n)) //add unique elements
                external.get(n % rem).add(n);
        }
        for (ArrayList<Integer> n : external) {//count sum of columns length
            sum += n.size();
        }
        System.out.println(sum);
    }

    static ArrayList input(ArrayList<Integer> list) {
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            while (scanner.hasNextInt()) {
                list.add(scanner.nextInt());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("No file");
        }
        return list;
    }

    static ArrayList<ArrayList<Integer>> extendHashTable(ArrayList<ArrayList<Integer>> hashTable, int rem) {
        int size = hashTable.size() * rem;
        for (int i = hashTable.size(); i < size; i++) {
            ArrayList<Integer> internal = new ArrayList<>();
            hashTable.add(internal);
        }
        return hashTable;
    }

    static ArrayList<ArrayList<Integer>> recalculation(ArrayList<ArrayList<Integer>> external, int rem) {
        int len = 0;
        for (int i = 0; i < external.size(); i++) {
            len = external.get(i).size();
            for (int j = 0; j < len; j++) {
                external.get(external.get(i).get(0) % rem).add(external.get(i).get(0));
                external.get(i).remove(external.get(i).get(0));
            }
        }
        return external;
    }

}