package DSA.BinaryTrees;

import javax.swing.tree.TreeNode;

public class StepByStepDirections {
    class Solution {

        private boolean appendRemainingPath(StringBuffer result, TreeNode node, int target1, int target2) {
            if (node == null) {
                return false;
            } else if (node.val == target1 || node.val == target2) {
                return true;
            }
            result.append("L");
            boolean isFound = appendRemainingPath(result, node.left, target1, target2);
            if (isFound) {
                return true;
            }
            result.deleteCharAt(result.length() - 1);
            result.append("R");
            isFound = appendRemainingPath(result, node.right, target1, target2);
            if (isFound) {
                return true;
            }
            result.deleteCharAt(result.length() - 1);
            return false;
        }

        private int[] findNumberOfEdges(TreeNode node, int target1, int target2) {
            int[] arr = new int[2];
            if (node == null) {
                return arr;
            } else if (node.val == target1 || node.val == target2) {
                arr[0] = 1;
                return arr;
            }

            int[] leftResult = findNumberOfEdges(node.left, target1, target2);
            if (leftResult[0] == 1) {
                leftResult[1]++;
                return leftResult;
            }
            int[] rightResult = findNumberOfEdges(node.right, target1, target2);
            rightResult[1]++;
            return rightResult;
        }

        private TreeNode findLCA(TreeNode root, int target1, int target2) {
            if (root == null) {
                return null;
            } else if (root.val == target1 || root.val == target2) {
                return root;
            }
            TreeNode leftResult = findLCA(root.left, target1, target2);
            TreeNode rightResult = findLCA(root.right, target1, target2);
            if (leftResult != null && rightResult != null) {
                return root;
            }
            return leftResult != null ? leftResult : rightResult;
        }

        private boolean findNode(TreeNode node, int value) {
            if (node == null) {
                return false;
            } else if (node.val == value) {
                return true;
            }
            return findNode(node.left, value) || findNode(node.right, value);
        }

        public String getDirections(TreeNode root, int startValue, int destValue) {
            StringBuffer result = new StringBuffer();
            TreeNode lca = findLCA(root, startValue, destValue);
            if (lca.val != startValue && lca.val != destValue) {
                boolean isPresentLeftSide = findNode(lca.left, startValue);
                TreeNode start1 = null, start2 = null;
                if (isPresentLeftSide) {
                    start1 = lca.left;
                    start2 = lca.right;
                } else {
                    start1 = lca.right;
                    start2 = lca.left;
                }
                int noOfEdges = findNumberOfEdges(start1, startValue, destValue)[1];
                noOfEdges++;
                for (int turn = 0; turn < noOfEdges; turn++) {
                    result.append("U");
                }
                if (isPresentLeftSide) {
                    result.append("R");
                } else {
                    result.append("L");
                }
                
                appendRemainingPath(result, start2, startValue, destValue);
            } else if (lca.val == startValue) {
                appendRemainingPath(result, lca, destValue, destValue);
            } else {
                int noOfEdges = findNumberOfEdges(lca, startValue, startValue)[1];
                for (int turn = 0; turn < noOfEdges; turn++) {
                    result.append("U");
                }
            }
            return result.toString();
        }
    }
}
