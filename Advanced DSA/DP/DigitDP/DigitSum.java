package Advanced DSA.DP.DigitDP;

public import java.util.*;
import java.io.*;

public class Main {

    private static long findCountOfNumbers(String n, int index, int flag) {
        if (flag == 0) {
            return (long) Math.pow(10, n.length() - index);
        } else if (index == n.length()) {
            return 1;
        }

        long count = 0;
        int end = n.charAt(index) - '0';
        for (int start = 0; start <= end; start++) {
            count += findCountOfNumbers(n, index + 1, (start == end) ? 1 : 0);
        }
        return count;
    }

    private static long helper(String n, int index, int flag, long[][] cache) {
        if (index == n.length()) {
            return 0;
        } else if (cache[index][flag] != -1) {
            return cache[index][flag];
        }
        
        int start = 0;
        int end = (flag == 1) ? (n.charAt(index) - '0') : 9;
        long result = 0;
        for (int number = start; number <= end; number++) {
            result = result + (number * findCountOfNumbers(n, index + 1, (flag == 1 && number == end) ? 1 : 0));
            result = result + helper(n, index + 1, (flag == 1 && number == end) ? 1 : 0, cache);
        }
        cache[index][flag] = result;
        return result;
    }
        
    private static long solveIt(long n) {
        long[][] cache = new long[18][2];
        for (int row = 0; row < 18; row++) {
            Arrays.fill(cache[row], -1);
        }
        return helper(String.valueOf(n), 0, 1, cache);
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int t = scn.nextInt();
        while (t-- > 0) {
            long a = scn.nextLong();
            long b = scn.nextLong();
            
            long result2 = solveIt(b);
            long result1 = 0;
            
            if (a > 0)
                result1 = solveIt(a - 1);
            System.out.println(result2 - result1);
        }
    }
} 
