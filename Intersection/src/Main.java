import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> external1 = new ArrayList<>();
        ArrayList<ArrayList<Integer>> external2 = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Integer rem = 10;

        for (int i = 0; i < 10; i++) { //create smallest hashtabs
            ArrayList<Integer> internal1 = new ArrayList<>();
            external1.add(internal1);
            ArrayList<Integer> internal2 = new ArrayList<>();
            external2.add(internal2);
        }

        try {
            Scanner scanner = new Scanner(new File("input.txt"));

            while (scanner.hasNextLine()) {
                rem = splitLine(scanner.nextLine(), external1, rem);

/*                while (scanner.hasNextInt()) {
                    if (scanner.nextInt() % rem)
                }*/
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("No file");
        }


        System.out.println(external1);
        System.out.println(external2);
        System.out.println(rem);
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

    static int splitLine(String s, ArrayList<ArrayList<Integer>> list, Integer rem) {
        String[] newS = s.split("[ ]");
        for (int i = 0; i < newS.length; i++) {
            rem = list.size();
            if (list.get(Integer.parseInt(newS[i]) % rem).size() == list.size()) {
                extendHashTable(list, list.size() * 2);
                recalculation(list, list.size() * 2);
            }
            list.get(Integer.parseInt(newS[i]) % rem).add(Integer.parseInt(newS[i]));
        }
        return list.size();
    }

}