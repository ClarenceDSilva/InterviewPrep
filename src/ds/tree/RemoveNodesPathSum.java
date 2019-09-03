package ds.tree;

/*Question: Truncate binary tree to remove nodes which lie on a path(root to leaf) sum
 * less than K */
public class RemoveNodesPathSum {
	
	//Function to perform inorder traversal of the tree
	public static void inorder(Node root) {
		if(root == null) {
			return;
		}
		inorder(root.left);
		System.out.println(root.data + " ");
		inorder(root.right);
	}
	
	// Function to check if the given node is leaf or not
	public static boolean isLeaf(Node node) {
		return(node.left == null && node.right == null);
	}
	
	//The main function which removes nodes which lie
	//on path having sum less than K
	public static Node removeNodes(Node current, int K, int sum) {
		if(current == null) {
			return null;
		}
		
		sum += current.data;
		
		//Recursively truncating left and right subtrees
		current.left = removeNodes(current.left, K, sum);
		current.right = removeNodes(current.right, K, sum);
		
		//If the current node is leaf and its path from
		//root has sum<K, remove the node
		if(sum < K && isLeaf(current)) {
			//Setting the current node as null
			return null;
		}
		
		return current;
	}
	
	//Function to truncate the binary tree to remove nodes
	//which lie on a path having sum less than K
	public static Node truncate(Node root, int K) {
		int sum = 0;
		return removeNodes(root, K, sum);
	}
	
	
	public static void main(String[] args) {
		
		/* Constructing below tree
		        6
		      /   \
		     /     \
		    3       8
		          /   \
		         /     \
		        4       2
		      /   \      \
		     /     \      \
		    1       7      3
		*/
		
		Node root = new Node(6);
		root.left = new Node(3);
		root.right = new Node(8);
		root.right.left = new Node(4);
		root.right.right = new Node(2);
		root.right.left.left = new Node(1);
		root.right.left.right = new Node(7);
		root.right.right.right  = new Node(3);
		
		int k = 20;
		root = truncate(root, k);
		inorder(root);

	}
}
