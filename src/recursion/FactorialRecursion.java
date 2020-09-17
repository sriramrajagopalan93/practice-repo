package recursion;

public class FactorialRecursion {

	public static void main(String[] args) {
		FactorialRecursion factorialRecursion = new FactorialRecursion();		
		int value = 5;
		int factorial = factorialRecursion.recursiveFactorial1(value, 1);
		System.out.println("Recursion Factorial 1 of "+value+": "+factorial);
		
		factorial = factorialRecursion.recursiveFactorial2(value);
		System.out.println("Recursion Factorial 2 of "+value+": "+factorial);
		
		factorial = factorialRecursion.iterativeFactorial(value);
		System.out.println("Normal Factorial of "+value+": "+factorial);
	}

	/*
	 * 5 * 4!
	 * 		-> 4 * 3!
	 * 				-> 3 * 2!
	 * 						2 * 1! = 2 (1! will return 1 and return values will be going upwards now)
	 */
	private int recursiveFactorial2(int value) {
		if(value==0 || value==1) {
			return 1;
		}
		return value* (recursiveFactorial2(value-1));
	}

	private int recursiveFactorial1(int value, int result) {
		System.out.println(result);
		if(value<=1) { //0! is 1
			return result;
		}
		result = value--* (recursiveFactorial1(value, result));
		return result;
	}
	
	private int iterativeFactorial(int value) {
		int result =1;
		for(int i=value;i>0;i--) {
			result = result*i;
		}
		return result;
	}

}
