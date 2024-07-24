package DSA.BinarySearchTrees;

public class KthLargestElementOptimizedSolution {
    class Solution
    {
        // return the Kth largest element in the given BST rooted at 'root'
        
        private void findResultUsingReverseInorder(Node root, int[] arr) {
            if (root == null) {
                return;
            }

            findResultUsingReverseInorder(root.right, arr);
            arr[0]--;
            if (arr[0] == 0) {
                arr[1] = root.data;
            }
            findResultUsingReverseInorder(root.left, arr);
        }
        
        public int kthLargest(Node root,int K) {
            int[] arr = new int[2];
            arr[0] = K;
            arr[1] = -1;
            findResultUsingReverseInorder(root, arr);
            return arr[1];
        }
    }
}
