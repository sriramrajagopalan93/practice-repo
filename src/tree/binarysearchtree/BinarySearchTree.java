package tree.binarysearchtree;

import java.util.ArrayList;
import java.util.List;


public class BinarySearchTree {

	BSTNode root;

	BinarySearchTree() {
		this.root = null;
	}

	public static void main(String[] args) {
		BinarySearchTree binarySearchTree = new BinarySearchTree();
		binarySearchTree.insert(10);
		binarySearchTree.insert(8);
		binarySearchTree.insert(5);
		binarySearchTree.insert(20);
		binarySearchTree.insert(15);
		binarySearchTree.insert(25);
		binarySearchTree.insert(23);
		binarySearchTree.insert(26);
		binarySearchTree.insert(24);
		binarySearchTree.insert(9);
		binarySearchTree.lookup(20);
//		binarySearchTree.remove(20);
		binarySearchTree.lookup(20);
//		binarySearchTree.traverse(binarySearchTree.root);

		/*
		 *              10
		 *          8      20
		 *        5  9   15    25
		 *                   23   26
		 *                    24 
		 */
		
		binarySearchTree.bfsIterative();
		List<Integer> bfsResultArray = new ArrayList<Integer>();
		List<BSTNode> queue = new ArrayList<BSTNode>();
		queue.add(binarySearchTree.root);
		binarySearchTree.bfsRecursive(queue, bfsResultArray);

		List<Integer> dfsResultArray = new ArrayList<Integer>();
		binarySearchTree.dfsInorder(binarySearchTree.root, dfsResultArray);
		System.out.println("DFS Inorder Result: "+dfsResultArray.toString());
		
		dfsResultArray.clear();
		binarySearchTree.dfsPreorder(binarySearchTree.root, dfsResultArray);
		System.out.println("DFS Preorder Result: "+dfsResultArray.toString());
		
		dfsResultArray.clear();
		binarySearchTree.dfsPostorder(binarySearchTree.root, dfsResultArray);
		System.out.println("DFS Postorder Result: "+dfsResultArray.toString());
	}

	// ascending order maintained
	private List<Integer> dfsInorder(BSTNode currentNode, List<Integer> dfsResultArray) {
		if(currentNode == null) {
			return dfsResultArray;
		}
		if(currentNode.left != null) {
			dfsInorder(currentNode.left,dfsResultArray);
		}
		dfsResultArray.add(currentNode.value);
		if(currentNode.right != null) {
			dfsInorder(currentNode.right,dfsResultArray);
		}
		return dfsResultArray;
	}
	private List<Integer> dfsPreorder(BSTNode currentNode, List<Integer> dfsResultArray) {
		if(currentNode == null) {
			return dfsResultArray;
		}
		dfsResultArray.add(currentNode.value);
		if(currentNode.left != null) {
			dfsPreorder(currentNode.left,dfsResultArray);
		}
		if(currentNode.right != null) {
			dfsPreorder(currentNode.right,dfsResultArray);
		}
		return dfsResultArray;
	}
	
	private List<Integer> dfsPostorder(BSTNode currentNode, List<Integer> dfsResultArray) {
		if(currentNode == null) {
			return dfsResultArray;
		}
		if(currentNode.left != null) {
			dfsPostorder(currentNode.left,dfsResultArray);
		}
		if(currentNode.right != null) {
			dfsPostorder(currentNode.right,dfsResultArray);
		}
		dfsResultArray.add(currentNode.value);
		return dfsResultArray;
	}

	// For BFS an additional memory (Queue) is needed to store parent node info (as we go horizontally)
	private void bfsRecursive(List<BSTNode> queue, List<Integer> resultArray) {
		if(queue.isEmpty()) {//base case
			System.out.println("BFS Recursive Result: "+resultArray.toString());
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
		bfsRecursive(queue,resultArray);
	}

	private void bfsIterative() {
		BSTNode currentNode = this.root;
		List<Integer> resultArray = new ArrayList<Integer>();
		List<BSTNode> queue = new ArrayList<BSTNode>();
		queue.add(currentNode);
		while (!queue.isEmpty()) {
			currentNode = queue.remove(0);
			if (currentNode.left != null) {
				queue.add(currentNode.left);
			}
			if (currentNode.right != null) {
				queue.add(currentNode.right);
			}
			resultArray.add(currentNode.value);
		}
		System.out.println("BFS Iterative Result: "+resultArray.toString());
	}

	// go to leftmost of each node (deeper)and as we come up (returning) right nodes
	// of them will be printed
	private BSTNode traverse(BSTNode node) {
		if (node != null) {
			System.out.print(node.value + " ");
		}
		node.left = node.left == null ? null : traverse(node.left);
		node.right = node.right == null ? null : traverse(node.right);
		return node;
	}

	private void insert(int value) {
		BSTNode newNode = new BSTNode(value);
		if (this.root == null) {
			this.root = newNode;
			return;
		}
		BSTNode node = this.root;
		while (true) {
			// duplicates not allowed
			if (newNode.value < node.value) {
				if (node.left == null) {
					node.left = newNode;
					return;
				}
				node = node.left;
			} else if (newNode.value > node.value) {
				if (node.right == null) {
					node.right = newNode;
					return;
				}
				node = node.right;
			}
		}

	}

	private void lookup(int value) {
		BSTNode node = this.root;
		while (node != null) {
			if (value < node.value) {
				node = node.left;
			} else if (value > node.value) {
				node = node.right;
			} else {
				System.out.println("Number " + value + " is present in BST");
				return;
			}
		}
		System.out.println("Number " + value + " is not present in BST");
	}

	private void remove(int value) {
		BSTNode currentNode = this.root;
		BSTNode parentNode = null;
//		if(this.root.value == value) {
//			this.root = this.root
//			System.out.println("Removed: "+value);
//		}

		while (currentNode != null) {

			if (value < currentNode.value) {
				parentNode = currentNode;
				currentNode = currentNode.left;
			} else if (value > currentNode.value) {
				parentNode = currentNode;
				currentNode = currentNode.right;
			} else if (currentNode.value == value) {
				// Option 1: No right child:
				if (currentNode.right == null) {
					if (parentNode == null) { // if current node is the root node
						this.root = currentNode.left;
					} else {
						// if parent > current value, make current's left child a child of parent
						if (currentNode.value < parentNode.value) {
							parentNode.left = currentNode.left;

							// if parent < current value, make left child a right child of parent
						} else if (currentNode.value > parentNode.value) {
							parentNode.right = currentNode.left;
						}
					}
				}
				// Option 2: Right child which doesnt have a left child
				else if (currentNode.right.left == null) {
					currentNode.right.left = currentNode.left;
					if (parentNode == null) {
						this.root = currentNode.right;
					} else {

						// if parent > current, make right child of the left the parent
						if (currentNode.value < parentNode.value) {
							parentNode.left = currentNode.right;

							// if parent < current, make right child a right child of the parent
						} else if (currentNode.value > parentNode.value) {
							parentNode.right = currentNode.right;
						}
					}
				}
				// Option 3: Right child that has a left child
				else {
					// find the Right child's left most child
					BSTNode leftmost = currentNode.right.left;
					BSTNode leftmostParent = currentNode.right;
					while (leftmost.left != null) {
						leftmostParent = leftmost;
						leftmost = leftmost.left;
					}

					// Parent's left subtree is now leftmost's right subtree
					leftmostParent.left = leftmost.right;
					leftmost.left = currentNode.left;
					leftmost.right = currentNode.right;

					if (parentNode == null) {
						this.root = leftmost;
					} else {
						if (currentNode.value < parentNode.value) {
							parentNode.left = leftmost;
						} else if (currentNode.value > parentNode.value) {
							parentNode.right = leftmost;
						}
					}
				}
				return;
			}
		}

	}

}
