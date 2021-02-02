/* Implemented BFS */

package algorithms.searching;

import java.util.ArrayList;

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
	
	public ArrayList<Integer> BFS() {
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Node> queue = new ArrayList<>();
		queue.add(this.root);
		while(queue.size()!=0) {
			Node currentNode = queue.remove(0);
			list.add(currentNode.value);
			if(currentNode.left!=null) {
				queue.add(currentNode.left);
			}
			if(currentNode.right!=null) {
				queue.add(currentNode.right);
			}
		}
		return list;
	}

	public ArrayList<Integer>recursiveBFS(ArrayList<Node> queue, ArrayList<Integer> list) {
		if (queue.size()==0) {
			return list;
		}
		while(queue.size()!=0) {
			Node currentNode = queue.remove(0);
			list.add(currentNode.value);
			if(currentNode.left!=null) {
				queue.add(currentNode.left);
			}
			if(currentNode.right!=null) {
				queue.add(currentNode.right);
			}
		}
		return recursiveBFS(queue,list);
	}
	
	public ArrayList<Integer>preorderDFS() {
		ArrayList<Integer> list = new ArrayList<>();
		return preorderTraverse(this.root,list);
	}
	
	public ArrayList<Integer>inorderDFS() {
		ArrayList<Integer> list = new ArrayList<>();
		return inorderTraverse(this.root,list);
	}
	
	public ArrayList<Integer>postorderDFS() {
		ArrayList<Integer> list = new ArrayList<>();
		return postorderTraverse(this.root,list);
	}
	
	public ArrayList<Integer>preorderTraverse(Node currentNode, ArrayList<Integer> list) {
		list.add(currentNode.value);
		if(currentNode.left!=null) {
			preorderTraverse(currentNode.left, list);
		}
		if(currentNode.right!=null) {
			preorderTraverse(currentNode.right, list);
		}
		return list;
	}
	
	public ArrayList<Integer>inorderTraverse(Node currentNode, ArrayList<Integer> list) {
		if(currentNode.left!=null) {
			inorderTraverse(currentNode.left, list);
		}
		list.add(currentNode.value);
		if(currentNode.right!=null) {
			inorderTraverse(currentNode.right, list);
		}
		return list;
	}
	
	public ArrayList<Integer>postorderTraverse(Node currentNode, ArrayList<Integer> list) {
		if(currentNode.left!=null) {
			postorderTraverse(currentNode.left, list);
		}
		if(currentNode.right!=null) {
			postorderTraverse(currentNode.right, list);
		}
		list.add(currentNode.value);
		return list;
	}
	
	public static void main(String[] args) {
		BinarySearchTree case1 = new BinarySearchTree();
		case1.insert(13);
		case1.insert(10);
		case1.insert(11);
		case1.insert(9);
		case1.insert(15);
		case1.insert(18);
		System.out.println(case1.BFS());
		ArrayList<Node> queue = new ArrayList<>();
		queue.add(case1.root);
		ArrayList<Integer> list = new ArrayList<>();
		System.out.println(case1.recursiveBFS(queue, list));
		System.out.println("--------Testing-------");
		System.out.println(case1.preorderDFS());
		System.out.println(case1.inorderDFS());
		System.out.println(case1.postorderDFS());
		
		
	}

}

