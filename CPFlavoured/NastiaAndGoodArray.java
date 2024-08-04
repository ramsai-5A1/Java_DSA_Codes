package CPFlavoured;

public class NastiaAndGoodArray {
    import java.util.*;

public final class Main {
    
    private static int gcd(int a, int b) {
        if (b > a) {
            return gcd(b, a);
        } else if (b == 0) {
            return a;
        } 
        return gcd(b, a % b);
    }
    
    private static boolean tester(int[] arr) {
        int n = arr.length;
        for (int index = 0; index < n - 1; index++) {
            int val = gcd(arr[index], arr[index + 1]);
            if (val != 1) {
                System.out.println("# " + val + " " + arr[index] + " : " + arr[index + 1]);
                return false;
            }
        }
        return true;
    }
    
    private static void printResult(int[] arr) {
        int n = arr.length;
        int mnEle = arr[0], mnEleIndex = 0;
        for (int index = 0; index < n; index++) {
            if (mnEle > arr[index]) {
                mnEle = arr[index];
                mnEleIndex = index;
            }
        }
        if (mnEleIndex != 0) {
            System.out.println(n);
            System.out.println(1 + " " + (mnEleIndex + 1) + " " + mnEle + " " + mnEle);
            arr[0] = mnEle;
        } else {
            System.out.println(n - 1);
        }
        
        int val = arr[0] + 1;
        
        for (int index = 1; index <= n - 1; index++) {
            System.out.println(1 + " " + (index + 1) + " " + arr[0] + " " + val);
            arr[index] = val;
            val++;
        }
        
        //System.out.println(tester(arr));
    }
    
    private static void runTestCase(Scanner scn) {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int index = 0; index < n; index++) {
            arr[index] = scn.nextInt();
        }
        printResult(arr);
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
