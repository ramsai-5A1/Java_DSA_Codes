package DSA.BinaryTrees;

import javax.swing.tree.TreeNode;

public class LCAOfBinaryTree {
    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root == null || root.val == p.val || root.val == q.val) {
                return root;
            }
            TreeNode leftContribution = lowestCommonAncestor(root.left, p, q);
            TreeNode rightContribution = lowestCommonAncestor(root.right, p, q);
            if (leftContribution != null && rightContribution != null) {
                return root;
            } 
            return rightContribution != null ? rightContribution : leftContribution;
        }
    }
}
