package Advanced DSA.DP.1D-DP;

public class Solution {

    private int[] findLeftMaxSum(int[] arr) {
        int n = arr.length;
        int[] leftMaxSum = new int[n];
        int sum = 0;
        for (int index = 0; index < n; index++) {
            sum += arr[index];
            leftMaxSum[index] = sum;
            if (sum < 0) {
                sum = 0;
            }
        }
        return leftMaxSum;
    }

    private int[] findRightMaxSum(int[] arr) {
        int n = arr.length;
        int[] rightMaxSum = new int[n];
        int sum = 0;
        for (int index = n - 1; index >= 0; index--) {
            sum += arr[index];
            rightMaxSum[index] = sum;
            if (sum < 0) {
                sum = 0;
            }
        }
        return rightMaxSum;
    }

    public int maximumSum(int[] arr) {
        int n = arr.length;
        int[] leftMaxSum = findLeftMaxSum(arr);
        int[] rightMaxSum = findRightMaxSum(arr);
        int result = leftMaxSum[0];

        for (int index = 1; index < n - 1; index++) {
            result = Math.max(result, leftMaxSum[index]);
            int previousSum = leftMaxSum[index - 1];
            int nextSum = rightMaxSum[index + 1];
            int sumAfterDeleting = previousSum + nextSum;
            result = Math.max(result, sumAfterDeleting);
        }
        result = Math.max(result, leftMaxSum[n - 1]);
        return result;
    }
} 