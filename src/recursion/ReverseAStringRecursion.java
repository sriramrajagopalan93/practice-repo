package recursion;

public class ReverseAStringRecursion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String string = "Example String";
		System.out.println(string);
		ReverseAStringRecursion reverseAStringRecursion = new ReverseAStringRecursion();
		char charArray[] = string.toCharArray();
		int low = 0;
		int high = string.length() - 1;
		charArray = reverseAStringRecursion.reverseString(charArray,low,high);
		System.out.println(String.valueOf(charArray));
	}

	private char[] reverseString(char[] charArray, int low, int high) {

		if(low>=high) {
			return charArray;
		}
		char temp = charArray[low];
		charArray[low] = charArray[high];
		charArray[high] = temp;
		
		return reverseString(charArray, low+1,high-1);
	}

}
