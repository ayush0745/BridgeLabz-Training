import java.util.*;

public class ReverseQueue {

	public static <T> void reverseQueue(Queue<T> queue) {
		if (queue.isEmpty()) {
			return;
		}

		T front = queue.poll();
		reverseQueue(queue);
		queue.offer(front);
	}

	public static void main(String[] args) {
		
		Queue<Integer> queue = new LinkedList<Integer>(Arrays.asList(10, 20, 30));
		reverseQueue(queue);
		System.out.println(queue);
	}

}