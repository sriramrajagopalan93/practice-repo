package trial_programs;


public class MergeSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array1[] = { 4, 5, 6, 7 };
		int array2[] = { 1, 2, 3, 9 };
//		mergeSortedArrays1(array1,array2);
		mergeSortedArrays2(array1, array2);
	}

	// O(n) complexity
	/*THE LAST STEP (ITERATION) OF MERGE SORT IS THE SOLUTION OF THIS QUESTION*/
	private static void mergeSortedArrays2(int[] array1, int[] array2) {
		// TODO Auto-generated method stub
		int array1Position = 0; // increase count once the array1 position is moved into resultArray
		int array2Position = 0; // increase count once the array2 position is moved into resultArray
		int resultArray[] = new int[array1.length + array2.length];
		int newArrayIndex = 0;
		
		/* loop until all elements in both arrays are moved into resultArray
		 * in other words loop till any one of array is not covered fully
		 */
		while (array1Position < array1.length || array2Position < array2.length) {
			//if array1 doesn't reach its end position AND (array2 reaches it's end OR arr1 element< arr2 element)
			if (array1Position != array1.length
					&& (array2Position == array2.length || array1[array1Position] <= array2[array2Position])) {
				resultArray[newArrayIndex] = array1[array1Position];
				newArrayIndex++;
				array1Position++;
			} else {
				resultArray[newArrayIndex] = array2[array2Position];
				newArrayIndex++;
				array2Position++;
			}
		}
		for (int i = 0; i < resultArray.length; i++) {
			System.out.print(resultArray[i] + " ");
		}

	}

	// O(n^2) complexity
	private static void mergeSortedArrays1(int[] array1, int[] array2) {
		// TODO Auto-generated method stub
		int resultArray[] = new int[array1.length + array2.length];
		int iLimit = 0, jLimit = 0;
		int resultIndex = 0;
		/*
		 * iLimit and jLimit used to track how many elements in each array have been covered (moved to result array)
		 * if arr1 element <= arr2 element loop is broken and moved to next iteration of i
		 * else if arr2 > arr1, jLimit is increased and loop is continued
		 */
		for (int i = iLimit; i < array1.length; i++) {
			for (int j = jLimit; j < array2.length; j++) {
				if (array1[i] <= array2[j]) {
					resultArray[resultIndex] = array1[i];
					resultIndex++;
					iLimit++;
					break;
				} else {
					resultArray[resultIndex] = array2[j];
					resultIndex++;
					jLimit++;
				}
			}
		}
		// move remaining elements (if present) of arr1  to resultArray
		for (int i = iLimit; i < array1.length; i++) {
			resultArray[resultIndex] = array1[i];
			resultIndex++;
		}
		// move remaining elements (if present) of arr2  to resultArray
		for (int i = jLimit; i < array2.length; i++) {
			resultArray[resultIndex] = array2[i];
			resultIndex++;
		}
		for (int i = 0; i < resultArray.length; i++) {
			System.out.print(resultArray[i] + " ");
		}
	}

}
