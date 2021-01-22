package datastructures.arrays;

/* Create a function that reverses a String.
 * 'I am Jin' should be:
 * 'niJ ma I'
 */
public class ReverseString {
	// Method 1: Using String
	private String reverse1(String word) {
		String temp = "";
		for(int i=word.length()-1;i>=0;i--) {
			temp = temp + word.charAt(i);
		}
		return temp;
	}
	// Method 2: Using StringBuilder
    private String reverse2(String word) {   	 
        StringBuilder temp = new StringBuilder();
        for (int i = word.length() - 1; i >= 0; i--) {
            temp.append(word.charAt(i));
        }
        return temp.toString();
    }

    public static void main(String[] args) {
        String givenWord = "Datastructure : Array";
        ReverseString reverseString = new ReverseString();
        System.out.println(reverseString.reverse1(givenWord));
        System.out.println(reverseString.reverse2(givenWord));
    }
}