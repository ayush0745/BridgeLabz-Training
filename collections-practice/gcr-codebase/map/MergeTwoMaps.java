
import java.util.HashMap;
import java.util.Map;

public class MergeTwoMaps {

	public static Map<String, Integer> mergeMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
		Map<String, Integer> ans = new HashMap<String, Integer>();
		for (Map.Entry<String, Integer> m : map1.entrySet()) {
			ans.put(m.getKey(), m.getValue());
		}

		for (Map.Entry<String, Integer> m : map2.entrySet()) {
			ans.put(m.getKey(), ans.getOrDefault(m.getKey(), 0) + m.getValue());
		}
		return ans;
	}

	public static void main(String[] args) {
		
		Map<String, Integer> map1 = new HashMap<String, Integer>();
		map1.put("A", 1);
		map1.put("B", 2);
		Map<String, Integer> map2 = new HashMap<String, Integer>();
		map2.put("B", 3);
		map2.put("D", 4);
		System.out.println(mergeMaps(map1, map2));
	}

}