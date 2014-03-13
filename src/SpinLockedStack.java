public class SpinLockedStack<E> implements Stack<E> {

	private SpinLock lock = new SpinLock();
	private Stack<E> stack = new SimpleStack<E>();

	@Override
	public boolean isEmpty() {
		lock.acquire();
		try {
			return stack.isEmpty();
		}
		finally {
			lock.release();
		}
	}

	public void push(E entry) {
		lock.acquire();
		try {
			stack.push(entry);
		}
		finally {
			lock.release();
		}
	}

	public E pop() {
		lock.acquire();
		try {
			return stack.pop();
		}
		finally {
			lock.release();
		}
	}

}
