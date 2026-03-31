import java.util.*;

public class GenerateBinary {

	public static List<String> generateBinaryNumbers(int n) {
		List<String> result = new ArrayList<String>();
		if (n <= 0) {
			return result;
		}
		Queue<String> queue = new LinkedList<String>();
		queue.add("1");
		for (int i = 0; i < n; i++) {
			String front = queue.poll();
			result.add(front);
			queue.offer(front + "0");
			queue.offer(front + "1");
		}
		return result;
	}

	public static void main(String[] args) {
		
		int n = 5;
		System.out.println(generateBinaryNumbers(n));
	}

}