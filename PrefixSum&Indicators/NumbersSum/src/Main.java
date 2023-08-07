import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[][] arr = new int[n + 1][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i + 1][1] = arr[i][1] + arr[i][0];
        }
        int sum = 0, l = 0, r = 0;
        while (r < n) {
            if (arr[r + 1][1] - arr[l][1] == k) {
                sum++;
                l++;
            }
            if (arr[r + 1][1] - arr[l][1] > k) {
                l++;
                r--; //если сумма оказалась больше k, не двигаем правую границу, сдвигаем только левую
            }
            r++;
        }
        System.out.println(sum);
    }
}