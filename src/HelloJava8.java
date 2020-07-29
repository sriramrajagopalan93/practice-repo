import java.util.Arrays;
import java.util.List;

public class HelloJava8 {
	public static void main(String args[]) {
		List<String> sampleList = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");
		long count = sampleList.stream().filter(string -> string.isEmpty()).count();
		System.out.println("Empty Strings: " + count);
	}
	
}
