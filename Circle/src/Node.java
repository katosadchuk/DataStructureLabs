//package circularlinkedlist;

public class Node<E> {

	E item;
	Node<E> next;
	
	public Node() {

		this.item = null;
		this.next = null;
		
	}
	
	public Node(E e) {
		this.item = e;
		this.next = null;
	}
	
	
	public E getElement() {
		return this.item;
	}
	
	
	public void setElement(E element) {
		this.item= element;
	}

}
