package DSA.BinaryTrees;

import java.util.ArrayList;

public class RootToLeafPaths {
    class Solution {
    
    private static void pathHelper(Node root, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result) {
        if (root == null) {
            return;
        } else if (root.left == null && root.right == null) {
            path.add(root.data);
            result.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        }
        
        path.add(root.data);
        pathHelper(root.left, path, result);
        pathHelper(root.right, path, result);
        path.remove(path.size() - 1);
    }
    
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        pathHelper(root, path, result);
        return result;
    }
}
  
}
