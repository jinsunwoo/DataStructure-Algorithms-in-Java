package algorithms.dynamic_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Fibonacci {
	
	// 0 1 1 2 3 5 8 13 21 34 55 ...
	static int operationNumberOriginal = 0;
	static int operationNumberDynamic = 0;
	
	
	// Time Complexity of O(2^n) 
	public int fibonacciOriginal(int n) {
		operationNumberOriginal ++;
		if(n<2) {
			return n;
		} else {
			return fibonacciOriginal(n-1) + fibonacciOriginal(n-2);
		}
	}
	
	// Using Dynamic approach of top down memoization method
	// Time Complexity of O(n) since fibonacci function is called only once for each number 0, 1, 2, 3, 4...
	// But Space complexity increased here since cache (hash map data structure) is used 
	HashMap<Integer, Integer> cache = new HashMap<>();
	
	public int fibonacciDynamic(int n) {
		if(cache.containsKey(n)) {
			return cache.get(n);
		} else {
			operationNumberDynamic ++;
			if(n < 2) {
				return n;
			} else {
				Integer res = fibonacciDynamic(n-1) + fibonacciDynamic(n-2);
				cache.put(n, res);
				return cache.get(n);
			}
		}
		 
	}
	
	// Using Dynamic approach of bottom up method 
	public int fibonacciDynamic2(int n) {
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(0, 1));
		if(n > 1) {
			for(int i=2;i<=n;i++) {
				list.add(fibonacciDynamic2(i-1)+fibonacciDynamic2(i-2));
			} 
		}
		return list.get(n);
		
	}
	
	public static void main(String[] args) {
		Fibonacci case1 = new Fibonacci();
		System.out.println("Dynamic case with input 10: " + case1.fibonacciDynamic(10));
		System.out.println("Operation number for Dynamic case: " + operationNumberDynamic);
		System.out.println("Original case with input 10: " + case1.fibonacciOriginal(10));
		System.out.println("Operation number for Original case: "+operationNumberOriginal);
		System.out.println("Dynamic2 case with input 10: " + case1.fibonacciDynamic2(10));
	}
	

}
