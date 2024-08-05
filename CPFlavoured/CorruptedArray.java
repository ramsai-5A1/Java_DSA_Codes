package CPFlavoured;

public class CorruptedArray {
    import java.util.*;

public final class Main {
    
    private static int isPossible(int[] arr, long sum, int actualSum, int x, int n) {
        
        if (actualSum < x) {
            return -1;
        }
        for (int index = 0; index < n + 2; index++) {
            if (arr[index] == 0) continue;
            if ((sum - arr[index]) + x == actualSum) {
                return index;
            }
        }
        
        return -1;
    }
    
    private static void runTestCase(Scanner scn) {
        int n = scn.nextInt();
        int[] arr = new int[n + 2];
        long sum = 0;
        int mx1 = 0, mx2 = 0;
        int pos1 = 0, pos2 = 0;
        for (int index = 0; index < n + 2; index++) {
            arr[index] = scn.nextInt();
            sum += arr[index];
            if (arr[index] > mx1) {
                pos2 = pos1;
                pos1 = index;
                mx2 = mx1;
                mx1 = arr[index];
            } else if (arr[index] > mx2) {
                mx2 = arr[index];
                pos2 = index;
            }
        }
        sum -= mx1;
        sum -= mx2;
        arr[pos1] = 0;
        arr[pos2] = 0;
        
        if (sum == mx1 || sum == mx2) {
            for (int index = 0; index < n + 2; index++) {
                if (arr[index] == 0)    continue;
                System.out.print(arr[index] + " ");
            }
            System.out.println();
            return;
        } else {
            int choice1 = isPossible(arr, sum, mx1, mx2, n);
            if (choice1 >= 0) {
                boolean found = false;
                for (int index = 0; index < n + 2; index++) {
                    if (arr[index] == 0)    continue;
                    if (arr[index] == mx1 && !found) {
                        found = true;
                        continue;
                    }
                    if (index != choice1) {
                        System.out.print(arr[index] + " ");
                    }
                }
                
                System.out.println(mx2);
                return;
            }
            int choice2 = isPossible(arr, sum, mx2, mx1, n);
            if (choice2 >= 0) {
                boolean found = false;
                for (int index = 0; index < n + 2; index++) {
                    if (arr[index] == 0)    continue;
                    if (arr[index] == mx2 && !found) {
                        found = true;
                        continue;
                    }
                    if (index != choice2) {
                        System.out.print(arr[index] + " ");
                    }
                }
                
                System.out.println(mx1);
                return;
            }
        }
        
        System.out.println("-1");
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
