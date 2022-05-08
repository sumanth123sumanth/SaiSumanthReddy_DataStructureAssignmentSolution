package com.greatlearning.bst;

class Node {
	int value;
	Node left, right;

	Node(int item) {
		value = item;
		left = right = null;
	}
}

public class BST {
	
	static Node node;
	static Node prevNode = null;
	static Node headNode = null;

	static void convertBSTToRightSkewedTree(Node root) {
		if (root == null) {
			return;
		}

		convertBSTToRightSkewedTree(root.left);

		Node rightNode = root.right;

		if (headNode == null) {
			headNode = root;
			root.left = null;
			prevNode = root;
		} else {
			prevNode.right = root;
			root.left = null;
			prevNode = root;
		}

		convertBSTToRightSkewedTree(rightNode);
	}

	static void printRightSkewedTree(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.value + " ");
		printRightSkewedTree(root.right);
	}

	public static void main(String[] args) {
		BST tree = new BST();
		tree.node = new Node(50);
		tree.node.left = new Node(30);
		tree.node.right = new Node(60);
		tree.node.left.left = new Node(10);
		tree.node.right.left = new Node(55);

		convertBSTToRightSkewedTree(node);
		printRightSkewedTree(headNode);
	}

}
