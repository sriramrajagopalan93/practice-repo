package tree.binarysearchtree;

import java.util.ArrayList;
import java.util.List;

public class ValidateBST {

	BSTNode root;

	ValidateBST() {
		this.root = null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		int array[] = { 10, 5, 15, 3, 6, 14, 16 }; //VALID BST
//		int array[] = { 10, 5, 15, 3, 41, 14, 16 }; // currentNode.left.right> currentNode (where currentNode is 10)
		int array[] = { 10, 5, 15, 3, 8, 9, 16 }; // currentNode.right.left < currentNode(where currentNode is 10)
//		int array[] = { 10, 5, 15, 3, 10, 10, 16 }; //TO WORK IN CASE OF EQUAL VALUE IN PARENT AND CHILD NODES
		ValidateBST validateBST = new ValidateBST();
		validateBST.convertArrayToBinaryTree(array);

		// print binary tree through BF Traversal
		List<Integer> bfsResultArray = new ArrayList<Integer>();
		List<BSTNode> queue = new ArrayList<BSTNode>();
		queue.add(validateBST.root);
		validateBST.bfsRecursive(queue, bfsResultArray);

		// validate BST
		queue.clear();
		queue.add(validateBST.root);
//		validateBST.isBST(queue);//SIMPLE BUT WRONG --> will not work if currentNode.left.right> currentNode

		// validate BST -FIX
		boolean isBst;
		isBst = validateBST.isValidBST(validateBST.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		if (isBst)
			System.out.println("Valid BST!");

		// TO SUPPORT EQUAL VALUES FOR LEFT/RIGHT CHILD
		isBst = validateBST.isValidBSTSupportEquals(validateBST.root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		if (isBst)
			System.out.println("Valid BST!");

	}

	// ONLY WORKS IF ALL NODES ARE DISTINCT (PARENT DOESN'T EQUAL TO CHILD VALUE)
	boolean isValidBST(BSTNode currentNode, int min, int max) {
		/* an empty tree is BST */
		if (currentNode == null) {
			return true;
		}

		/* false if this node violates the min/max constraints */
		if (currentNode.value < min) { // currentNode is the right child of parent or parent's parent left->right child
			System.out.println("Not a BST because " + currentNode.value + " is lesser than " + (min - 1));
			return false;
		}
		if (currentNode.value > max) { // currentNode is the left child of parent or parent's parent right->left child
			System.out.println("Not a BST because " + currentNode.value + " is greater than " + (max + 1));
			return false;
		}

		/*
		 * otherwise check the subtrees recursively tightening the min/max constraints
		 */
		// Allow only distinct values
		return (isValidBST(currentNode.left, min, currentNode.value - 1) // on left traverse don't change min, only
																			// change max
				&& isValidBST(currentNode.right, currentNode.value + 1, max)); // on right traverse don't change max,
																				// only change min. Max value will be
																				// right child's parent's parent value.
																				// Min value will be parent's value.
	}

	// TO SUPPORT EQUAL VALUES FOR LEFT/RIGHT CHILD
	boolean isValidBSTSupportEquals(BSTNode currentNode, int min, int max) {
		/* an empty tree is BST */
		if (currentNode == null) {
			return true;
		}

		/* false if this node violates the min/max constraints */
		if (currentNode.value < min) { // currentNode is the right child of parent or parent's parent left->right child
			System.out.println("Not a BST because " + currentNode.value + " is lesser than " + (min));
			return false;
		}
		if (currentNode.value > max) { // currentNode is the left child of parent or parent's parent right->left child
			System.out.println("Not a BST because " + currentNode.value + " is greater than " + (max));
			return false;
		}

		/*
		 * otherwise check the subtrees recursively tightening the min/max constraints
		 */
		// Allow only distinct values
		return (isValidBSTSupportEquals(currentNode.left, min, currentNode.value)// on left traverse don't change min,
																					// only change max
				&& isValidBSTSupportEquals(currentNode.right, currentNode.value, max)); // on right traverse don't
																						// change max, only change min.
																						// Max value will be
																						// right child's parent's parent value.
																						// Min value will be parent's value.
	}

	// SIMPLE BUT WRONG --> will not work if currentNode.left.right> currentNode
	private boolean isBST(List<BSTNode> queue) {
		if (queue.isEmpty()) {
			System.out.println("This is a valid BST!");
			return true;
		}

		BSTNode currentNode = queue.remove(0);

		if (currentNode.left != null) {
			if (currentNode.left.value > currentNode.value) {
				System.out.println("Not a BST because " + currentNode.value + " is lesser than its left child value "
						+ currentNode.left.value);
				return false;
			}
			queue.add(currentNode.left);
		}
		if (currentNode.right != null) {
			if (currentNode.right.value < currentNode.value) {
				System.out.println("Not a BST because " + currentNode.value + " is greater than its right child value "
						+ currentNode.right.value);
				return false;
			}
			queue.add(currentNode.right);
		}
		return isBST(queue);
	}

	private void convertArrayToBinaryTree(int[] array) {
		int length = array.length;
		BSTNode bstNode[] = new BSTNode[length];
		for (int i = 0; i < length; i++) {
			bstNode[i] = new BSTNode(array[i]);
		}
		this.root = bstNode[0];
		BSTNode currentNode = this.root;
		for (int i = 0; i < length; i++) {
			if (i != 0) { // or if currentNode!= root
				currentNode = bstNode[i];
			}
			int left = 2 * i + 1;
			int right = 2 * i + 2;
			if (left < length) {
				currentNode.left = bstNode[left];
			}
			if (right < length) {
				currentNode.right = bstNode[right];
			}
		}

	}

	private void bfsRecursive(List<BSTNode> queue, List<Integer> resultArray) {
		if (queue.isEmpty()) {// base case
			System.out.println("BFS Recursive Result: " + resultArray.toString());
			return;
		}
		BSTNode currentNode = queue.remove(0);
		if (currentNode.left != null) {
			queue.add(currentNode.left);
		}
		if (currentNode.right != null) {
			queue.add(currentNode.right);
		}
		resultArray.add(currentNode.value);
		bfsRecursive(queue, resultArray);
	}

}
