package algorithms.sorting;

import java.util.Arrays;

/* Time complexity : O(n^2) 
 * Space complexity : O(1) */

public class SelectionSort {

	public int[] selectionSort(int[] array) {
		int length = array.length;
		for(int i=0;i<length-1;i++) {
			int min = i;
			int temp = array[i];
			for(int j=i+1;j<length;j++) {
				if(array[j] < temp) {
					min = j;
				}
			}
			array[i] = array[min];
			array[min] = temp;
			
		}
		return array;
	}
	public static void main(String[] args) {
		int[] array = new int[] {3, 2, 1, 6, 8, 5, 3};
		SelectionSort case1 = new SelectionSort();
		System.out.println(Arrays.toString(case1.selectionSort(array)));

	}

}
