
public class EmptyStack<E extends Node> implements Stack<E> {

	
	@Override
	public void push(E entry) {
	}

	@Override
	public E pop() {
		return null;
	}
	
	@Override
	public boolean isEmpty() {
		return true;
	}
	
}
