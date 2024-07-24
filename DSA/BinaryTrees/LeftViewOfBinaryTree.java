package DSA.BinaryTrees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfBinaryTree {
    class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
       ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<Node> Q = new LinkedList<>();
        Q.add(root);
 
        while (!Q.isEmpty()) {
            int n = Q.size();
            for (int index = 0; index < n; index++) {
                Node node = Q.poll();
                if (index == 0) {
                    result.add(node.data);
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
