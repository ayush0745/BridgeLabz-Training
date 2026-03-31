import java.util.Scanner;

class TextState {
    String content;
    TextState prev;
    TextState next;

    public TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}

class Page {
    private TextState head;
    private TextState tail;
    private TextState current;
    private int size;
    private final int MAX_HISTORY = 10;

    // Add new text state
    public void addState(String content) {
        TextState newState = new TextState(content);

        // Clear redo history if undo was used
        if (current != tail && current != null) {
            TextState temp = current.next;
            while (temp != null) {
                TextState next = temp.next;
                temp.prev = temp.next = null;
                temp = next;
                size--;
            }
            current.next = null;
            tail = current;
        }

        if (head == null) {
            head = tail = current = newState;
            size = 1;
            return;
        }

        tail.next = newState;
        newState.prev = tail;
        tail = newState;
        current = newState;
        size++;

        // Limit history size
        if (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    // Undo operation
    public void undo() {
        if (current == null || current.prev == null) {
            System.out.println("Nothing to undo");
            return;
        }
        current = current.prev;
        displayCurrent();
    }

    // Redo operation
    public void redo() {
        if (current == null || current.next == null) {
            System.out.println("Nothing to redo");
            return;
        }
        current = current.next;
        displayCurrent();
    }

    // Display current text
    public void displayCurrent() {
        if (current == null) {
            System.out.println("Editor is empty");
            return;
        }
        System.out.println("Current Text: \"" + current.content + "\"");
    }

    // Display full history
    public void displayHistory() {
        if (head == null) {
            System.out.println("No history available");
            return;
        }

        TextState temp = head;
        System.out.print("History: ");
        while (temp != null) {
            if (temp == current)
                System.out.print("[" + temp.content + "] ");
            else
                System.out.print(temp.content + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class TextEditor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Page editor = new Page();
        int choice;

        do {
            System.out.println("\n=== TEXT EDITOR MENU ===");
            System.out.println("1. Add New Text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Display Current Text");
            System.out.println("5. Display History");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter text: ");
                    String text = sc.nextLine();
                    editor.addState(text);
                    editor.displayCurrent();
                    break;

                case 2:
                    editor.undo();
                    break;

                case 3:
                    editor.redo();
                    break;

                case 4:
                    editor.displayCurrent();
                    break;

                case 5:
                    editor.displayHistory();
                    break;

                case 0:
                    System.out.println("Exiting Editor...");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 0);

        sc.close();
    }
}
