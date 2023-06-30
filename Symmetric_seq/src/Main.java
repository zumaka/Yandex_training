import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] mas = new int[scanner.nextInt()];

        for (int i = 0; i < mas.length; i++) mas[i] = scanner.nextInt();

        ArrayList<Integer> list = new ArrayList<Integer>();

        list = Slow(mas);

        System.out.println(list.size());
        for (Integer i : list) {
            System.out.printf("%d ", i);
        }
    }

    static ArrayList Slow(int[] mas) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int i = 0, j = mas.length - 1;

        for (int ma = 0; ma < mas.length; ma++) {
            i = ma;
            j = mas.length - 1;
            while ((i <= j && mas[i] == mas[j]) & i < mas.length) {
                i++;
                j--;
            }
            if (i > j) {
                for (int k = ma - 1; k > -1; k--) list.add(mas[k]);
                return list;
            }
        }
        return list;
    }
}