
public class SimpleStack<E> implements Stack<E> {

	private Node<E> head = null;
	
	@Override
	public void push(E entry) {
		head = new Node<E>(entry, head);
	}

	@Override
	public E pop() {
		if (head != null) {
			E entry = head.entry;
			head = head.next;
			return entry;
		}
		return null;
	}
	
	@Override
	public boolean isEmpty() {
		return head == null;
	}
	
	private static class Node<E> {
		final E entry;
		final Node<E> next;
		
		Node(E entry, Node<E> next) {
			this.entry = entry;
			this.next = next;
		}
	}
	
	
}
