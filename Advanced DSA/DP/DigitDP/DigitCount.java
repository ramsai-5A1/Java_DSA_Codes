package Advanced DSA.DP.DigitDP;

public class DigitCount {

    class Solution {
        
        private static int helper(int[] arr, int n, int previous, int flag, int index, int[][][] cache) {
            if (index == n) {
                return 1;
            } else if (cache[index][flag][previous] != -1) {
                return cache[index][flag][previous];
            }
            
            int result = 0;
            for (int ele: arr) {
                if (flag == 0 || Math.abs(previous - ele) <= 2) {
                    result += helper(arr, n, ele, 1, index + 1, cache);
                }
            }
            cache[index][flag][previous] = result;
            return result;
        }
        
        private static int findResult(int[] arr, int m, int n) {
            int[][][] cache = new int[n][2][10];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 2; j++) {
                    Arrays.fill(cache[i][j], -1);
                }
            }
            return helper(arr, n, 0, 0, 0, cache);
        }
        
        public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            int tc = scn.nextInt();
            int currCase = 1;
            while (currCase <= tc) {
                int m = scn.nextInt();
                int n = scn.nextInt();
                int[] arr = new int[m];
                for (int index = 0; index < m; index++) {
                    arr[index] = scn.nextInt();
                }
                System.out.println("Case " + currCase + ": " + findResult(arr, m, n));
                currCase++;
            }
        }
    }
}
