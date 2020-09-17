package queue;

import java.util.Stack;

public class QueueImplUsingStack1 {
	  private Stack<Integer> stack = new Stack<>();
	  private Stack<Integer> auxiliaryStack = new Stack<>();

	  public void enqueue(int value) {
	    stack.push(value);
	  }

	  public int dequeue() {
	    fillAuxiliaryStackWithStack();
	    int value = auxiliaryStack.pop();
	    fillStackWithAuxiliaryStack();
	    return value;
	  }

	  public int peek() {
	   fillAuxiliaryStackWithStack();
	    int value = auxiliaryStack.peek();
	    System.out.println("Peek:"+ value);
	    fillStackWithAuxiliaryStack();
	    return value;
	  }

	  
	  /* while printing after reversing using aux stack -- in foreach index start from 0
	   * but when we directly print using foreach (w/o calling fillAuxiliaryStackWithStack), use arrow in reverse direction 
	   * the arrow  must be towards the first person in queue
	   */
	  public void printQueue() {
	    if (stack.empty()) {
	      return;
	    }
	    fillAuxiliaryStackWithStack();
	    int count = 0;
	    for (int auxiliaryStackElement : auxiliaryStack) {
	      System.out.print(count<auxiliaryStack.size()-1? auxiliaryStackElement+ " -> " : auxiliaryStackElement);
	      count++;
	    }
	    System.out.println();
	   fillStackWithAuxiliaryStack();
	  }

	  private void fillAuxiliaryStackWithStack() {
	    while (!stack.isEmpty()) { //Making the "auxiliaryStack" stack as queue of "Stack"
	      auxiliaryStack.push(stack.pop());
	    }
	  }

	  private void fillStackWithAuxiliaryStack() {
	    while (!auxiliaryStack.isEmpty()) { //Return stack to the original state
	      stack.push(auxiliaryStack.pop());
	    }
	  }


	  public static void main(String[] args) {
		QueueImplUsingStack1 queue = new QueueImplUsingStack1();
	    queue.enqueue(10);
	    queue.enqueue(4);
	    queue.enqueue(5);
	    queue.printQueue();
	    queue.dequeue();
	    queue.printQueue();
	    queue.dequeue();
	    queue.printQueue();
	    queue.peek();
	    
	  }
}
