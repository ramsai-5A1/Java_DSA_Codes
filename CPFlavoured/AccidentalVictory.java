package CPFlavoured;

public class AccidentalVictory {
    import java.util.*;

public final class Main {
    
    private static ArrayList<Integer> findResult(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();
        int[][] curr = new int[n][2];
        for (int index = 0; index < n; index++) {
            curr[index] = new int[]{arr[index], index + 1};
        }
        
        Arrays.sort(curr, (a, b) -> Integer.compare(a[0], b[0]));
        long previousSum = 0;
        int previousPlayer = -1;
        for (int[] temp: curr) {
            if (previousSum >= temp[0]) {
                result.add(previousPlayer);
            } else {
                result.clear();
            }
            previousSum += temp[0];
            previousPlayer = temp[1];
        }
        
        
        result.add(previousPlayer);
        Collections.sort(result);
        return result;
    }
    
    private static void runTestCase(Scanner scn) {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int index = 0; index < n; index++) {
            arr[index] = scn.nextInt();
        }
        
        ArrayList<Integer> result = findResult(arr);
        System.out.println(result.size());
        for (int ele: result) {
            System.out.print(ele + " ");
        }
        if (result.size() > 0) {
            System.out.println();
        }
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
