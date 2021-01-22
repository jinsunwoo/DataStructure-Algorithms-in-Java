package datastructures.arrays;

import java.util.Arrays;

/* Implementation of Dynamic Array and its primary methods with Java */

public class DynamicArray {
	// The number of elements that the array can hold
	private int arraySize;
	
	// The array which will be used for this implementation
	private String[] array;
	
	// The number of elements in the array
	private int elementSize;
	
	// Initialize the array with capacity of 1 element
	public DynamicArray() {
		arraySize = 1;
		array = new String[arraySize];
		elementSize = 0;
	}
	
	// This method adds a new element at the end of the array
	public void push(String newElement) {
		// If the array is full, double its size
		if(elementSize==arraySize) {
			// Create a temp array which is double the size of the original one
			String[] temp = new String[arraySize*2];
			// Copy elements from the original one to the temp array
			for(int i=0;i<this.array.length;i++) {
				temp[i]=this.array[i];
			}
			// Set the temp array as the original array, and increase the size of array to double
			this.array = temp;
			arraySize*=2;
		}
		// Put a new element at the end of the array and increase element size by one
		this.array[elementSize] = newElement;
		elementSize++;
	}
	
	// This method replaces given element at given index in the array 
	public void replace(int index, String newElement) {
		if(index>-1 && index<elementSize) {
			this.array[index] = newElement;
		} else {
			System.err.println("Index out of bound");
		}
	}
	
	// This method deletes the element at the given index from the array
	public void delete(int index) {
		if(index>-1 && index<elementSize) {
			if (index==elementSize-1) {
				this.pop();
			} else {
				// Shifts each element to the left starting from the given index
				for(int i=index;i<elementSize;i++) {
					this.array[i] = this.array[i+1]; 
				}
				// Ignores the last element and decreases element size by one 
				this.array[elementSize-1]=null;
				elementSize--;
			}
		} else {
			System.err.println("Index out of bound");
		}
	}	
		
	// This method deletes the last element from the array and returns it
	public String pop() {
		String popedItem = this.array[elementSize-1];
		this.array[elementSize-1] = null;
		elementSize--;
		return popedItem;
	}
	
	// This method returns the current array
	public String[] getArray() {
		String[] array = new String[elementSize];
		for(int i=0;i<elementSize;i++) {
			array[i] = this.array[i];
		}
		
		return array;
	}
	
	// This method returns the number of elements in the array
	public int length() {
		return this.elementSize;
	}
	
	
	public static void main(String[] args) {
		
		DynamicArray case1 = new DynamicArray();
		System.out.println(case1.arraySize);
		System.out.println(case1.elementSize);
		case1.push("Hi");
		System.out.println(case1.arraySize);
		System.out.println(case1.elementSize);
		case1.push("Hi2");
		System.out.println(case1.arraySize);
		System.out.println(case1.elementSize);
		case1.push("Hi3");
		System.out.println(case1.arraySize);
		System.out.println(case1.elementSize);
		case1.pop();
		System.out.println(case1.arraySize);
		System.out.println(case1.elementSize);
		System.out.println(Arrays.toString(case1.getArray()));
		case1.delete(0);
		System.out.println(Arrays.toString(case1.getArray()));
		case1.delete(-1);
		
		
		 
	}
}