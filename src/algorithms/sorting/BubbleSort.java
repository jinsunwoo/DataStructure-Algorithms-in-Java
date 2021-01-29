package algorithms.sorting;

import java.util.Arrays;

/* Time complexity : O(n^2) 
 * Space complexity : O(1) */

public class BubbleSort {
	
	public int[] bubbleSort(int[] array) {
		int length = array.length;
		for (int i=length-1;i>0;i--) {
			for (int j=0;j<i;j++) {
				if(array[j]>array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		return array;
	}

	public static void main(String[] args) {
		int[] array = new int[] {7,5,4,1,2,3};
		BubbleSort case1 = new BubbleSort();
		System.out.println(Arrays.toString(case1.bubbleSort(array)));
	}

}
