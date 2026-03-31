import java.util.HashMap;
import java.util.Map;

public class MaxKey {

	public static String findMaxKey(Map<String, Integer> map) {
		int max = 0;
		String maxKey = "";
		for (Map.Entry<String, Integer> m : map.entrySet()) {
			if (m.getValue() > max) {
				max = m.getValue();
				maxKey = m.getKey();
			}
		}
		return maxKey;
	}

	public static void main(String[] args) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("A", 10);
		map.put("B", 20);
		map.put("C", 15);
		System.out.println(findMaxKey(map));
	}

}