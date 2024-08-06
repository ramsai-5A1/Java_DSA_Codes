package CPFlavoured;

public class StrangeBirthDayParty {
    import java.util.*;

    public final class Main {
        
        private static void runTestCase(Scanner scn) {
            int n = scn.nextInt();
            int m = scn.nextInt();
            
            int[] k = new int[n];
            for (int index = 0; index < n; index++) {
                k[index] = scn.nextInt();
            }
            
            int[] c = new int[m];
            for (int index = 0; index < m; index++) {
                c[index] = scn.nextInt();
            }
            
            long result = 0;
            long directMoney = 0;
            for (int index = 0; index < n; index++) {
                directMoney += c[k[index] - 1];
            }
            
            Arrays.sort(k);
            for (int left = 0, right = n - 1; left < right; left++, right--) {
                int temp = k[left];
                k[left] = k[right];
                k[right] = temp;
            }
            result = directMoney;
            long giftsCost = 0;
            for (int index = 0; index < Math.min(n, m); index++) {
                directMoney -= c[k[index] - 1];
                giftsCost += c[index];
                result = Math.min(result, directMoney + giftsCost);
            }
            System.out.println(result);
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
