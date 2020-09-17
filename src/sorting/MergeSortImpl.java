package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSortImpl {

	public static void main(String[] args) {
		MergeSortImpl mergeSortImpl = new MergeSortImpl();
		List<Integer> arrayList = new ArrayList<>(Arrays.asList(99, 44, 6, 2, 1, 5, 63, 87, 283, 4, 0));
//		List<Integer> arrayList = new ArrayList<>(Arrays.asList(3, 3, 2, 1, 5, 4, 4, 6));
		arrayList = mergeSortImpl.mergeSort(arrayList);
		System.out.println("Merge Sorted Array: "+arrayList.toString());
	}

	/** mergeSort function */
	public List<Integer> mergeSort(List<Integer> arrayList) {
		if (arrayList.size() == 1) {
			return arrayList;
		}
		// Split Array in into right and left
		List<Integer> left = arrayList.subList(0, arrayList.size() / 2);
		System.out.println("Splitting left: " + left);
		List<Integer> right = arrayList.subList(arrayList.size() / 2, arrayList.size());
		System.out.println("Splitting Right: " + right);

		return merge(mergeSort(left), mergeSort(right));
	}

	/** merge function */
	public List<Integer> merge(List<Integer> left, List<Integer> right) {
		ArrayList<Integer> result = new ArrayList<>();
		int leftIndex = 0;
		int rightIndex = 0;

		//Keep merging until we done with one of the sides
		while (leftIndex < left.size() && rightIndex < right.size()) {
			if (left.get(leftIndex) < right.get(rightIndex)) { //"<" -> makes the merge sort "stable" - insertion order maintain
				result.add(left.get(leftIndex));
				leftIndex++;
			} else {
				result.add(right.get(rightIndex));
				rightIndex++;
			}
		}
		
		
		List<Integer> leftRemaining = left.subList(leftIndex, left.size());
		List<Integer> rightRemaining = right.subList(rightIndex, right.size());
		//Merging all "leftovers" elements as it is because we know they are sorted
		// either leftRemaining or rightRemaining will be empty as 'while' would have ended only then
		result.addAll(leftRemaining);
		result.addAll(rightRemaining);

		System.out.println("Merged: " + result);
		return result;
	}

}
