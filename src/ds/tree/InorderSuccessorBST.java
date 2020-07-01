package ds.tree;

/*Leetcode #285: Inorder Successor in a BST */
public class InorderSuccessorBST {
	
	public static Node inorderSuccessor(Node root, Node x) {
		if(root == null) {
			return null;
		}
		Node next = null;
		Node p = root;
		while(x != null && p.data != x.data) {
			if(p.data > x.data) {
				//Move left
				next = p;
				p = p.left;
			}else {
				p = p.right;
			}
		}
		if(p == null) {
			return null;
		}
		if(p.right == null) {
			return next;
		}
		p = p.right;
		//While there is still left nodes to traverse
		while(p.left != null) {
			p = p.left;
		}
		return p;
	}
	
	public static void main(String[] args) {
		/* Constructing below tree 
	        6
	      /   \
	     /     \
	    3       20
	          /   \
	         /     \
	        15     25
	      /   \      \
	     /     \      \
	    10      17    30
	*/
	
	Node root = new Node(6);
	root.left = new Node(3);
	root.right = new Node(20);
	root.right.left = new Node(15);
	Node x = root.right.right = new Node(25);
	root.right.left.left = new Node(10);
	root.right.left.right = new Node(17);
	root.right.right.right  = new Node(30);
	
	Node result = inorderSuccessor(root, x);
	System.out.println("Inorder successor of "+ x.data + " is " + result.data);
	}
}
