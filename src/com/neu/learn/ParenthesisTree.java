/* Question: Given a tree represented by Parenthesis where..
 * () - Leaf Node 
 * (()) - Non-leaf node(Parenthesis enclosing a Leaf Node)
 * Determine if 2 trees are same.
 * Two trees are same if they have the same number of leaf and non-leaf nodes
 * 
 * Asked at Audible onsite
 */
package com.neu.learn;

import java.util.Stack;

class Tree{
	String data;
	int leaf;
	int nonLeaf;
	
	Tree(String data, int leaf, int nonLeaf) {
		this.data = data;
		this.leaf = leaf;
		this.nonLeaf = nonLeaf;
	}
}

public class ParenthesisTree {
	public boolean areTreesEqual(String tree1, String tree2) {
		Tree t1 = new Tree(tree1, 0, 0);
		Tree t2 = new Tree(tree2, 0, 0);
		countLeafNonleafNodes(t1);
		countLeafNonleafNodes(t2);
		
		if(t1.leaf < 0 || t2.leaf < 0 || t1.nonLeaf < 0 || t2.nonLeaf < 0) {
			return false;
		}
		
		return (t1.leaf == t2.leaf) && (t1.nonLeaf == t2.nonLeaf);
	}
	
	public void countLeafNonleafNodes(Tree tree) {
		boolean isLeaf = false;
		char[] treeChar = tree.data.toCharArray();
		Stack<Character> stack = new Stack<>();
		for(char c : treeChar) {
			if(c == '(') {
				if(isLeaf)
					isLeaf = false;
				stack.push(c);
			}else if(c == ')' && !stack.isEmpty() && stack.pop() == '(') {
				if(!isLeaf){
					tree.leaf++;
					isLeaf = true;
				}else {
					tree.nonLeaf++;
				}
			}else {
				tree.leaf = -1;
				return;
			}
		}
	}
	public static void main(String[] args) {
		String tree1 = "((()))()";
		String tree2 = "(())(())";
		ParenthesisTree pt = new ParenthesisTree();
		boolean result = pt.areTreesEqual(tree1, tree2);
		System.out.println(result);
	}
}
