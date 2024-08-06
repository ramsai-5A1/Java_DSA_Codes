package CPFlavoured;

public class ReplaceAndKeepSorted {
    import java.util.*;



    public final class Main {
        
        private static void runTestCase(Scanner scn) {
            int n = scn.nextInt();
            int q = scn.nextInt();
            int k = scn.nextInt();
            int[] arr = new int[n];
            
            for (int index = 0; index < n; index++) {
                arr[index] = scn.nextInt();
            }
            
            int[] store = new int[n];
            if (n > 1) {
                store[0] = arr[1] - 2;
            }
            
            store[n - 1] = k - arr[n - 1];
            for (int index = 1; index < n - 1; index++) {
                    store[index] = arr[index + 1] - arr[index - 1] - 2;
                    store[index] += store[index - 1];
            }
            if (n > 1) {
                store[n - 1] += store[n - 2];
            }
            
            
            for (int query = 0; query < q; query++) {
                int l = scn.nextInt();
                int r = scn.nextInt();
                l--;
                r--;
                if (l == r) {
                    System.out.println(k - 1);
                    continue;
                } else if (l + 1 == r) {
                    int result = 0;
                    if (l != n - 1) {
                        result = arr[l + 1] - 2;
                        result += (k - arr[r - 1] - 1);
                    }
                    System.out.println(result);
                    continue;
                }
                
                int result = 0;
                
                result = store[r - 1];
                result -= store[l];
                
                if (l != n - 1) {
                    result += (arr[l + 1] - 2);
                }
                
                result += (k - arr[r - 1] - 1);
                System.out.println(result);
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
