package Basic Codes;

public class SortingTwoDArray {
    import java.util.*;

public final class Main {
    
    private static long findResult(int[] arr) {
        long result = 0;
        int n = arr.length;
        int[][] curr = new int[n][2];
        for (int index = 0; index < n; index++) {
            curr[index] = new int[]{arr[index], index + 1};
        }
        
        Arrays.sort(curr, (a, b) -> Integer.compare(a[0], b[0]));
        for (int index1 = 0; index1 < n; index1++) {
            for (int index2 = index1 + 1; index2 < n; index2++) {
                
                long sum = (long) curr[index1][0] * curr[index2][0];
                long prod = (long) curr[index1][1] + curr[index2][1];
                if (sum >= 2 * n) {
                    break;
                } else if (sum == prod) {
                    result++;
                }
            }
        }
        
        return result;
    }
    
    private static void runTestCase(Scanner scn) {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int index = 0; index < n; index++) {
            arr[index] = scn.nextInt();
        }
        System.out.println(findResult(arr));
    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int tc = scn.nextInt();
        while (tc-- > 0) {
            runTestCase(scn);
        }
    }
}
}
