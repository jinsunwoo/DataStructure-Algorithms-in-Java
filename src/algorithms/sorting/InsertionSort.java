package algorithms.sorting;

import java.util.ArrayList;

/*
 * Time complexity : O (n^2)
 * Space complexity : O (1)
 */

import java.util.Arrays;

public class InsertionSort {
	public ArrayList<Integer> insertionSort(ArrayList<Integer> array) {
		for(int i=0;i<array.size();i++) {
			if(array.get(i)<=array.get(0)) {
				array.add(0,array.remove(i));
			} else {
				if(array.get(i)<array.get(i-1)) {
					for(int j=1;j<i;j++) {
						if(array.get(j)>array.get(i)) {
							array.add(j,array.remove(i));
							break;
						}
					}
				}
			}
		}
		return array;
	}

   
    public static void main(String[] args) {
    	ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 5, 63, 87, 283, 4, 0));
    	InsertionSort case1 = new InsertionSort();
    	System.out.println(case1.insertionSort(numbers));
    }
}