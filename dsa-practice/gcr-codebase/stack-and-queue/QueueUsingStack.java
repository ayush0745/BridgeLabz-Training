import java.util.Stack;

class MyQueue {

    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    // Enqueue operation
    public void enqueue(int x) {
        stackIn.push(x);
        System.out.println(x + " enqueued");
    }

    // Dequeue operation
    public int dequeue() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }

        if (stackOut.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        return stackOut.pop();
    }

    // Peek front element
    public int peek() {
        if (stackOut.isEmpty()) {
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
        }

        if (stackOut.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        return stackOut.peek();
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return stackIn.isEmpty() && stackOut.isEmpty();
    }
}

public class QueueUsingStack {
    public static void main(String[] args) {

        MyQueue queue = new MyQueue();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Front element: " + queue.peek());
        System.out.println("Dequeued: " + queue.dequeue());

        System.out.println("Is queue empty? " + queue.isEmpty());

        queue.dequeue();
        System.out.println("Is queue empty? " + queue.isEmpty());
    }
}
