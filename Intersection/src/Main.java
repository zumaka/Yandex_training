import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> external = new ArrayList<>();
        ArrayList<Integer> res = new ArrayList<>();
        int rem = 10;

        for (int i = 0; i < 10; i++) { //create smallest hashtabs
            ArrayList<Integer> internal = new ArrayList<>();
            external.add(internal);
        }

        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            rem = splitLine(scanner.nextLine(), external, rem);

             while (scanner.hasNextInt()) {
                 int num = scanner.nextInt();
                 if (external.get(num % rem).contains(num)) res.add(num);
             }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("No file");
        }

        Collections.sort(res);
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
    }

    static ArrayList<ArrayList<Integer>> extendHashTab(ArrayList<ArrayList<Integer>> hashTable, int rem) {
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

    static int splitLine(String s, ArrayList<ArrayList<Integer>> list, Integer rem) {
        String[] newS = s.split("[ ]");
        for (int i = 0; i < newS.length; i++) {
            rem = list.size();
            list.get(Integer.parseInt(newS[i]) % rem).add(Integer.parseInt(newS[i]));
            if (list.get(Integer.parseInt(newS[i]) % rem).size() == list.size()) {
                extendHashTab(list, list.size() * 2);
                recalculation(list, list.size() * 2);
            }
        }
        return list.size();
    }

}