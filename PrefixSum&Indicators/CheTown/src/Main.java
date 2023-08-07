import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int r = scanner.nextInt();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = scanner.nextInt();
        }
        int start = 0, end = 1,  ans = 0;
        while (start != res.length & end != res.length) {
            if (res[end] - res[start] > r) {
                ans++;
                ans += res.length - end - 1;
                start++;
                end--;
            }
            end++;
        }
        System.out.println(ans);
    }
}