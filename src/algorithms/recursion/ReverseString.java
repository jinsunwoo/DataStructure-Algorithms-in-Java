package algorithms.recursion;

public class ReverseString {
	// Reverse String, for example, a bcde -> edcb a
	public String ReverseStringRecursive(String words) {
		// base case
		if(words=="") {
			return "";
		} else if(words.length()==1) {
			return words;
		} else {
			return ReverseStringRecursive(words.substring(1)) + words.charAt(0);
		}
	}
	
	public String ReverseStringIterative(String words) {
		String reversedWords = "";
		for(int i=words.length()-1;i>=0;i--) {
			reversedWords += words.charAt(i);
		}
		return reversedWords;
	}
	
	public static void main(String[] args) {
		ReverseString case1 = new ReverseString();
		System.out.println(case1.ReverseStringIterative("a bc"));
		System.out.println(case1.ReverseStringRecursive("a bc"));
		
	}
}
