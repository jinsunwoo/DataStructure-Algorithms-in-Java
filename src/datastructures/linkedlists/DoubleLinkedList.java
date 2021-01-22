package datastructures.linkedlists;

import java.util.Arrays;

class dNode {
	int value;
	dNode next;
	dNode prev;
	
	public dNode(int value) {
		this.value = value;
		this.next = null;
		this.prev = null;
	}
}

public class DoubleLinkedList {
	dNode head;
	dNode tail;
	int length;
	
	public DoubleLinkedList(int value) {
		dNode node = new dNode(value);
		this.head = node;
		this.tail = node;
		this.length = 1;
	}
	
	// append
	public void append(int value) {
		dNode node = new dNode(value);
		this.tail.next = node;
		node.prev = this.tail;
		this.tail = node;
		this.length++;
	}
	
	// prepend
	public void prepend(int value) {
		dNode node = new dNode(value);
		node.next = this.head;
		this.head.prev = node;
		this.head = node;
		this.length++;
	}

	// insert
	public void insert (int index, int value) {
		if(index==0) {
			this.prepend(value);
		} else if(index >= this.length) {
			System.err.println("Index out of range");
		} else {
			dNode node = new dNode(value);
			int counter = 0;
			dNode currentNode = this.head;
			while(counter!=index-1) {
				currentNode = currentNode.next;
				counter ++;
			}
			dNode prevNewNode = currentNode;
			dNode nextNewNode = currentNode.next;
			prevNewNode.next = node;
			node.prev = prevNewNode;
			node.next = nextNewNode;
			nextNewNode.prev = node;
			this.length++;
		}
	}
	
	// remove
	public void remove(int index) {
		if(index < 0 || index >= this.length) {
			System.err.println("Index out of bound");
		} else if(index == 0) {
			dNode newHead = this.head.next;
			this.head = newHead;
			this.head.prev = null;
			this.length--;
		}  else {
			int counter = 0;
			dNode currentNode = this.head;
			while(counter!=index-1) {
				currentNode = currentNode.next;
				counter ++;
			}
			dNode prevRmNode = currentNode;
			dNode nextRmNode = currentNode.next.next;
			if (nextRmNode==null) {
				prevRmNode.next = null;
			} else {
				prevRmNode.next = nextRmNode;
				nextRmNode.prev = prevRmNode;
			}
			this.length--;
		}
	}
	
	//printList
	public int[] printList() {
		int[] array = new int[this.length];
		int counter = 0;
	    dNode currentNode = this.head;
		while(currentNode!=null) {
			array[counter] = currentNode.value;
			currentNode = currentNode.next;
			counter ++;
		}
		return array;
	}
	
	 

	public static void main(String[] args) {
		DoubleLinkedList case1 = new DoubleLinkedList(10);
		case1.append(11);
		case1.append(12);
		//case1.insert(3, 7);
		case1.remove(3);
		System.out.println(Arrays.toString(case1.printList()));
		//System.out.println(Arrays.toString(case1.reverse()));
	}

}
