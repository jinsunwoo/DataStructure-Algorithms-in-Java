package datastructures.queues.queues_using_linkedlist;

/* Implementing queue using linked list */

class Node {
	String value;
	Node next;
	
	public Node(String value) {
		this.value = value;
		this.next = null;
	}
}

public class Queue {
	Node first;
	Node last;
	int length;
	
	public Queue() {
		this.first = null;
		this.last = null;
		this.length = 0;
	}
	
	public void enqueue(String value) {
		Node newNode = new Node(value);
		if(this.length==0) {
			this.first = newNode;
			this.last = newNode;
		} else {
			Node currentLast = this.last;
			this.last = newNode;
			currentLast.next = newNode;
		}
		this.length++;
	}
	
	public String dequeue() {
		if (this.length == 0) {
			return null;
		} else {
			Node currentFirst = this.first;
			this.first = currentFirst.next;
			if(this.length==1) {
				this.last = null;
			}
			this.length--;
			return currentFirst.value;
		}
	}
	
	public String peek() {
		if(this.length==0) {
			return null;
		} else {
			return this.first.value;
		}
	}
	
	public Boolean isEmpty() {
		return this.length == 0;
	}

	public static void main(String[] args) {
		Queue case1 = new Queue();
		case1.enqueue("Apple");
		case1.enqueue("Banana");
		System.out.println(case1.length);
		System.out.println(case1.dequeue());
		System.out.println(case1.peek());
	}

}
