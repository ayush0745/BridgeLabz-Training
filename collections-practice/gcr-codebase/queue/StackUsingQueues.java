import java.util.LinkedList;
import java.util.Queue;

class Stack<T> {
	Queue<T> q1 = new LinkedList<>();
	Queue<T> q2 = new LinkedList<>();

	void push(T x) {
		q2.offer(x);
		while (!q1.isEmpty()) {
			q2.offer(q1.poll());
		}

		while (!q2.isEmpty()) {
			q1.offer(q2.poll());
		}
	}

	T pop() {
		if (q1.isEmpty()) {
			System.out.println("Stack is Empty");
			return null;
		}
		return q1.poll();
	}

	T peek() {
		if (q1.isEmpty()) {
			System.out.println("Stack is Empty");
			return null;
		}
		return q1.peek();
	}

	boolean isEmpty() {
		return q1.isEmpty();
	}
}

public class StackUsingQueues {

	public static void main(String[] args) {
	
		Stack<Integer> stack = new Stack<>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		System.out.println("Top: " + stack.peek());
		System.out.println("Pop: " + stack.pop());
		System.out.println("Is Empty? " + stack.isEmpty());
		System.out.println("Pop: " + stack.pop());
		System.out.println("Pop: " + stack.pop());
		System.out.println("Is Empty? " + stack.isEmpty());
	}

}