package datastructures.queues.queues_using_stacks;

/* Implementing queue using two stacks */

import java.util.Stack;

public class MyQueue {
	Stack<Integer> mainStack;
	Stack<Integer> subStack;
	
	public MyQueue() {
		this.mainStack = new Stack<>();
		this.subStack = new Stack<>();
	}
	
	public void push(int value) {
		this.mainStack.push(value);
	}
	
	public Integer peek() {
		if(this.mainStack.size()==0) {
			return null;
		} else {
			while(!this.mainStack.isEmpty()) {
				this.subStack.push(this.mainStack.pop());
			}
			Integer peekedItem = this.subStack.peek();
			while(!this.subStack.isEmpty()) {
				this.mainStack.push(this.subStack.pop());
			}
			return peekedItem;
		}
	}
	
	public Integer pop() {
		if(this.mainStack.size()==0) {
			return null;
		} else {
			while(!this.mainStack.isEmpty()) {
				this.subStack.push(this.mainStack.pop());
			}
			Integer poppedItem = this.subStack.pop();
			while(!this.subStack.isEmpty()) {
				this.mainStack.push(this.subStack.pop());
			}
			return poppedItem;
		}
	}
	
	public Boolean empty() {
		return this.mainStack.size()==0;
	}

	public static void main(String[] args) {
		MyQueue myQueue = new MyQueue();
		myQueue.push(1); // queue is: [1]
		myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
		System.out.println(myQueue.peek());
		System.out.println(myQueue.pop());
		System.out.println(myQueue.empty());
		 
	}

}
