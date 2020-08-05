package linkedlist;

public class DLLImplementation {
	int length;
	DLLNode head;
	DLLNode tail;
	
	
	DLLImplementation(int value){
		this.head = new DLLNode(value);
		this.length=1;
		this.tail = this.head; 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DLLImplementation dllImplementation = new DLLImplementation(10);
		dllImplementation.append(1);
		dllImplementation.append(8);
		dllImplementation.printList();
		dllImplementation.prepend(2);
		dllImplementation.prepend(3);
		dllImplementation.printList();
		dllImplementation.insert(2, 20);
		dllImplementation.printList();
		dllImplementation.delete(4);
		dllImplementation.printList();
		dllImplementation = dllImplementation.reverse();
		dllImplementation.printList();
		dllImplementation = dllImplementation.reverse();
		dllImplementation.printList();
	}

	private void printList() {
		DLLNode node = this.head;
		for(int  i=0; i< this.length ; i++) {
			System.out.print(node.value);
			node = node.next;
			System.out.print(node!=null?" -> ":"");
		}
		System.out.println();
		// OR BELOW METHOD FOR PRINTING
//		SLLNode node = this.head;
//		while(node!=null) {
//			System.out.println(node.value);
//			node = node.next;
//			System.out.print(node!=null?" -> ":"");
//		}
	}


	private void append(int value) {
		DLLNode dllNode = new DLLNode(value);
		this.tail.next = dllNode;
		dllNode.prev = this.tail;
		this.tail = dllNode;
		this.length++;
	}

	private void prepend(int value) {
		DLLNode newHead = new DLLNode(value);
		newHead.next = this.head;
		this.head.prev = newHead;
		this.head  =newHead;
		this.length++;
	}
	
	private void insert(int index, int value) {
		if(index == 0) {
			prepend(value);
			return;
		}
		if(index == length) {
			append(value);
			return;
		}
		DLLNode node = this.head;
		for(int i=0;i<index-1;i++) {
			node = node.next;
		}
		DLLNode newNode = new DLLNode(value);
		newNode.next = node.next;
		newNode.next.prev = newNode;
		node.next = newNode;
		newNode.prev = node;
		this.length++;
	}
	
	private void delete(int index) {
		if(index == 0) {
			this.head = this.head.next;
			this.head.prev = null;
			this.length--;
			return;
		}
		DLLNode node = this.head;
		for(int i=0;i<index-1;i++) {
			node = node.next;
		}
		node.next = node.next.next;
		node.next.prev = node;
		this.length--;
	}
	
	// this reverse if from tail->head, can use the same logic of SLL also
	private DLLImplementation reverse() {
		DLLImplementation reversedLinkedList  = new DLLImplementation(this.tail.value);
		DLLNode node = this.tail;
		for(int i=0; i< this.length-1;i++) {
			DLLNode newNode = new DLLNode(node.prev.value);
			reversedLinkedList.tail.next = newNode;
			newNode.prev = reversedLinkedList.tail;
			reversedLinkedList.tail  = newNode;
			reversedLinkedList.length++;
			node = node.prev;
		}
		
		return reversedLinkedList;
	}
}
