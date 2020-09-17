package trial_programs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Find all duplicates in an array of n elements where 1< a[i]<=n (numbers are b/w 1 to n)
 * The logic is -> for a particular number in array go to its position and mark negative
 * next time when same number comes and the position is negative move that number N in result List.
 */
public class FindAllDuplicatesInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int array[] = {3,4,2,2,2,3,5};
		List<Integer> resultList = new ArrayList<>();
		for(int i=0 ; i<array.length ; i++) {
			int n = Math.abs(array[i]); //positive value
			
			if(array[n-1]>0) {
				array[n-1] = array[n-1]*-1;
			}
			else {
				array[n-1] = array[n-1]*-1; // this line is needed when there are 3 duplicates for a number (instead of 2)
				resultList.add(n);
			}
			System.out.println(Arrays.toString(array));
		}
		System.out.println("Duplicates: "+resultList.toString());
		
		
	}

}
