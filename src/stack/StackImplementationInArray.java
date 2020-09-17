package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StackImplementationInArray {

	List<Integer> stackArray;
	StackImplementationInArray(){
		this.stackArray = new ArrayList<Integer>();
	}
	
	public static void main(String[] args) {
		StackImplementationInArray stackImplementationInArray = new StackImplementationInArray();
		stackImplementationInArray.push(10);
		stackImplementationInArray.printStack();
		stackImplementationInArray.push(20);
		stackImplementationInArray.push(30);
		stackImplementationInArray.printStack();
		stackImplementationInArray.pop();
		stackImplementationInArray.printStack();
		stackImplementationInArray.peek();
	}

	private void printStack() {
		if(this.stackArray.size() == 0) {
			System.out.println("No elements in stack to print");	
			return;
		}
		System.out.println("Stack Order: ");
		this.stackArray.stream().sorted(Comparator.reverseOrder()).forEach(element -> {
			System.out.println(element);
		});
	}
	
	private void push(int value) {
		this.stackArray.add(value);
	}

	private void pop() {
		if(this.stackArray.size() == 0) {
			System.out.println("No elements in stack to pop");	
			return;
		}
		this.stackArray.remove(this.stackArray.size()-1);
	}
	
	private void peek() {
		if(this.stackArray.size() == 0) {
			System.out.println("No elements in stack to peek");	
			return;
		}
		int topElement = this.stackArray.get(this.stackArray.size()-1);
		System.out.println("Top Element: "+topElement);
	}
}
