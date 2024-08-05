package CPFlavoured;

public class DistrictsConnection {
    import java.util.*;

    public final class Main {
        
        private static void runTestCase(Scanner scn) {
            int n = scn.nextInt();
            int gang1 = -1, gang2 = -1;
            int indGang1 = -1, indGang2 = -1;
            int[] gangs = new int[n];

            for (int index = 0; index < n; index++) {
                gangs[index] = scn.nextInt();
                if (gang1 == -1) {
                    gang1 = gangs[index];
                    indGang1 = index;
                } else if (gang1 != gangs[index] && gang2 == -1) {
                    gang2 = gangs[index];
                    indGang2 = index;
                }
            }
            
            if (gang2 == -1) {
                System.out.println("NO");
                return;
            }
            
            ArrayList<ArrayList<Integer>> result = new ArrayList<>();
            int toBePlaced = n - 1;
            
            for (int index = 0; index < n && toBePlaced > 0; index++) {
                if (gangs[index] != gang1) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(indGang1 + 1);
                    temp.add(index + 1);
                    result.add(temp);
                    toBePlaced--;
                }
            }
            
            for (int index = 0; index < n && toBePlaced > 0; index++) {
                if (gangs[index] == gang1 && index != indGang1) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(indGang2 + 1);
                    temp.add(index + 1);
                    result.add(temp);
                    toBePlaced--;
                }
            }
        
            if (toBePlaced > 0) {
                System.out.println("NO");
                return;
            }
            System.out.println("YES");
            for (ArrayList<Integer> currPair: result) {
                System.out.println(currPair.get(0) + " " + currPair.get(1));
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
