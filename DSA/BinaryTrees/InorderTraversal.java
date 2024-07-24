package DSA.BinaryTrees;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class InorderTraversal {
    class Solution {

        private void inorderHelper(TreeNode root, List<Integer> result) {
            if (root == null) {
                return;
            }

            // step-1 (left)
            inorderHelper(root.left, result);

            // step-2  (root)
            result.add(root.val);

            // step-3 (right)
            inorderHelper(root.right, result);

        }

        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            inorderHelper(root, result);
            return result;
        }
    }
}
