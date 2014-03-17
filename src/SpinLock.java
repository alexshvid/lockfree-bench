import java.util.concurrent.atomic.AtomicBoolean;

public class SpinLock {

	private AtomicBoolean locked = new AtomicBoolean(false);

	public void acquire() {
		while (!locked.compareAndSet(false, true)) {
			
			//try {
		//		Thread.sleep(0, 250000);
		//	} catch (InterruptedException e) {
		//	}
			
			JvmTools.usleep(250);
		}
	}

	public void release() {
		locked.getAndSet(false);
	}

}
