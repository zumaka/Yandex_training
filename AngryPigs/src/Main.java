import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pigs = scanner.nextInt();
        ArrayList<Integer> res = new ArrayList<Integer>();

        for (int i = 0; i < pigs; i++) {
            int x = scanner.nextInt();
            if (!res.contains(x)) res.add(x);
            scanner.nextInt();
        }
        System.out.println(res.size());
    }
}