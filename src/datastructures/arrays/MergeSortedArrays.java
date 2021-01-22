package datastructures.arrays;
/* 
 * Given two sorted arrays, make a function that merge two arrays sorted. 
 * Two arrays {1,3,5,7,8,9} and {1,4,7} should return:
 * {1,1,3,4,5,7,7,8,9}
 */

public class MergeSortedArrays {
	private int[] merge(int[] arr1, int[] arr2) {
	    int totalLen = arr1.length + arr2.length;
	    int[] mergedArray = new int[totalLen];
	    int i=0, j=0, k=0;
	    while (i<arr1.length && j<arr2.length) {
	    	if(arr1[i]<arr2[j]) {
	    		mergedArray[k] = arr1[i];
	    		i++; k++;
	    	} else {
	    		mergedArray[k] = arr2[j];
	    		j++; k++;
	    	}
	    }
	    if(i==arr1.length) {
	    	 while(j<arr2.length) {
	    		 mergedArray[k] = arr2[j];
	    		 j++; k++;
	    	 }
	    } else {
	    	while(i<arr1.length) {
	    		 mergedArray[k] = arr1[i];
	    		 i++; k++;
	    	 }
	    }
	    
		return mergedArray;
	}
	
	public static void main(String[] args) {
		int[] arr1 = {1,3,5,7};
		int[] arr2 = {2,3,4,9};
		MergeSortedArrays case1 = new MergeSortedArrays();
		int[] mergedArray = case1.merge(arr1, arr2);
		for (int i=0;i<mergedArray.length;i++) {
			System.out.print(mergedArray[i]);
			System.out.print(" ");	
		}
	}
}


