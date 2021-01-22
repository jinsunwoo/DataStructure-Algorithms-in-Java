package datastructures.stacks.stacks_using_linkedlist;

/* Implementing stack using linked list */

class Node {
	String value;
	Node next;
	
	public Node(String value) {
		this.value = value;
		this.next = null;
	}
}

public class Stack {
	Node top;
	Node bottom;
	int length;
	
	public Stack() {
		this.top = null;
		this.bottom = null;
		this.length = 0;
	}
	
	public String peek() {
		if (this.length == 0) {
			return null;
		}
		return this.top.value;
	}
	
	public String pop() {
		if (this.length ==0) {
			return null;
		} else {
			Node nextTop = this.top.next;
			String poppedvalue = this.top.value;
			this.top = nextTop;
			if (this.length ==1) {
				this.bottom = null;
			}
			this.length--;
			return poppedvalue;
		}
	}
	
	public void push(String value) {
		Node newNode = new Node(value);
		if(this.length==0) {
			this.top = newNode;
			this.bottom = newNode;
		} else {
			Node currentTop = this.top;
			this.top = newNode;
			this.top.next = currentTop;
		}
		this.length++;
	}

	public static void main(String[] args) {
		Stack case1 = new Stack();
		case1.push("Naver");
		case1.push("Amazon");
		case1.push("Microsoft");
		case1.push("Google");
		System.out.println(case1.peek());
		System.out.println(case1.length);
		System.out.println(case1.pop());
		System.out.println(case1.length);
		System.out.println(case1.top.value);
		System.out.println(case1.pop());
		System.out.println(case1.length);
		System.out.println(case1.pop());
		System.out.println(case1.pop());
		System.out.println(case1.length);
		System.out.println(case1.pop());	
	}
}