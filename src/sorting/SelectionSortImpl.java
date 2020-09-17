package sorting;

import java.util.Arrays;

public class SelectionSortImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = { 3, 2, 1, 5, 4, 6 };
		SelectionSortImpl selectionSortImpl = new SelectionSortImpl();
		selectionSortImpl.selectionSort(array);
	}

	//consider first element (i) as minimum and move through the array and place the new minimum number at ith position.
	//O(n^2) - stable algorithm
	private void selectionSort(int[] array) {
		
		for(int i=0;i< array.length;i++) {
			int min = i;
			int temp = array[i];
			for(int j=i+1;j< array.length;j++) {
				if(array[j] < array[min]) { //if we mention <= here it will become 'unstable' algorithm
					min = j; // new min
				}
			}
			array[i] = array[min];
			array[min] = temp;
			//now the element of i will be the minimum number
			//now i can be incremented to find next minimum number
		}
		
		System.out.println(Arrays.toString(array));
	}

}
