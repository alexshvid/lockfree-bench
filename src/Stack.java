public interface Stack<E extends Node> {

	void push(E entry);

	E pop();

	boolean isEmpty();

}