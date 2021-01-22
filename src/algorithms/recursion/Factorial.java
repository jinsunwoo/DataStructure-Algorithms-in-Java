package algorithms.recursion;

/* Give out the factorial of given number in both recursive and iterative ways */

public class Factorial {
	public int factorialRecursive(int number) {
		// base case
		if(number == 0) {
			return 1;
		} else {
			return number * factorialRecursive(number-1);
		}
	}
	
	public int factorialIterative(int number) {
		if (number == 0) {
			return 1;
		}
		int counter = 1;
		int result = 1;
		while(counter != number+1) {
			result = result * counter;
			counter ++;
		}
		return result;
	}

	public static void main(String[] args) {
		Factorial case1 = new Factorial();
		System.out.println(case1.factorialRecursive(5));
		System.out.println(case1.factorialIterative(5));
		
		

	}

}
