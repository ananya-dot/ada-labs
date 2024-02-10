

import java.util.Scanner;

public class Q3two {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        for (int i = 0; i < tc; i++) {
            int len = sc.nextInt();
            String s = sc.next();
            System.out.println(minOperationsToPerfect(s, 'a', 0, len - 1));
        }
    }

    public static int minOperationsToPerfect(String s, char ch, int start, int end) {
        if (start == end) return (s.charAt(start) == ch) ? 0 : 1; 
        char nextCh = (char) (ch + 1);
        int mid = (start + end) / 2;

        
        int leftOps = minOperationsToPerfect(s, nextCh, start, mid);
        int rightOps = minOperationsToPerfect(s, nextCh, mid + 1, end);

        
        if (leftOps == 0 && allSame(s, ch, mid + 1, end)) {
            return 0;
        } else if (rightOps == 0 && allSame(s, ch, start, mid)) {
            return 0;
        }

        
        int leftCount = countOperations(s, ch, mid + 1, end);
        int rightCount = countOperations(s, ch, start, mid);

        
        return Math.min(leftOps + leftCount, rightOps + rightCount);
    }

    private static boolean allSame(String s, char ch, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) != ch) return false;
        }
        return true;
    }

    private static int countOperations(String s, char ch, int start, int end) {
        int count = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) != ch) count++;
        }
        return count;
    }
}
