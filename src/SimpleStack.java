
public class SimpleStack<E extends Node> implements Stack<E> {

	private E head = null;
	
	@Override
	public void push(E entry) {
		entry.setNext(head);
		head = entry;
	}

	@Override
	public E pop() {
		E top = head;
		if (top != null) {
			E next = (E) top.getNext();
			head = next;
			return top;
		}
		return null;
	}
	
	@Override
	public boolean isEmpty() {
		return head == null;
	}
	
}
