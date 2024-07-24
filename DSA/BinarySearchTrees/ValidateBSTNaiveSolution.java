package DSA.BinarySearchTrees;

import java.util.ArrayList;

import javax.swing.tree.TreeNode;

public class ValidateBSTNaiveSolution {
        class Solution {

        private void findInorderTraversal(TreeNode root, ArrayList<Integer> inorder) {
            if (root == null) {
                return;
            }

            findInorderTraversal(root.left, inorder);
            inorder.add(root.val);
            findInorderTraversal(root.right, inorder);
        }

        public boolean isValidBST(TreeNode root) {
            ArrayList<Integer> inorder = new ArrayList<>();
            findInorderTraversal(root, inorder);
            int n = inorder.size();
            for (int index = 1; index < n; index++) {
                if (inorder.get(index) <= inorder.get(index - 1)) {
                    return false;
                }
            }
            return true;
        }
    }
}
