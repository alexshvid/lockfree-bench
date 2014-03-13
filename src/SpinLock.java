import java.util.concurrent.atomic.AtomicBoolean;

public class SpinLock {

	private AtomicBoolean locked = new AtomicBoolean(false);

	public void acquire() {
		while (!locked.compareAndSet(false, true)) {}
	}

	public void release() {
		locked.getAndSet(false);
	}

}
