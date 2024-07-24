package DSA.BinaryTrees;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class PostorderTraversal {
        class Solution {

        private void postorderHelper(TreeNode root, List<Integer> result) {
            if (root == null) {
                return;
            }

            // step-1 (left)
            postorderHelper(root.left, result);

            // step-2 (right)
            postorderHelper(root.right, result);

            // step-3  (root)
            result.add(root.val);
        }

        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            postorderHelper(root, result);
            return result;
        }
    }
}
