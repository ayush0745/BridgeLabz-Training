class Process {
    int pid;
    int burstTime;
    int remainingTime;
    int priority;

    int waitingTime;
    int turnAroundTime;

    Process next;

    public Process(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

class RoundRobinScheduler {
    private Process head = null;
    private int size = 0;

    // 1. Add process at end
    public void addProcess(int pid, int burstTime, int priority) {
        Process p = new Process(pid, burstTime, priority);

        if (head == null) {
            head = p;
            p.next = head;
        } else {
            Process temp = head;
            while (temp.next != head)
                temp = temp.next;

            temp.next = p;
            p.next = head;
        }
        size++;
    }

    // 2. Remove process by PID
    private void removeProcess(Process prev, Process curr) {
        if (curr == head && curr.next == head) {
            head = null;
        } else {
            if (curr == head) {
                Process temp = head;
                while (temp.next != head)
                    temp = temp.next;
                head = head.next;
                temp.next = head;
            } else {
                prev.next = curr.next;
            }
        }
        size--;
    }

    // 3. Simulate Round Robin Scheduling
    public void simulate(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule");
            return;
        }

        int currentTime = 0;
        Process curr = head;
        Process prev = null;

        System.out.println("\n--- Round Robin Scheduling Start ---");

        while (size > 0) {
            System.out.println("\nExecuting Process: P" + curr.pid);

            if (curr.remainingTime > timeQuantum) {
                curr.remainingTime -= timeQuantum;
                currentTime += timeQuantum;
            } else {
                currentTime += curr.remainingTime;
                curr.remainingTime = 0;

                curr.turnAroundTime = currentTime;
                curr.waitingTime = curr.turnAroundTime - curr.burstTime;

                System.out.println("Process P" + curr.pid + " completed");

                Process toDelete = curr;
                curr = curr.next;
                removeProcess(prev, toDelete);
                displayQueue();
                continue;
            }

            displayQueue();
            prev = curr;
            curr = curr.next;
        }

        System.out.println("\n--- Scheduling Completed ---");
    }

    // 4. Display current circular queue
    public void displayQueue() {
        if (head == null) {
            System.out.println("Queue Empty");
            return;
        }

        Process temp = head;
        System.out.print("Queue: ");
        do {
            System.out.print("[P" + temp.pid +
                    " | RT=" + temp.remainingTime + "] -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(Back to Head)");
    }
}

public class RoundRobinSchedulingAlgorithm {
    public static void main(String[] args) {
        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        // Add processes
        scheduler.addProcess(1, 10, 1);
        scheduler.addProcess(2, 5, 2);
        scheduler.addProcess(3, 8, 1);
        scheduler.addProcess(4, 6, 3);

        int timeQuantum = 3;

        scheduler.simulate(timeQuantum);
    }
}
