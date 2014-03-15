import java.util.concurrent.atomic.AtomicBoolean;

public class SpinLock {

	private AtomicBoolean locked = new AtomicBoolean(false);

	public void acquire() {
		while (!locked.compareAndSet(false, true)) {
			
			JvmTools.usleep(250);
		}
	}

	public void release() {
		locked.getAndSet(false);
	}

}
