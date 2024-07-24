package DSA.BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

public class RightViewOfBinaryTree {
    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            Queue<TreeNode> Q = new LinkedList<>();
            Q.add(root);
    
            while (!Q.isEmpty()) {
                int n = Q.size();
                for (int index = 0; index < n; index++) {
                    TreeNode node = Q.poll();
                    if (index == n - 1) {
                        result.add(node.val);
                    }
    
                    if (node.left != null) {
                        Q.add(node.left);
                    }
    
                    if (node.right != null) {
                        Q.add(node.right);
                    }
                }
            }
            return result;
        }
}
}
