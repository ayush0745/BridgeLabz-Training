class StageNode {
    String stageName;
    StageNode next;

    public StageNode(String stageName) {
        this.stageName = stageName;
        this.next = null;
    }
}

class Stages {
    private StageNode head;

    // Add initial or next stage (at end)
    public void addStage(String stageName) {
        StageNode newNode = new StageNode(stageName);

        if (head == null) {
            head = newNode;
            return;
        }

        StageNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Add custom intermediate checkpoint
    public void addCheckpoint(String afterStage, String newStage) {
        StageNode temp = head;

        while (temp != null && !temp.stageName.equals(afterStage)) {
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Stage not found: " + afterStage);
            return;
        }

        StageNode newNode = new StageNode(newStage);
        newNode.next = temp.next;
        temp.next = newNode;
    }

    // Forward tracking through stages
    public void trackForward() {
        if (head == null) {
            System.out.println("No tracking information available.");
            return;
        }

        StageNode temp = head;
        while (temp != null) {
            System.out.print(temp.stageName);
            if (temp.next != null) {
                System.out.print(" → ");
            }
            temp = temp.next;
        }
        System.out.println();
    }

    // Handle lost/missing parcel
    public void markLost(String stageName) {
        StageNode temp = head;

        while (temp != null && !temp.stageName.equals(stageName)) {
            temp = temp.next;
        }

        if (temp != null) {
            temp.next = null;
            System.out.println("Parcel lost after stage: " + stageName);
        }
    }

    // Check if delivered
    public boolean isDelivered() {
        StageNode temp = head;
        while (temp != null) {
            if ("Delivered".equals(temp.stageName) && temp.next == null) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
}
public class ParcelTracker {
    public static void main(String[] args) {

        Stages tracker = new Stages();

        tracker.addStage("Packed");
        tracker.addStage("Shipped");
        tracker.addStage("In Transit");
        tracker.addStage("Delivered");

        tracker.addCheckpoint("Shipped", "Custom Checkpoint");

        tracker.trackForward();

        tracker.markLost("In Transit");

        tracker.trackForward();

        System.out.println("Delivered: " + tracker.isDelivered());
    }
}
