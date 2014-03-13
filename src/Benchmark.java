import java.util.concurrent.CyclicBarrier;


public class Benchmark {

	public static final int MAX_THREADS = 32;
	
	public static final class LockedElement {
	    int data;
	};
	
	public static final LockedElement DEFAULT_ELEMENT = new LockedElement();

	public static class Worker implements Runnable {

		private final CyclicBarrier barrier;
		private final Stack<LockedElement> stack;
		private final int initElements;
		private int ops;
		
		public Worker(CyclicBarrier barrier, Stack<LockedElement> stack, int initElements) {
			this.barrier = barrier;
			this.stack = stack;
			this.initElements = initElements;
		}
		
		@Override
		public void run() {
			
			for (int i = 0; i != initElements; ++i) {
				stack.push(DEFAULT_ELEMENT);
			}
			
			try {
				barrier.await();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			while(!Thread.interrupted()) {
			
				if (ops % 2 == 1){
					stack.push(DEFAULT_ELEMENT);
				}
				else {
					stack.pop();
				}
				
				ops++;
			
			}
			
		}

		public int getOps() {
			return ops;
		}

	}
	
	public static double test(Stack<LockedElement> stack, int numThreads) {
		
		CyclicBarrier barrier = new CyclicBarrier(numThreads+1);
		
		Worker[] workers = new Worker[numThreads];
		Thread[] thread = new Thread[numThreads];
		
		for (int i = 0; i != numThreads; ++i) {
			workers[i] = new Worker(barrier, stack, 20000 / numThreads);
			thread[i] = new Thread(workers[i]);
			thread[i].start();
		}

		try {
			barrier.await();
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		long t0 = System.currentTimeMillis();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		for (int i = 0; i != numThreads; ++i) {
			thread[i].interrupt();
		}

		long t1 = System.currentTimeMillis();
		
		for (int i = 0; i != numThreads; ++i) {
			try {
				thread[i].join();
			} catch (InterruptedException e) {
			}
		}

		int totalOps = 0;
		for (int i = 0; i != numThreads; ++i) {
			totalOps += workers[i].getOps();
		}
		
		return (double) totalOps / (t1 - t0);
	}
	
	public static void main(String[] args) {
		
	    for(int i = 1; i != MAX_THREADS; ++i)
	    {
	        double lockFreeTime = test(new LockFreeStack<LockedElement>(), i);
	        double lockedTime = test(new LockedStack<LockedElement>(), i);
	        double synchTime = test(new SynchronizedStack<LockedElement>(), i);
	        double spinLockedTime = test(new SpinLockedStack<LockedElement>(), i);
	        System.out.println(String.format("%d threads, LockFree: %d/msec, Locked: %d/msec, Synch: %d/msec, SpinLocked: %d/msec", i, (int)lockFreeTime, (int)lockedTime, (int)synchTime, (int)spinLockedTime));
	    }
		
	} 
	
	
}
