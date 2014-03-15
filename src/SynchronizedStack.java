
public class SynchronizedStack<E extends Node> implements Stack<E> {

	private Stack<E> stack = new SimpleStack<E>();
	
	@Override
	public void push(E entry) {
		synchronized (stack) {
			stack.push(entry);
		}
	}

	@Override
	public E pop() {
		synchronized (stack) {
			return stack.pop();
		}
	}

	@Override
	public boolean isEmpty() {
		synchronized (stack) {
			return stack.isEmpty();
		}
	}

}
