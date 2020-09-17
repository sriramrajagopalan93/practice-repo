package trial_programs;

public class ReverseAString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string = "Example String";
		System.out.println(string);
		if (string.length() > 1) {
			reverseString(string);
			reverseString2(string);
		}
	}

	/*
	 * more iterations when compared to method 1 hence time complexity is more but
	 * space complexity (memory space) is less since lesser variables are used.
	 */
	private static void reverseString2(String string) {
		char charArray[] = new char[string.length()];
		for (int i = string.length() - 1; i >= 0; i--) {
			charArray[string.length() - 1 - i] = string.charAt(i);
		}
		string = String.valueOf(charArray);
		System.out.println(string);
	}

	/*
	 * less iterations when compared to method 2 hence time complexity is less but
	 * space complexity (memory space) is more since extra variables are used.
	 */
	private static void reverseString(String string) {
		char charArray[] = string.toCharArray();
		int low = 0;
		int high = string.length() - 1;

		while (low < high) {
			char temp = charArray[low];
			charArray[low] = charArray[high];
			charArray[high] = temp;
			low++;
			high--;
		}
		string = String.valueOf(charArray);
		System.out.println(string);
	}

}
