import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PairOfArrayElementsIsASum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int array[] = { 1, 2, 4, 4 }; // true
		int array[] = { 1, 2, 6, 9 }; // true
		//int array[] = { 1, 2, 4, 9 }; // false
		int sum = 8;
		PairOfArrayElementsIsASum pairOfArrayElementsIsASum = new PairOfArrayElementsIsASum();
		pairOfArrayElementsIsASum.findIfArrayPairIsEqualToSum1(array, sum);
//		pairOfArrayElementsIsASum.findIfArrayPairIsEqualToSum2(array, sum);
	}

	// when array is sorted
	private boolean findIfArrayPairIsEqualToSum1(int[] array, int sum) {
		int low = 0;
		int high = array.length - 1;
		while (low < high) {
			int add = array[low] + array[high];
			if (add == sum) {
				System.out.println("True");
				return true;
			} else if (add < sum) {
				System.out.println("low++");
				low++;
			} else {
				System.out.println("high--");
				high--;
			}
		}
		System.out.println("False");
		return false;
	}

	// when array is either sorted/ unsorted
	private boolean findIfArrayPairIsEqualToSum2(int[] array, int sum) {
		Set<Integer> complimentSet = new HashSet<>();
		for (int i = 0; i < array.length; i++) {
			if (complimentSet.contains(array[i])) {
				System.out.println("True");
				return true;
			}
			complimentSet.add(sum - array[i]);
		}
		System.out.println("False");
		return false;
	}

}
