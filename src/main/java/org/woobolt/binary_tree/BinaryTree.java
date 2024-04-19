package org.woobolt.binary_tree;

public class BinaryTree {

	BinaryTreeNode root;
	
	public void insert(int value) {
		root = insertRecursive(root, value);
	
	}

	private BinaryTreeNode insertRecursive(BinaryTreeNode root, int value) {

		if(root == null)
			root = new BinaryTreeNode(value);
		else if(value < root.value) 
			root.left = insertRecursive(root.left, value);
		else if(value > root.value)
			root.right = insertRecursive(root.right, value);
		
		return root;
	}
	
	public void inOrder() {
		inOrderRecursive(root);
	}

	private void inOrderRecursive(BinaryTreeNode root) {

		if(root != null) {
			inOrderRecursive(root.left);
			System.out.print(root.value + "\t");
			inOrderRecursive(root.right);
		}
		
	}
	
	public void preOrder() {
		preOrderRecursive(root);
	}

	private void preOrderRecursive(BinaryTreeNode root) {

		if(root != null) {
			System.out.print(root.value + "\t");
			inOrderRecursive(root.left);
			inOrderRecursive(root.right);
		}
		
	}
	
}
