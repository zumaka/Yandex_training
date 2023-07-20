import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //number of keys
        int[] maxClick = new int[n]; //number of clicks
        for (int i = 0; i < n; i++) { //read clicks
            maxClick[i] = scanner.nextInt();
        }
        int num = scanner.nextInt();
        for (int i = 0; i < num; i++) {
            maxClick[scanner.nextInt() - 1]--; //substract, if click
        }
        for (int i : maxClick) {
            if (i < 0) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}