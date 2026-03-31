import java.util.*;

// Node for Doubly Linked List (History)
class HistoryNode {
    String url;
    HistoryNode prev;
    HistoryNode next;

    HistoryNode(String url) {
        this.url = url;
    }
}

// Represents a Browser Tab
class BrowserTab {
    private HistoryNode current;

    // Visit a new page
    public void visit(String url) {
        HistoryNode newNode = new HistoryNode(url);

        if (current != null) {
            current.next = null; // clear forward history
            newNode.prev = current;
            current.next = newNode;
        }
        current = newNode;

        System.out.println("Visited: " + url);
    }

    // Go back
    public void back() {
        if (current == null || current.prev == null) {
            System.out.println("No page to go back.");
            return;
        }
        current = current.prev;
        System.out.println("Back to: " + current.url);
    }

    // Go forward
    public void forward() {
        if (current == null || current.next == null) {
            System.out.println("No page to go forward.");
            return;
        }
        current = current.next;
        System.out.println("Forward to: " + current.url);
    }

    public String getCurrentPage() {
        return current == null ? "Empty Tab" : current.url;
    }
}

// Manages tabs and recently closed tabs
class BrowserManager {
    private BrowserTab activeTab;
    private Stack<BrowserTab> closedTabs = new Stack<>();

    public BrowserManager() {
        activeTab = new BrowserTab();
    }

    public BrowserTab getActiveTab() {
        return activeTab;
    }

    // Close current tab
    public void closeTab() {
        closedTabs.push(activeTab);
        activeTab = new BrowserTab();
        System.out.println("Tab closed.");
    }

    // Restore last closed tab
    public void restoreTab() {
        if (closedTabs.isEmpty()) {
            System.out.println("No closed tabs to restore.");
            return;
        }
        activeTab = closedTabs.pop();
        System.out.println("Tab restored. Current page: " + activeTab.getCurrentPage());
    }
}

// Main class
public class BrowserBuddy {
    public static void main(String[] args) {

        BrowserManager manager = new BrowserManager();
        BrowserTab tab = manager.getActiveTab();

        tab.visit("google.com");
        tab.visit("github.com");
        tab.visit("stackoverflow.com");

        tab.back();
        tab.back();
        tab.forward();

        manager.closeTab();

        manager.restoreTab();

        tab = manager.getActiveTab();
        tab.forward();
    }
}
