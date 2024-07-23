package Advanced DSA.DP;

public class Solution {

    private int[] findMaxDimensions(int[] arr, int n) {
        int[] dimensions = new int[2];
        Arrays.fill(dimensions, -1);

        int maxLen = 0, sum = 0;
        int leftIndex = 0;

        for (int index = 0; index < n; index++) {
            if (arr[index] == 1) {
                sum++;
                if (sum > maxLen) {
                    maxLen = sum;
                    dimensions[0] = leftIndex;
                    dimensions[1] = index;
                }
            } else {
                sum = 0;
                leftIndex = index + 1;
            }
        }
        return dimensions;
    }

    public int maximalRectangle(char[][] matrix) {
        int totalRows = matrix.length;
        int totalCols = matrix[0].length;
        int maxArea = 0;

        for (int leftCol = 0; leftCol < totalCols; leftCol++) {
            int[] arr = new int[totalRows];
            for (int rightCol = leftCol; rightCol < totalCols; rightCol++) {
                for (int row = 0; row < totalRows; row++) {
                    int value = matrix[row][rightCol] - '0';
                    if (rightCol == leftCol) {
                        arr[row] = value;
                    } else if (value == 0) {
                        arr[row] = 0;
                    }
                }

                int[] curr = findMaxDimensions(arr, totalRows);
                if (curr[0] == -1)  continue;
                int length = rightCol - leftCol + 1;
                int breadth = curr[1] - curr[0] + 1;
                int currArea = length * breadth;
                if (currArea > maxArea) {
                    maxArea = currArea;
                }
            }
        }
        return maxArea;
    }
} 
