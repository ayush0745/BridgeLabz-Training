import java.util.*;

public class InvertMap {

	public static <K, V> Map<V, List<K>> invert(Map<K, V> map) {
		Map<V, List<K>> invertMap = new HashMap<V, List<K>>();
		for (Map.Entry<K, V> m : map.entrySet()) {
			if (!invertMap.containsKey(m.getValue())) {
				invertMap.put(m.getValue(), new ArrayList<K>());
			}
			invertMap.get(m.getValue()).add(m.getKey());
		}
		return invertMap;
	}

	public static void main(String[] args) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("A", 1);
		map.put("B", 2);
		map.put("C", 1);
		System.out.println(invert(map));
	}

}