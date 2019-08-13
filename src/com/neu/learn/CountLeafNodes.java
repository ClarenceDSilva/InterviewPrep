 package com.neu.learn;

/*Program to count the number of leaf nodes of a tree*/
class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int data){
		this.data = data;
		left = right = null;
	}
}

public class CountLeafNodes {
	// Initialize a root node
	TreeNode root;
	int getLeafCount() {
		return getLeafCount(root);
	}
	
	public int getLeafCount(TreeNode node) {
		// If Node is null
		if(node == null)
			return 0;
		// If only one node is present
		if(node.left == null && node.right == null)
			return 1;
		else
			return getLeafCount(node.left) + getLeafCount(node.right);
	}
	
	// Driver method
	public static void main(String[] args) {
		// Create a Binary tree
		CountLeafNodes tree = new CountLeafNodes();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.right.right = new TreeNode(5);
		
		System.out.println("LEAF COUNT IS: "+ tree.getLeafCount());
	}

}