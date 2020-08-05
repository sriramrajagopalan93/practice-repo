package array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyArrayDSImplementation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arrayInteger = {1,2,3,4,5};
		int[] array = {1,2,3,4,5,6,7};
		MyArrayDSImplementation myArrayDSImplementation = new MyArrayDSImplementation();
		arrayInteger = myArrayDSImplementation.pushInteger(arrayInteger, 7);
		array = myArrayDSImplementation.pushInt(array, 8);
		for(int i=0;i<arrayInteger.length;i++) {
			System.out.print(arrayInteger[i]+" ");
		}
		System.out.println();
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+" ");
		}
		array = myArrayDSImplementation.insertInt(array, 7, 10);
		System.out.println("\nInserted");
		for(int i=0;i<array.length;i++) {
			System.out.print(array[i]+" ");
		}
	}

	private int[] insertInt(int[] array, int index, int element) {
		int newArray[] = new int[array.length+1];
		// if index is after the last index - same logic as push 
		if(index == array.length) {
			for(int i=0;i<array.length;i++) {
				newArray[i] = array[i];
			}
			newArray[array.length]=element;
		}
		else {
			for(int i=0;i<array.length;i++) {
				if(i< index) {
					newArray[i] = array[i];
				}
				else if(i == index) {
					newArray[i] = element;
				}
				else {
					newArray[i] = array[i-1];
				}
			}
			newArray[array.length] = array[array.length-1];
		}
		return newArray;
	}

	// push and pop imialr logic - add/remove from last element
	private int[] pushInt(int[] array, int element) {
		int newArray[] = new int[array.length+1];
		for(int i=0;i<array.length;i++) {
			newArray[i] = array[i];
		}
		newArray[array.length]=element;
		return newArray;
	}

	private Integer[] pushInteger(Integer[] array, int element) {
		List<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(array));
		arrayList.add(Integer.valueOf(element));
		array = arrayList.toArray(array);
		return array;
	}

}
