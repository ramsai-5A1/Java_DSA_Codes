package Advanced DSA.DP.DigitDP;

public class Encoding {
import java.util.*;


public final class Main {
    
    static long mod = (long) Math.pow(10, 9) + 7;
    static int N = 100005;
    static long[][] cache1 = new long[N][2];
    static long[][][] cache2 = new long[N][2][11];
    static long[] cache3 = new long[N];
    static boolean isMarked = false;
    
    private static long powerFunction(int n) {
        if (!isMarked) {
            cache3[0] = 1;
            for (int i = 1; i < N; i++) {
                cache3[i] = product(cache3[i - 1], (long) 10);
            }
            isMarked = true;
        }
        return cache3[n];
    }

    private static long sub(long a, long b) {
        a = a % mod;
        b = b % mod;
        return (a - b + mod) % mod;
    }
    
    private static long add(long a, long b) {
        a = a % mod;
        b = b % mod;
        return (a + b) % mod;
    }
    
    private static long product(long a, long b) {
        a = a % mod;
        b = b % mod;
        return (a * b) % mod;
    }
    
    // private static long inverseOf(long n) {
    //     return powerFunction(n, mod - 2);
    // }
    
    // private static long divide(long a, long b) {
    //     return product(a, inverseOf(b));
    // }
   
    // private static long powerFunction(long m, long n) {
    //     if (n == 0) {
    //         return 1;
    //     } else if (n % 2 == 0) {
    //         return powerFunction(product(m, m), n >> 1);
    //     }
    //     return product(m, powerFunction(m, n - 1));
    // }
    
    
    private static long totalCount(StringBuilder word, int index, int count, int flag) {
        if (flag == 0) {
            return powerFunction(count - index);
        } else if (index == count) {
            return 1;
        } else if (cache1[index][flag] != -1) {
            return cache1[index][flag];
        }
        
        long result = 0;
        int end = word.charAt(index) - '0';
        for (int num = 0; num <= end; num++) {
            result = add(result, totalCount(word, index + 1, count, (flag == 1 && num == end) ? 1 : 0));
        }
        cache1[index][flag] = result % mod;
        return result;
    }
    
    private static long helper(StringBuilder word, int index, int count, int flag, int previous) {
        if (index == count) {
            return 0;
        } else if (cache2[index][flag][previous] != -1) {
            return cache2[index][flag][previous];
        }
        
        int end = (flag == 1) ? word.charAt(index) - '0' : 9;
        long result = 0;
        for (int num = 0; num <= end; num++) {
            long currentContribution = 0;
            if (num != previous) {
                currentContribution = product((long) num, powerFunction(count - index - 1));
                currentContribution = product(currentContribution, totalCount(word, index + 1, count, (flag == 1 && num == end) ? 1 : 0));
            }
            currentContribution = add(currentContribution, helper(word, index + 1, count, (flag == 1 && num == end) ? 1 : 0, num));
            result = add(result, currentContribution);
        }
        cache2[index][flag][previous] = result;
        return result;
    }
    
    private static long findResult(StringBuilder word, long count) {
        for (int row = 0; row < count; row++) {
            for (int col = 0; col < 2; col++) {
                cache1[row][col] = -1;
            }
        }
        for (int row = 0; row < count; row++) {
            for (int col = 0; col < 2; col++) {
                for (int k = 0; k < 11; k++) {
                    cache2[row][col][k] = -1;
                }
            }
        }
        return helper(word, 0, word.length(), 1, 10);
    }
    
    
    private static long bruteForce(String word, long count) {
        long result = 0;
        int previous = 10;
        for (int index = 0; index < count; index++) {
            long currentContribution = 0;
            int num = word.charAt(index) - '0';
            if (num != previous) {
                currentContribution = product((long) num, (long) Math.pow(10, count - index - 1));
            }
            result = add(result, currentContribution);
            previous = num;
        }
        return result;
    }
    
    private static StringBuilder subtractOne(String word) {
        int n = word.length();
        StringBuilder curr = new StringBuilder(word);
        for (int index = n - 1; index >= 0; index--) {
            int num = curr.charAt(index) - '0';
            if (num > 0) {
                num--;
                curr.setCharAt(index, (char) (num + '0'));
                break;
            } else {
                curr.setCharAt(index, '9');
            }
        }
        return curr;
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int testCases = scn.nextInt();
        
        while (testCases-- > 0) {
            long lCount = scn.nextLong();
            String L = scn.next();
            
            long rCount = scn.nextLong();
            String R = scn.next();
            
            StringBuilder bL = new StringBuilder(L);
            StringBuilder bR = new StringBuilder(R);
            
            long resultR = findResult(bR, rCount);
            long resultL = findResult(bL, bL.length());
            
            System.out.println(add(bruteForce(L, lCount), sub(resultR, resultL)));
        }
    }
}
}
