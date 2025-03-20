package pcd.lab04.monitors.ex_barrier;

/*
 * Barrier - to be implemented
 */
public class BarrierImpl implements Barrier {
	private final int nParticipants;
	private int numWorkers;
	
	public BarrierImpl(int nParticipants) {
		this.nParticipants = nParticipants;
		this.numWorkers = 0;
	}
	
	@Override
	public synchronized void hitAndWaitAll() throws InterruptedException {
		numWorkers++;
		while (numWorkers < nParticipants) {
			wait();
		}
		notifyAll();
	}
}
