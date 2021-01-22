package datastructures.trees.binarySearchTree;

 
 
/* Binary Search tree implementation */	

class Node {
	Node left;
	Node right;
	int value;
	
	public Node(int value) {
		this.left = null;
		this.right = null;
		this.value = value;
	}
}

public class BinarySearchTree {
	Node root;
	
	public BinarySearchTree() {
		this.root = null;
	}

	public void insert(int value) {
		Node newNode = new Node(value);
		if(this.root==null) {
			this.root = newNode;
		} else {
			Node currentNode = this.root;
			while(true) {
				if(newNode.value < currentNode.value) {
					if(currentNode.left==null) {
						currentNode.left = newNode;
						break;
					} else {
						currentNode = currentNode.left;
					}
				} else {
					if(currentNode.right == null) {
						currentNode.right = newNode;
						break;
					} else {
						currentNode = currentNode.right;
					}
				}
				
			}
		}
		
	}
	
	public Boolean lookup(int value) {
		Node currentNode = this.root;
		while(currentNode!=null) {
			if(currentNode.value == value) {
				return true;
			} else if(value < currentNode.value) {
				currentNode = currentNode.left;
			} else if(value > currentNode.value) {
				currentNode = currentNode.right;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		BinarySearchTree case1 = new BinarySearchTree();
		case1.insert(13);
		case1.insert(10);
		case1.insert(11);
		case1.insert(9);
		case1.insert(15);
		case1.insert(18);
		System.out.println(case1.lookup(17));
		
		
	}

}

