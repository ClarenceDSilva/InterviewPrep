package ds.tree;

/*Leetcode #285: Inorder Successor in a BST */
public class InorderSuccessorBST {
	
	public Node getSuccessor(Node root, int data){
		Node current = find(root, data);
		if(current == null){
			return null;
		}
		if(current.right != null){ // Case1: Node has a right subtree
			return findMin(current.right);
		}else{
			//Case2: Node has no right subtree
			Node successor = null;
			Node ancestor = root;
			while(ancestor != current){
				if(current.data <  ancestor.data){
					successor = ancestor; // So far, this is the deepest node for which the current node is at left
					ancestor = ancestor.left;
				}else{
					ancestor = ancestor.right;
				}
				return successor;
			}
		}
		return null;
	}

	//Function to find some data in the tree
	public Node find(Node root, int data){
		if(root == null){
			return null;
		}else if(root.data == data){
			return root;
		}else if(root.data < data){
			return find(root.right, data);
		}else{
			return find(root.left, data);
		}
	}

	// Function to find min value in BST
	public Node findMin(Node root){
		if(root == null){
			return null;
		}
		while(root.left != null){
			root = root.left;
		}
		return root;
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
	root.right.right = new Node(25);
	root.right.left.left = new Node(10);
	root.right.left.right = new Node(17);
	root.right.right.right  = new Node(30);
	
	InorderSuccessorBST iSuccessor = new InorderSuccessorBST();
	Node result = iSuccessor.getSuccessor(root, 25);
	int res = result == null ? Integer.MIN_VALUE : result.data;
	System.out.println("Inorder successor of "+ 25 + " is " + res);
	}
}
