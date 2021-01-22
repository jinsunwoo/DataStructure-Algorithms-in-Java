package datastructures.linkedlists;

import java.util.Arrays;

class Node {
	int value;
	Node next;
	
	public Node(int value) {
		this.value = value;
		this.next = null;
	}
}

public class LinkedList {
	Node head;
	Node tail;
	int length;
	
	public LinkedList(int value) {
		Node node = new Node(value);
		this.head = node;
		this.tail = node;
		this.length = 1;
		
	}
	
	// append
	public void append(int value) {
		Node node = new Node(value);
		this.tail.next = node;
		this.tail = node;
		this.length++;
	}
	
	// prepend
	public void prepend(int value) {
		Node node = new Node(value);
		node.next = this.head;
		this.head = node;
		this.length++;
	}

	// insert
	public void insert (int index, int value) {
		if (index < 0 || index >= this.length) {
			System.err.println("Index out of bounds");
		} else if (index == 0) {
			this.prepend(value);
		} else {
			Node node = new Node(value);
			int counter = 0;
			Node currentNode = this.head;
			while(counter!=index-1) {
				currentNode = currentNode.next;
				counter ++;
			}
			Node prevNewNode = currentNode;
			Node nextNewNode = currentNode.next;
			prevNewNode.next = node;
			node.next = nextNewNode;
			this.length++;
		}
	}
	
	// remove
	public void remove(int index) {
		if(index < 0 || index >= this.length) {
			System.err.println("Index out of bounds");
		} else if (index == 0) {
			Node newHead = this.head.next;
			this.head = newHead;
			this.length--;
		} else {
			int counter = 0;
			Node currentNode = this.head;
			while(counter!=index-1) {
				currentNode = currentNode.next;
				counter ++;
			}
			Node prevRmNode = currentNode;
			Node nextRmNode = currentNode.next.next;
			prevRmNode.next = nextRmNode;
			if(nextRmNode==null) {
				this.tail = prevRmNode;
			}
			this.length--;
		}
	}
	
	
	//printList
	public int[] printList() {
		int[] array = new int[this.length];
		int counter = 0;
		Node currentNode = this.head;
		while(currentNode!=null) {
			array[counter] = currentNode.value;
			currentNode = currentNode.next;
			counter ++;
		}
		return array;
	}
	
	// This function print out a reversed version of the current linked list
	public int[] reverse() {
		Node first = this.head;
		Node second = this.head.next;
		this.tail = first;
		this.tail.next = null; // Don't for get this!
		while(second!=null) {
			Node third = second.next;
			second.next = first;
			first = second;
			second = third;
		}
		this.head = first;
		return this.printList();
		
	}

	public static void main(String[] args) {
		LinkedList case1 = new LinkedList(10);
		case1.append(11);
		case1.append(12);
		//case1.insert(3,3);
		case1.remove(2);
		System.out.println(Arrays.toString(case1.printList()));
		//System.out.println(Arrays.toString(case1.reverse()));
		
		
		

	}

}
