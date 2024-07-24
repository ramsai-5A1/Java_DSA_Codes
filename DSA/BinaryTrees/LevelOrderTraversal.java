package DSA.BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class LevelOrderTraversal {
    class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> Q = new LinkedList<>();
        Q.add(root);
 
        while (!Q.isEmpty()) {
            int n = Q.size();
            List<Integer> subList = new ArrayList<>();
            for (int index = 0; index < n; index++) {
                TreeNode node = Q.poll();
                subList.add(node.val);
 
                if (node.left != null) {
                    Q.add(node.left);
                }
 
                if (node.right != null) {
                    Q.add(node.right);
                }
            }
            result.add(subList);
        }
        return result;
    }
}

}
