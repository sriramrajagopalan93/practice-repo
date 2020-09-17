package stack;


/*
 * Stack can be implemented using linked list.
 * Stack is used when we need to perform only controlled set of operations
 * Where in case of Linked list many operations are possible (insert/delete at any location etc.)
 */
public class StackImplementation {

	StackNode top;
	StackNode bottom;
	int length;
	
	StackImplementation(){
		this.top = null;
		this.bottom = null;
		this.length = 0;
	}
	
	public static void main(String[] args) {
		StackImplementation stackImplementation = new StackImplementation();
		stackImplementation.push(3);
		stackImplementation.push(4);
		stackImplementation.printStack();
		stackImplementation.pop();
		stackImplementation.printStack();
		stackImplementation.push(5);
		stackImplementation.printStack();
		stackImplementation.peek();
	}

	private void printStack() {
		StackNode node = this.top;
		if(this.length == 0) {
			System.out.println("There are no elements in stack to print");
			return;
		}
		System.out.println("Stack Order:");
		for(int i=0;i< this.length;i++) {
			System.out.println(node.value);
			node = node.next;
		}
	}
	
	private void push(int value) {
		StackNode newNode = new StackNode(value);
		if(this.length == 0) {
			this.top = newNode;
			this.bottom = newNode;
			this.length++;
			return;
		}
		newNode.next = this.top;
		this.top = newNode;
		this.length++;
	}
	
	private void pop() {
		if(this.length == 0) {
			System.out.println("There are no elements to pop");
		}
		else if(this.length == 1) {
			this.top = null;
			this.bottom = null;
			this.length = 0;
		}
		else {
			this.top = this.top.next;
			this.length--;
		}
	}

	private void peek() {
		if(this.length == 0) {
			System.out.println("There are no elements in stack");
			return;
		}
		System.out.println("Top Element: "+this.top.value);
	}
}
