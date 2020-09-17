package queue;

public class QueueNode {

	String value;
	QueueNode next;
	
	QueueNode(String value) {
		this.value = value;
		this.next = null;
	}
}
