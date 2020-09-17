package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FibonacciRecursion {

	static int n1 = 0, n2 = 1, n3 = 0;
	public static void main(String[] args) {
		FibonacciRecursion fibonacciRecursion = new FibonacciRecursion();
		int value = 5;
		fibonacciRecursion.iterativeFibonacci1(value);
		fibonacciRecursion.iterativeFibonacci2(value);
		System.out.print("\nRecursive Fibonacci of index "+value+": ");
		System.out.println(fibonacciRecursion.recursiveFibonacci(value));
		
		System.out.print("\nRecursive Fibonacci SERIES 1 of "+value+": ");
		System.out.print(n1 +" "+n2);
		fibonacciRecursion.recursiveFibonacci2(value-2);
		
		System.out.print("\nRecursive Fibonacci SERIES 2 of "+value+": ");
		List<Integer> fiboArrayList = new ArrayList<>();
		fiboArrayList.add(0);
		fiboArrayList.add(1);
		fibonacciRecursion.recursiveFibonacci3(value, fiboArrayList);
		
	}

	private void recursiveFibonacci3(int value, List<Integer> fiboArrayList) {
		int fiboArraySize = fiboArrayList.size();
		if(fiboArraySize < value) {
			fiboArrayList.add(fiboArrayList.get(fiboArraySize-1)+fiboArrayList.get(fiboArraySize-2));
			recursiveFibonacci3(value,fiboArrayList);
		}
		else { //after fiboArraySize reaches the size of value. i.e. No of list elements = value
			System.out.println(fiboArrayList.toString());
		}
	}
	
	//int n1 = 0, n2 = 1, n3 = 0;
	private void recursiveFibonacci2(int value) {
		if (value > 0) {
	         n3 = n1 + n2;
	         n1 = n2;
	         n2 = n3;
	         System.out.print(" " + n3);
	         recursiveFibonacci2(value - 1);
	      }
		
	}
	
	private int recursiveFibonacci(int value) {

		if (value < 2) {
			return value;
		}
		return recursiveFibonacci(value - 1) + recursiveFibonacci(value - 2);
	}

	private void iterativeFibonacci2(int value) {
		int value0 = 0;
		int value1 = 1;
		System.out.print("\nFibonaaci series of " + value + ": " + value0 + " " + value1);
		for (int i = 2; i < value; i++) {
			int value2 = value1 + value0;
			System.out.print(" " + value2);
			value0 = value1;
			value1 = value2;
		}

	}

	private void iterativeFibonacci1(int value) {
		int fibonaaciArray[] = new int[value];
		fibonaaciArray[0] = 0;
		fibonaaciArray[1] = 1;
		for (int i = 2; i < value; i++) {
			fibonaaciArray[i] = fibonaaciArray[i - 1] + fibonaaciArray[i - 2];
		}

		System.out.println("Fibonaaci series of " + value + ": " + Arrays.toString(fibonaaciArray));
	}

}
