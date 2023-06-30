import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<Long> num = new ArrayList<Long>();
        num = input();

        long pos1 = Long.MIN_VALUE;
        long pos2 = Long.MIN_VALUE;
        long neg1 = Long.MAX_VALUE;
        long neg2 = Long.MAX_VALUE;
        long mulPos = -1, mulNeg = -1;

        for (Long n : num) {
            if (n >= 0) {
                if (n > pos1) {
                    if (n > pos2) {
                        pos1 = pos2;
                        pos2 = n;
                    }
                    else pos1 = n;
                }
            }
            else {
                if (n < neg1) {
                    if (n < neg2) {
                        neg1 = neg2;
                        neg2 = n;
                    }
                    else neg1 = n;
                }
            }
        }

        if (pos1 != Long.MIN_VALUE & pos2 != Long.MIN_VALUE) mulPos = pos1 * pos2;
        if (neg1 != Long.MAX_VALUE & neg2 != Long.MAX_VALUE) mulNeg = neg1 * neg2;

        if (mulPos == -1 & mulNeg == -1) {
            System.out.printf("%d %d", Math.min(neg1, neg2), Math.max(pos1, pos2));
        }
        else {
            if (mulPos > mulNeg) System.out.printf("%d %d", Math.min(pos1, pos2), Math.max(pos1, pos2));
            else System.out.printf("%d %d", Math.min(neg1, neg2), Math.max(neg1, neg2));
        }
    }

    static ArrayList input () {
        ArrayList<Long> list = new ArrayList<Long>();

        try {
            Scanner scanner = new Scanner(new File("input.txt"));

            while (scanner.hasNextLong()) list.add(scanner.nextLong());
            scanner.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("No file");
        }
        return list;
    }
}