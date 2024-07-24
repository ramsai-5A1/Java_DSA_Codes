package DSA.BinarySearchTrees;

import javax.swing.tree.TreeNode;

public class ValidateBSTOptimizedSolution {
    class Solution {

        private boolean isInorderSorted(TreeNode root, int[] previousEle) {
            if (root == null) {
                return true;
            }

            boolean isLeftSorted = isInorderSorted(root.left, previousEle);
                if (!isLeftSorted) {
                    return false;
                }
                if (previousEle[0] == 1 && previousEle[1] >= root.val) {
                    return false;
                }
                previousEle[0] = 1;
                previousEle[1] = root.val;
                boolean isRightSorted = isInorderSorted(root.right, previousEle);
                return isRightSorted;
        }

        public boolean isValidBST(TreeNode root) {
            int[] previousEle = new int[2];
            previousEle[0] = 0;
            previousEle[1] = -1;
            return isInorderSorted(root, previousEle);
        }
    }
}
