package datastructures.hashtables;

import java.util.HashMap;
import java.util.HashSet;

public class ReoccuringElement {
	
	//Given an array = [2,5,1,2,3,5,1,2,4]: It should return 2
	//Given an array = [2,1,1,2,3,5,1,2,4]: It should return 1
	//Given an array = [2,3,4,5]: It should return null
	//Given an array = [2,5,5,2,3,5,1,2,4]: return 5 because the pairs are before 2,2
	
	// This method is O(n^2) using simple double for loops 
	public int check1(int[] array) {
		int indexCheck = 10000;
		// Starting from the first element, checks if there is a match in the array with the checker 
		for(int checker=0;checker<array.length-1;checker++) {
			for(int j=checker+1;j<array.length;j++) {
				// Only changes indexChecker if j is smaller than the current indexCheck's value
				if(array[checker]==array[j] && j<indexCheck) {
					indexCheck = j;
					break;
				}
			}
		}
		// If there was no any matched element 
		if(indexCheck == 10000) {
			return -1;		
		} else {
			int reoccured = array[indexCheck];
			return reoccured;
		}
	}
	
	// Using the property of hashset: all elements should be unique 
	public Integer check2(int[] array) {
		HashSet<Integer> hashset = new HashSet<>();
		for(int i=0;i<array.length;i++) {
			if(hashset.contains(array[i])) {
				return array[i];
			} else {
				hashset.add(array[i]);
			}
		}
		// When all the elements in the array are unique
		return null;
	}
	
	// Using hash map in java which acts like hash table 
	public Integer check3(int[] array) {
		HashMap<Integer,Integer> hashmap = new HashMap<>();
		for(int i=0;i<array.length;i++) {
			if(hashmap.containsKey(array[i])) {
				return array[i];
			} else {
				hashmap.put(array[i], 1);
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		ReoccuringElement case1 = new ReoccuringElement();
		int[] array = {2,3,3,3,4,5};
		System.out.println(case1.check3(array));
	}
}
