import java.util.concurrent.atomic.AtomicReference;



public class LockFreeStack<E> implements Stack<E> {

	private AtomicReference<Node<E>> head = new AtomicReference<Node<E>>(null);
	
	@Override
	public void push(E entry) {
		while(true) {
			Node<E> old = head.get();
			if (head.compareAndSet(old, new Node<E>(entry, old))) {
				return;
			}
		}
	}

	@Override
	public E pop() {
		while(true) {
		
			Node<E> old = head.get();
			if (old == null) {
				return null;
			}
			
			E result = old.entry;
			Node<E> newHead = old.next;
			
			if (head.compareAndSet(old, newHead)) {
				return result;
			}
		
		}
		
	}
	
	@Override
	public boolean isEmpty() {
		return head.get() == null;
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
