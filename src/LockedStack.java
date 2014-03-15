import java.util.concurrent.locks.ReentrantLock;


public class LockedStack<E extends Node> implements Stack<E> {

	private ReentrantLock lock = new ReentrantLock();
	private Stack<E> stack = new SimpleStack<E>();
	
	@Override
	public void push(E entry) {
		lock.lock();
		try {
			stack.push(entry);
		}
		finally {
			lock.unlock();
		}
	}

	@Override
	public E pop() {
		lock.lock();
		try {
			return stack.pop();
		}
		finally {
			lock.unlock();
		}
	}

	@Override
	public boolean isEmpty() {
		lock.lock();
		try {
			return stack.isEmpty();
		}
		finally {
			lock.unlock();
		}
	}

}
