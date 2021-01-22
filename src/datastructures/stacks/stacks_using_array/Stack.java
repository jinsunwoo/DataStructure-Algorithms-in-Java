package datastructures.stacks.stacks_using_array;

/* Implementing stack using array */

import java.util.ArrayList;

public class Stack {
	ArrayList<String> array;
	
	public Stack() {
		this.array = new ArrayList<String>();
	}
	
	public String peek() {
		if(this.array.size() == 0) {
			return null;
		} else {
			return array.get(this.array.size()-1);
		}
	}
	
	public void push(String value) {
		this.array.add(value);
	}
	
	public String pop() {
		if(this.array.size() == 0) {
			return null;
		} else {
			String poppedItem = this.array.get(this.array.size()-1);
			this.array.remove(this.array.size()-1);
			return poppedItem;
		}
	}
	
	public Boolean isEmpty() {
		return this.array.size() == 0;
	}

	public static void main(String[] args) {
		Stack case1 = new Stack();
		case1.push("Discord");
		case1.push("Avenue");
		System.out.println(case1.peek());
		System.out.println(case1.pop());
		System.out.println(case1.pop());
		
		
		

	}

}