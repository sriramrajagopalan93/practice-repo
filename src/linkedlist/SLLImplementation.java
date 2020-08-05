package linkedlist;

public class SLLImplementation {
	int length;
	SLLNode head;
	SLLNode tail;
	
	
	SLLImplementation(int value){
		this.head = new SLLNode(value);
		this.length=1;
		this.tail = this.head; 
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SLLImplementation sllImplementation = new SLLImplementation(10);
		sllImplementation.append(1);
		sllImplementation.append(8);
		sllImplementation.printList();
		sllImplementation.prepend(2);
		sllImplementation.prepend(3);
		sllImplementation.printList();
		sllImplementation.insert(2, 20);
		sllImplementation.printList();
		sllImplementation.delete(4);
		sllImplementation.printList();
		sllImplementation = sllImplementation.reverse1();
		sllImplementation.printList();
		sllImplementation = sllImplementation.reverse2();
		sllImplementation.printList();
		sllImplementation = sllImplementation.reverse1();
		sllImplementation.printList();
		sllImplementation = sllImplementation.reverse2();
		sllImplementation.printList();
	}

	private void printList() {
		SLLNode node = this.head;
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
		this.tail.next = new SLLNode(value);
		this.tail = this.tail.next;
		this.length++;
	}

	private void prepend(int value) {
		SLLNode newHead = new SLLNode(value);
		newHead.next = this.head;
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
		SLLNode node = this.head;
		for(int i=0;i<index-1;i++) {
			node = node.next;
		}
		SLLNode newNode = new SLLNode(value);
		newNode.next = node.next;
		node.next = newNode;
		this.length++;
	}
	
	private void delete(int index) {
		if(index == 0) {
			this.head = this.head.next;
			this.length--;
			return;
		}
		SLLNode node = this.head;
		for(int i=0;i<index-1;i++) {
			node = node.next;
		}
		node.next = node.next.next;
		this.length--;
	}
	
	private SLLImplementation reverse1() {
		SLLImplementation reversedLinkedList  = new SLLImplementation(this.head.value);
		SLLNode node = this.head;
		for(int i=0; i< this.length-1;i++) {
			SLLNode newNode = new SLLNode(node.next.value);
			newNode.next = reversedLinkedList.head;
			reversedLinkedList.head = newNode;
			node = node.next;
			reversedLinkedList.length++;
		}
		
		return reversedLinkedList;
	}
	
	// reverse -- in place
	private SLLImplementation reverse2() {
		SLLNode first = this.head;
		SLLNode second = first.next;
		while(second!=null) {
			SLLNode temp = second.next;
			second.next = first;
			first = second;
			second = temp;
		}
		this.tail = this.head;
		this.tail.next = null;
		this.head = first;
		return this;
	}
}
