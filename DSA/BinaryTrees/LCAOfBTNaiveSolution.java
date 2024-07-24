package DSA.BinaryTrees;

import java.util.ArrayList;

import javax.swing.tree.TreeNode;

public class LCAOfBTNaiveSolution {
        /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {

        private boolean findPathHelper(TreeNode root, TreeNode target, ArrayList<TreeNode> path) {
            if (root == null) {
                return false;
            } 
            path.add(root);
            if (root.val == target.val) {
                return true;
            }

            boolean isLeftSidePresent = findPathHelper(root.left, target, path);
            if (isLeftSidePresent) {
                return true;
            }
            boolean isRightSidePresent = findPathHelper(root.right, target, path);
            if (isRightSidePresent) {
                return true;
            }
            path.remove(path.size() - 1);
            return false;
        }

        private ArrayList<TreeNode> findPath(TreeNode root, TreeNode target) {
            ArrayList<TreeNode> path = new ArrayList<>();
            findPathHelper(root, target, path);
            return path;
        }

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            ArrayList<TreeNode> path1 = findPath(root, p);
            ArrayList<TreeNode> path2 = findPath(root, q);
            int n1 = path1.size();
            int n2 = path2.size();
            TreeNode lca = null;
            for (int index = 0; index < Math.min(n1, n2); index++) {
                if (path1.get(index) == path2.get(index)) {
                    lca = path1.get(index);
                } else {
                    break;
                }
            }
            return lca;
        }
    }
}
