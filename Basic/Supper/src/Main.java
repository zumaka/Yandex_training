import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] mas = new int[scanner.nextInt() + 2][scanner.nextInt() + 2];
        int mines = scanner.nextInt();

        short[] ni = {-1, -1, -1, 0, 0, 1, 1, 1};
        short[] nj = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int k = 0; k < mines; k++) {
            mas[scanner.nextInt()][scanner.nextInt()] = -1;
        }

        for (int m = 1; m < mas.length - 1; m++) {
            for (int n = 1; n < mas[0].length - 1; n++) {
                for (int k = 0; k < 8; k++) {
                    if (mas[m][n] != -1 && mas[m + ni[k]][n + nj[k]] == -1)
                        mas[m][n]++;
                }
            }
        }

        for (int m = 1; m < mas.length - 1; m++) {
            for (int n = 1; n < mas[0].length - 1; n++) {
                if (mas[m][n] != -1) System.out.printf("%d ", mas[m][n]);
                else System.out.print("* ");
            }
            System.out.println();
        }
    }
}