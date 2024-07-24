package DSA.BinaryTrees;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class PreorderTraversal {
    class Solution {

    private void preorderHelper(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }

        // step-1 (root)
        result.add(root.val);

        // step-2  (left)
        preorderHelper(root.left, result);

        // step-3 (right)
        preorderHelper(root.right, result);

    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorderHelper(root, result);
        return result;
    }
}
}
