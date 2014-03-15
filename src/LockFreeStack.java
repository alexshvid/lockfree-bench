import java.util.concurrent.atomic.AtomicReference;



public class LockFreeStack<E extends Node> implements Stack<E> {

	private AtomicReference<Holder<E>> head = new AtomicReference<Holder<E>>(new Holder<E>(null));
	
	@Override
	public void push(E entry) {
		Holder<E> holder = new Holder<E>(entry);
		while(true) {
			Holder<E> top = head.get();
			entry.setNext(top.node);
			if (head.compareAndSet(top, holder)) {
				return;
			}
		}
	}

	@Override
	public E pop() {
		Holder<E> holder = null;
		while(true) {
		
			Holder<E> top = head.get();
			if (top.node == null) {
				return null;
			}
			
			E next = (E) top.node.getNext();
			if (holder == null) {
				holder = new Holder<E>(next);
			}
			else {
				holder.node = next;
			}
			
			if (head.compareAndSet(top, holder)) {
				return top.node;
			}
		
		}
		
	}
	
	@Override
	public boolean isEmpty() {
		return head.get() == null;
	}
	
	private static final class Holder<E extends Node> {
		E node;
		Holder(E node) {
			this.node = node;
		}
	}
	
}
