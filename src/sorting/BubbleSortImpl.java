package sorting;

import java.util.Arrays;

public class BubbleSortImpl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int array[] = { 3, 2, 1, 5, 6, 4 };
		BubbleSortImpl bubbleSortImpl = new BubbleSortImpl();
		bubbleSortImpl.bubbleSort(array);

	}

	//O(n^2) - stable
	private void bubbleSort(int[] array) {
		//compare current element (j) and next element -- do this from i=0 to length times
		// i is just for no of iterations needed. inside the loop, j only is used
		for (int i = 0; i < array.length; i++) {
			// length-1 must be given below to avoid out of bounds when j reaches final position of array 
			// and we try to access j+1
			for (int j = 0; j < array.length-1; j++) { 
				if(array[j]>array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(array));
	}

}
