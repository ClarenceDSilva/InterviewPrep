package ds.tree;

/*Question: Convert a binary tree to full tree by removing half nodes*/

public class BinTreeToFullTree {
	// Function to perform in order traversal of the tree after removing all the half nodes
	public static void inorder(Node root)
	{
		if (root == null) {
			return;
		}

		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}

	// Function to check if given node is a leaf node or not
	public static boolean isLeaf(Node node) {
		return (node.left == null && node.right == null);
	}

	// Function to convert a binary tree to full tree by removing half nodes
	// i.e. remove nodes having one children
	public static Node truncate(Node root)
	{
		// base case: empty tree
		if (root == null) {
			return null;
		}

		// recursively truncate the left subtree and subtree first
		root.left = truncate(root.left);
		root.right = truncate(root.right);
		//System.out.println("LEFT: "+ root.left.data+" RIGHT: "+ root.right.data);

		// if current node has two children or it is leaf node,
		// nothing needs to be done
		if ((root.left != null && root.right != null) || isLeaf(root)) {
			System.out.println("ROOT: "+ root.data);
			return root;
		}

		// if current node has exactly one child, then delete it and replace
		// the node by the child node
		Node child = (root.left != null) ? root.left: root.right;
		System.out.println("PARENT: "+root.data+"CHILD: "+ child.data);
		return child;
	}

	// main function
	public static void main(String[] args)
	{
	    /* Construct below tree
	                 0
	               /   \
	              /     \
	             1       2
	            /        /
	           /        /
	          3        4
	         /        / \
	        /        /   \
	       5        6     7
	    */

		Node root = new Node(0);
		root.left = new Node(1);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.right.left = new Node(4);
		root.left.left.left = new Node(5);
		root.right.left.left = new Node(6);
		root.right.left.right = new Node(7);

		truncate(root);
		inorder(root);
	}
}