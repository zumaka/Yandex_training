import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstLine = scanner.nextLine();
        String secondLine = scanner.nextLine();

        ArrayList<ArrayList<String>> external = new ArrayList<>();
        int rem = 10;
        int sum = 0;

        for (int i = 0; i < 10; i++) { //create the smallest hashtab
            ArrayList<String> internal = new ArrayList<>();
            external.add(internal);
        }

        for (int i = 1; i < firstLine.length(); i++) {
            external.get(((int)(firstLine.charAt(i - 1))
                    + (int)(firstLine.charAt(i))) % rem)
                    .add(firstLine.substring(i - 1, i + 1));
            if (external.get(((int)(firstLine.charAt(i - 1))
                    + (int)(firstLine.charAt(i))) % rem).size() == external.size()) {
                extendHashTab(external, external.size() * 2);
                rem = external.size();
                recalculation(external, rem);
            }
        }


        for (int i = 1; i < secondLine.length(); i++) {
            for (String j: external.get(((int)(secondLine.charAt(i - 1)) + (int)(secondLine.charAt(i))) % rem)) {
                if (j.equals(secondLine.substring(i - 1, i + 1))) sum++;
            }
        }

        System.out.println(sum);
    }

    static void extendHashTab(ArrayList<ArrayList<String>> hashTable, int size) {
        for (int i = hashTable.size(); i < size; i++) {
            ArrayList<String> internal = new ArrayList<>();
            hashTable.add(internal);
        }
    }

    static void recalculation(ArrayList<ArrayList<String>> external, int rem) {
        int len = 0;
        for (int i = 0; i < external.size(); i++) {
            len = external.get(i).size();
            for (int j = 0; j < len; j++) {
                external.get(((int)((external.get(i).get(0)).charAt(0))
                        + ((int)((external.get(i).get(0)).charAt(1)))) % rem)
                        .add(external.get(i).get(0));
                external.get(i).remove(external.get(i).get(0));
            }
        }
    }
}