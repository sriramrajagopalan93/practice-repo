package sorting;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class InsertionSortImpl {

	public static void main(String[] args) {
		Integer array[] = { 3, 3, 2, 1, 5, 4, 4, 6 };
		InsertionSortImpl insertionSortImpl = new InsertionSortImpl();
		array = insertionSortImpl.insertionSort(array);

	}

	// useful for nearly sorted array
	private Integer[] insertionSort(Integer[] array) {
		List<Integer> list = new LinkedList<>(Arrays.asList(array)); // Using linked list so shifting will be efficient
																		// than AL
		for (int i = 1; i < list.size(); i++) { // Fixed: i start at i = 1
			if (list.get(i) < list.get(0)) { // Fixed: duplicate values sort by changing to "<="
												// MY UPDATE: FOR THE sorting TO BE 'STABLE' ALGORITHM <= must not be
												// put.
												// Only < IS CORRECT
												// Checking if current number is suppose to be first
				list.add(0, list.get(i)); // Moving the number to 1st position (add method right shifts the consequent
											// elements
											// automatically)
				list.remove(i + 1); // as we've added it to 1st position, remove this one now.
			} else {
				// only sort number smaller than number on the left of it.
				// This is the part of insertion sort that makes it fast
				// if the array is almost sorted.
				if (list.get(i) < list.get(i - 1)) { // go into below for loop only if i element < i-1 element, the
														// program will work without this line, but this line will
														// avoid unnecessary iterations in below for loop. As it is
														// known that the elements before i will be sorted (in insertion
														// sort).
					// find where the number should go
					for (int j = 1; j < i; j++) {
						if (list.get(i) >= list.get(j - 1) && list.get(i) < list.get(j)) { // place in between. >= is
																							// used to handle sorting of
																							// duplicate elements and
																							// also maintain insertion
																							// order (stable algo)
							// move number to the correct spot
							list.add(j, list.get(i));
							list.remove(i + 1);
						}
					}
				}
			}
		}
		System.out.println(list.toString());
		return list.toArray(new Integer[0]);
	}

}
