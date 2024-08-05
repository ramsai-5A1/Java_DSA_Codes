package CPFlavoured;

public class Fillomino {
    import java.util.*;
    public final class Main {
        
        private static void runTestCase(Scanner scn) {
            int n = scn.nextInt();
            int[][] matrix = new int[n][n];
            for (int index = 0; index < n; index++) {
                Arrays.fill(matrix[index], -1);
            }
            
            for (int index = 0; index < n; index++) {
                matrix[index][index] = scn.nextInt();
            }
            
            for (int index = 0; index < n; index++) {
                int remaining = matrix[index][index] - 1;
                int value = matrix[index][index];
                
                int row = (index == 0 || matrix[index][index - 1] != -1) ? index + 1 : index;
                int col = (index == 0 || matrix[index][index - 1] != -1) ? index : index - 1;
                while (remaining > 0 && row < n && col >= 0) {
                    if (matrix[row][col] == -1) {
                        matrix[row][col] = value;
                        remaining--;
                        
                    } else if (col > 0 && matrix[row][col - 1] == -1) {
                        col--;
                    } else {
                        row++;
                    }
                }
            }
            
            for (int index1 = 0; index1 < n; index1++) {
                for (int index2 = 0; index2 <= index1; index2++) {
                    System.out.print(matrix[index1][index2] + " ");
                }
                System.out.println();
            }
        }
        
        public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            int tc = 1;
            //int tc = scn.nextInt();
            while (tc-- > 0) {
                runTestCase(scn);
            }
        }
    }
}
