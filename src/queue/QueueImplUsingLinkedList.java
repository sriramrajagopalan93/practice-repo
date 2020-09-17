package queue;


/*
 * ADDITIONAL: PRIORITY QUEUE: https://www.geeksforgeeks.org/priority-queue-class-in-java-2/
 */

public class QueueImplUsingLinkedList {

	QueueNode first;
	QueueNode last;
	int length;

	QueueImplUsingLinkedList() {
		this.first = null;
		this.last = null;
		this.length = 0;
	}

	public static void main(String[] args) {
		QueueImplUsingLinkedList queueImplUsingLinkedList = new QueueImplUsingLinkedList();
		queueImplUsingLinkedList.enqueue("abc");
		queueImplUsingLinkedList.enqueue("def");
		queueImplUsingLinkedList.printQueue();
		queueImplUsingLinkedList.dequeue();
		queueImplUsingLinkedList.printQueue();
		queueImplUsingLinkedList.peek();

	}

	private void printQueue() {
		if (isEmpty()) {
			System.out.println("There are no elements in queue to print");
		} else {
			QueueNode node = this.first;
			System.out.println("Queue Values: ");
			while (node != null) {
				System.out.print(node.next != null ? node.value + " <- " : node.value);
				node = node.next;
			}
			System.out.println();
		}
	}

	private boolean isEmpty() {
		return this.length == 0;
	}

	private void enqueue(String value) {
		QueueNode newNode = new QueueNode(value);
		if (isEmpty()) {
			this.first = newNode;
			this.last = newNode;
			this.length++;
			return;
		}
		this.last.next = newNode;
		this.last = newNode;
		this.length++;
	}

	private void dequeue() {
		if (isEmpty()) {
			System.out.println("There are no elements in queue to dequeue");
		} else if (this.length == 1) {
			this.first = null;
			this.last = null;
			this.length = 0;
		} else {
			this.first = this.first.next;
			this.length--;
		}
	}

	private void peek() {
		if (isEmpty()) {
			System.out.println("There are no elements in queue to peek");
		} else {
			System.out.println(this.first.value);
		}

	}
}
