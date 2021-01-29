package algorithms.sorting;

import java.util.ArrayList;

/*
 * Time complexity : o (n logn) -> Divide & Conquer technique
 * Space complexity : o (n) 
 * */
import java.util.Arrays;
import java.util.List;

public class MergeSort {

    public List<Integer> mergeSort(List<Integer> array) {
        if (array.size() == 1) {
            return array;
        }
        int length = array.size();
        int middle = length/2;
        List<Integer> left = array.subList(0, middle);
        List<Integer> right = array.subList(middle, length);

        return  merge(mergeSort(left), mergeSort(right));
    }

    public List<Integer> merge(List<Integer> left, List<Integer> right) {
        ArrayList<Integer> result = new ArrayList<>();
        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex) < right.get(rightIndex)) {
                result.add(left.get(leftIndex));
                leftIndex++;
            } else {
                result.add(right.get(rightIndex));
                rightIndex++;
            }
        }
        
        if(leftIndex == left.size()) {
        	List<Integer> rightRemaining = right.subList(rightIndex, right.size());
        	result.addAll(rightRemaining);
        } else {
        	List<Integer> leftRemaining = left.subList(leftIndex, left.size());
        	result.addAll(leftRemaining);
        }
        return result;
    }

    public static void main(String[] args) {
        MergeSort sort = new MergeSort();
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0));
        System.out.println(sort.mergeSort(numbers));
    }
}
