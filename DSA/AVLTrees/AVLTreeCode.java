package DSA.AVLTrees;


import java.util.Queue;
import java.util.LinkedList;

class AVLTreeNode {
	int data;
	AVLTreeNode left;
	AVLTreeNode right;
	int height;

	public AVLTreeNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
		this.height = 1;
	}
}

class AVLTree {
	AVLTreeNode root;

	public AVLTree() {
		this.root = null;
	}

	private int height(AVLTreeNode root) {
		if (root == null) {
			return 0;
		} else {
			return root.height;
		}
	}

	private AVLTreeNode rightRotate(AVLTreeNode root) {
		AVLTreeNode leftNode = root.left;
		root.left = leftNode.right;
		leftNode.right = root;
		root.height = 1 + Math.max(height(root.left), height(root.right));
		leftNode.height = 1 + Math.max(height(leftNode.left), height(leftNode.right));
		return leftNode;
	}

	private AVLTreeNode leftRotate(AVLTreeNode root) {
		AVLTreeNode rightNode = root.right;
		root.right = rightNode.left;
		rightNode.left = root;
		root.height = 1 + Math.max(height(root.left), height(root.right));
		rightNode.height = 1 + Math.max(height(rightNode.left), height(rightNode.right));
		return rightNode;
	}

	private AVLTreeNode insertHelper(AVLTreeNode root, int data) {
		if (root == null) {
			System.out.println("Created a new node with data: " + data);
			return new AVLTreeNode(data);
		} else if (root.data > data) {
			root.left = insertHelper(root.left, data);
		} else {
			root.right = insertHelper(root.right, data);
		}

		int leftSubtreeHeight = height(root.left);
		int rightSubtreeHeight = height(root.right);
		int balanceFactor = leftSubtreeHeight - rightSubtreeHeight;

		if (balanceFactor > 1) {
			if (root.left.data > data) {
				// Left-Left
				System.out.println("Left-Left case, so doing Right rotation");
				return rightRotate(root);
			} else {
				// Left-Right
				System.out.println("Left-Right case, so doing Left and then Right rotation");
				root.left = leftRotate(root.left);
				return rightRotate(root);
			}
		} else if (balanceFactor < -1) {
			if (root.right.data < data) {
				// Right-Right
				System.out.println("Right-Right case, so doing Left rotation");
				return leftRotate(root);
			} else {
				// Right-Left
				System.out.println("Right-Left case, so doing Right and then Left rotation");
				root.right = rightRotate(root.right);
				return leftRotate(root);
			}
		}

		root.height = 1 + Math.max(leftSubtreeHeight, rightSubtreeHeight);
		return root;
	}

	public void insertNodeIntoAVLTree(int data) {
		this.root = insertHelper(this.root, data);
	}

	public void printLevelOrderTraversal() {
		AVLTreeNode root = this.root;
		if (root == null) {
			System.out.println("AVL Tree is Empty");
			return;
		}

		System.out.println("Level order traversal is: ");
		Queue<AVLTreeNode> Q = new LinkedList<>();
		Q.add(root);

		while (!Q.isEmpty()) {
			int n = Q.size();
			for (int index = 0; index < n; index++) {
				AVLTreeNode currNode = Q.poll();
				System.out.print(currNode.data + " ");

				if (currNode.left != null) {
					Q.add(currNode.left);
				}

				if (currNode.right != null) {
					Q.add(currNode.right);
				}
			}
			System.out.println();
		}
	}

	private int findBalanceFactor(AVLTreeNode root) {
		if (root == null) {
			return 0;
		} else {
			return height(root.left) - height(root.right);
		}
	}

	private AVLTreeNode deleteHelper(AVLTreeNode root, int target) {
		if (root == null) {
			return null;
		} else if (root.data == target) {
			if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			} else {
				AVLTreeNode currNode = root.left;
				while (currNode.right != null) {
					currNode = currNode.right;
				}
				root.data = currNode.data;
				root.left = deleteHelper(root.left, currNode.data);
			}
		} else if (root.data > target) {
			root.left = deleteHelper(root.left, target);

		} else {
			root.right = deleteHelper(root.right, target);
		}

		int balanceFactor = findBalanceFactor(root);
		if (balanceFactor > 1) {
			if (findBalanceFactor(root.left) >= 0) {
				// Left-Left
				return rightRotate(root);
			} else {
				// Left-Right
				root.left = leftRotate(root.left);
				return rightRotate(root);
			}
		} else if (balanceFactor < -1) {
			if (findBalanceFactor(root.right) <= 0) {
				// Right-Right
				return leftRotate(root);
			} else {
				// Right-Left
				root.right = rightRotate(root.right);
				return leftRotate(root);
			}
		}

		root.height = 1 + Math.max(height(root.left), height(root.right));
		return root;
	}

	public void deleteNodeFromAvlTree(int target) {
		this.root = deleteHelper(this.root, target);
		System.out.println(target + " deleted successfully");
	}
}


class AVLTreeCode {
	public static void main(String[] args) {
		AVLTree tree = new AVLTree();
		tree.insertNodeIntoAVLTree(10);
		tree.insertNodeIntoAVLTree(20);
		tree.insertNodeIntoAVLTree(30);
		tree.printLevelOrderTraversal();
		tree.insertNodeIntoAVLTree(35);
		tree.insertNodeIntoAVLTree(33);
		tree.printLevelOrderTraversal();
		tree.deleteNodeFromAvlTree(10);
		tree.printLevelOrderTraversal();


	}
}