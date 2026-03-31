
import java.time.LocalTime;

class TaskRunner extends Thread {

	public TaskRunner(String name) {
		super(name);
	}

	@Override
	public void run() {
		try {
			Thread.sleep(2000);
			long sum = 0;
			for (int i = 0; i < 1_000_000; i++) {
				sum += i;
			}
		} catch (InterruptedException e) {
			System.out.println(getName() + " was interrupted");
		}
	}
}

class StateMonitor extends Thread {
	private Thread[] threads;

	public StateMonitor(Thread[] threads) {
		this.threads = threads;
	}

	@Override
	public void run() {
		boolean allTerminated = false;
		while (!allTerminated) {
			allTerminated = true;
			for (Thread t : threads) {
				System.out.println(
						"[Monitor] " + t.getName() + " is in " + t.getState() + " state at " + LocalTime.now());
				if (t.getState() != Thread.State.TERMINATED) {
					allTerminated = false;
				}
			}

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println("-----");
		}

		System.out.println("Summary: All threads have terminated.");
	}
}

public class ThreadMonitoringSystem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TaskRunner task1 = new TaskRunner("Task-1");
		TaskRunner task2 = new TaskRunner("Task-2");

		System.out.println("[Monitor] " + task1.getName() + " is in " + task1.getState() + " state");
		System.out.println("[Monitor] " + task2.getName() + " is in " + task2.getState() + " state");

		StateMonitor monitor = new StateMonitor(new Thread[] { task1, task2 });
		monitor.start();

		task1.start();
		task2.start();
	}

}