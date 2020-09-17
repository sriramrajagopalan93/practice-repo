package dynamic_programming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FibonacciDynamicProgramming {
	int calculations = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int value = 5;
		FibonacciDynamicProgramming fibonacciDynamicProgramming = new FibonacciDynamicProgramming();
		System.out.print("Normal Fibonacci Series of " + value + ": ");
		List<Integer> fiboArrayList = new ArrayList<>();
		fiboArrayList.add(0);
		fiboArrayList.add(1);
		fibonacciDynamicProgramming.recursiveFibonacciNormal(value, fiboArrayList);

		int result = fibonacciDynamicProgramming.recursiveFibonacciNormal2(value);
		System.out.println("\nFibonacci Result: " + result);
		System.out.print("Took " + fibonacciDynamicProgramming.calculations + " calculations");

		fibonacciDynamicProgramming.calculations = 0;
		Map<Integer, Integer> cachedMap = new HashMap<>();
		result = fibonacciDynamicProgramming.recursiveFibonacciMemoized(value, cachedMap);
		System.out.println("\nMemoized Fibonacci Result: " + result);
		System.out.print("Took " + fibonacciDynamicProgramming.calculations + " calculations");
	}

	private int recursiveFibonacciMemoized(int value, Map<Integer, Integer> cachedMap) {
		if (cachedMap.containsKey(value)) {
			return cachedMap.get(value);
		} else {
			if (value < 2) {
				return value;
			}
			calculations++;
			int result = recursiveFibonacciMemoized(value - 1, cachedMap)
					+ recursiveFibonacciMemoized(value - 2, cachedMap);
			cachedMap.put(value, result);
			return cachedMap.get(value);
		}
	}

	private int recursiveFibonacciNormal2(int value) {
		calculations++;
		if (value < 2) {
			return value;
		}
		int returnValue = recursiveFibonacciNormal2(value - 1) + recursiveFibonacciNormal2(value - 2);
		return returnValue;
	}

	private void recursiveFibonacciNormal(int value, List<Integer> fiboArrayList) {
		int fiboArraySize = fiboArrayList.size();
		if (fiboArraySize < value) {
			calculations++;
			fiboArrayList.add(fiboArrayList.get(fiboArraySize - 1) + fiboArrayList.get(fiboArraySize - 2));
			recursiveFibonacciNormal(value, fiboArrayList);
		} else { // after fiboArraySize reaches the size of value. i.e. No of list elements =
					// value
			System.out.println(fiboArrayList.toString());
			System.out.println("Took " + calculations + " calculations");
		}
	}
}
