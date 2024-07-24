package DSA.BinarySearchTrees;

import java.util.ArrayList;

public class KthLargestElementNaiveSolution {
    class Solution
    {        
        private void findInorderTraversal(Node root, ArrayList<Integer> inorder) {
            if (root == null) {
                return;
            }

            findInorderTraversal(root.left, inorder);
            inorder.add(root.data);
            findInorderTraversal(root.right, inorder);
        }
        
        public int kthLargest(Node root,int K) {
            ArrayList<Integer> inorder = new ArrayList<>();
            findInorderTraversal(root, inorder);
            int N = inorder.size();
            return inorder.get(N - K);
        }
    }
}
