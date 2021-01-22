package algorithms.recursion;

import java.util.ArrayList;

/* 
 * Fibonacci concept is implemented in both iterative and recursive ways. 
 * Given an index number, returns the value of the given index at fibonacci sequence,
 * where the sequence is: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144 ... */


public class Fibonacci {

	public int fibonacciIterative1(int number) {
		ArrayList<Integer> list = new ArrayList<>();
		list.add(0);
		list.add(1);
		for(int i=2;i<number+1;i++) {
			int newElement = list.get(i-1) + list.get(i-2);
			list.add(i, newElement);
		}
		return list.get(number);
	}
	
	public int fibonacciIterative2(int number) {
		int first = 0;
		int second = 1;
		int counter = 1;
		while(counter!= number) {
			int oldFirst = first;
			first = second;
			second = second + oldFirst;
			counter++;
		}
		return second;
	}
	
	public int fibonacciRecursive(int number) {
		if(number == 0) {
			return 0;
		} else if (number == 1) {
			return 1;
		}
		return fibonacciRecursive(number-1) + fibonacciRecursive(number-2);
	}
	
	public static void main(String[] args) {
		Fibonacci case1 = new Fibonacci();
		System.out.println(case1.fibonacciIterative1(8));
		System.out.println(case1.fibonacciIterative2(8));
		System.out.println(case1.fibonacciRecursive(8));
	}
}
