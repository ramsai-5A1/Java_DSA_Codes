package CPFlavoured;

public class SameDifferences {
    import java.util.*;

public final class Main {
    
    private static void runTestCase(Scanner scn) {
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int index = 0; index < n; index++) {
            arr[index] = scn.nextInt();
        }
        
        HashMap<Long, Long> store = new HashMap<>();
        for (int index = 0; index < n; index++) {
            long diff = (long) arr[index] - index;
            store.put(diff, store.getOrDefault(diff, (long) 0) + 1);
        }
        
        long result = 0;
        for (long key: store.keySet()) {
            long curr = store.get(key);
            result += (curr * (curr - 1)) / 2;
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
