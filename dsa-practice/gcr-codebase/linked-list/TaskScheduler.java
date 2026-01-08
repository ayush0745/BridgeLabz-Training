import java.util.Scanner;

class Task {
    int id;
    String name;
    String date;
    int priority;
    Task next;

    public Task(int id, String name, String date, int priority) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.priority = priority;
        this.next = null;
    }
}

class TaskRecord {
    Task head;

    public void addAtBeginning(int id, String name, String date, int priority) {
        Task newTask = new Task(id, name, date, priority);

        if (head == null) {
            head = newTask;
            newTask.next = head;
            return;
        }

        Task temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        newTask.next = head;
        temp.next = newTask;
        head = newTask;
    }

    public void addAtEnd(int id, String name, String date, int priority) {
        Task newTask = new Task(id, name, date, priority);

        if (head == null) {
            head = newTask;
            newTask.next = head;
            return;
        }

        Task temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = newTask;
        newTask.next = head;
    }

    public void addAtPosition(int pos, int id, String name, String date, int priority) {
        if (pos <= 1 || head == null) {
            addAtBeginning(id, name, date, priority);
            return;
        }

        Task newTask = new Task(id, name, date, priority);
        Task temp = head;

        for (int i = 1; i < pos - 1 && temp.next != head; i++) {
            temp = temp.next;
        }

        newTask.next = temp.next;
        temp.next = newTask;
    }

    public void removeById(int id) {
        if (head == null) {
            System.out.println("Task list is empty");
            return;
        }

        Task curr = head, prev = null;

        do {
            if (curr.id == id) {
                if (curr == head && curr.next == head) {
                    head = null;
                } else if (curr == head) {
                    Task temp = head;
                    while (temp.next != head) {
                        temp = temp.next;
                    }
                    head = head.next;
                    temp.next = head;
                } else {
                    prev.next = curr.next;
                }
                System.out.println("Task removed successfully");
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);

        System.out.println("Task not found");
    }

    public void viewCurrentAndMoveNext() {
        if (head == null) {
            System.out.println("No tasks available");
            return;
        }

        displayTask(head);
        head = head.next;
    }

    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks to display");
            return;
        }

        Task temp = head;
        do {
            displayTask(temp);
            temp = temp.next;
        } while (temp != head);
    }

    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("Task list is empty");
            return;
        }

        Task temp = head;
        boolean found = false;

        do {
            if (temp.priority == priority) {
                displayTask(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No task found with given priority");
        }
    }

    private void displayTask(Task t) {
        System.out.println(
            "ID: " + t.id +
            " | Name: " + t.name +
            " | Due Date: " + t.date +
            " | Priority: " + t.priority
        );
    }
}

public class TaskScheduler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskRecord scheduler = new TaskRecord();
        int choice;

        do {
            System.out.println("\n=== TASK SCHEDULER MENU ===");
            System.out.println("1. Add Task at Beginning");
            System.out.println("2. Add Task at End");
            System.out.println("3. Add Task at Position");
            System.out.println("4. Remove Task by ID");
            System.out.println("5. View Current Task & Move Next");
            System.out.println("6. Display All Tasks");
            System.out.println("7. Search Task by Priority");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                case 2:
                case 3:
                    System.out.print("Enter Task ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Task Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Due Date: ");
                    String date = sc.nextLine();

                    System.out.print("Enter Priority: ");
                    int priority = sc.nextInt();

                    if (choice == 1)
                        scheduler.addAtBeginning(id, name, date, priority);
                    else if (choice == 2)
                        scheduler.addAtEnd(id, name, date, priority);
                    else {
                        System.out.print("Enter Position: ");
                        int pos = sc.nextInt();
                        scheduler.addAtPosition(pos, id, name, date, priority);
                    }
                    break;

                case 4:
                    System.out.print("Enter Task ID to remove: ");
                    scheduler.removeById(sc.nextInt());
                    break;

                case 5:
                    scheduler.viewCurrentAndMoveNext();
                    break;

                case 6:
                    scheduler.displayAllTasks();
                    break;

                case 7:
                    System.out.print("Enter Priority to search: ");
                    scheduler.searchByPriority(sc.nextInt());
                    break;

                case 0:
                    System.out.println("Exiting Task Scheduler...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        } while (choice != 0);

        sc.close();
    }
}
