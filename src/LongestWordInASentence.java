
public class LongestWordInASentence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sentence = "My name i:s1 ''' 1234: Sriram";
		String senArray[] = sentence.split(" ");
		String longestString = "";
		for(int i=0;i< senArray.length;i++) {
			senArray[i] = senArray[i].replaceAll("[^a-zA-Z0-9]", ""); // ^ means NOT
			System.out.println(senArray[i]);
			if(senArray[i].length()> longestString.length()) {
				longestString = senArray[i];
			}
		}
		System.out.println("longestString: "+ longestString);
	}

}
